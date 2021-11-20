package jisho.query

import jisho.models.result.JpnWordResult
import jisho.models.koto.{EngWord, JpnWord, Word}
import jisho.models.lang.{Definition, Dict, Kana}
import jisho.common.Utils

class JishoQueryBuilder extends QueryBuilder {

  val htmlScrapper = new JishoScrapper()

  def make(w: Word): WordQueryResult[JpnWordResult] =
    w match {
      case w: JpnWord => this.japaneseSearch(w)
      case w: EngWord => this.englishSearch(w)
    }

  def japaneseSearch(w: Word): WordQueryResult[JpnWordResult] = {
    this.genericSearch(w)
  }

  def englishSearch(w: Word): WordQueryResult[JpnWordResult] = {
    this.genericSearch(w)
  }

  private def genericSearch(w: Word): WordQueryResult[JpnWordResult] = {
    val jpnWordResults = htmlScrapper.scrap(w.term)
    if (!jpnWordResults.isEmpty) {
      new WordQueryResult(jpnWordResults)
    } else {
      new WordQueryResult(List.empty[JpnWordResult])
    }
  }

}

import scala.util.matching.Regex
import scala.language.implicitConversions

import net.ruippeixotog.scalascraper.browser.JsoupBrowser

class JishoScrapper {

  val browser = JsoupBrowser()
  val url     = "https://jisho.org/search/"
  val dict    = new Dict()

  import net.ruippeixotog.scalascraper.dsl.DSL._
  import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
  import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
  import net.ruippeixotog.scalascraper.model._
  import scala.collection.immutable.HashMap
  def scrap(str: String): List[JpnWordResult] = {

    val isJapanese   = Utils.isJapaneseString(str)
    val mainSelector = "#primary .concept_light.clearfix"

    val jisho = if (isJapanese) {
      browser.get(s"$url$str")
    } else {
      browser.get(s"""$url"$str"""")
    }
    val matches = jisho >> elementList(mainSelector)

    val entries = matches.foldRight(HashMap[Kana, Definition]())((a, b) => {
      val furiganaList = a >?> elementList(s"span.furigana > .kanji-2-up.kanji")

      val furiganaElements = furiganaList match {
        case Some(f) => f
        case None => List.empty[net.ruippeixotog.scalascraper.model.Element]
      }

      val furiganaStr = furiganaElements.map( _ >> text).mkString.trim

      val kana =
        a >> element(s".concept_light-representation span.text") >> text
      val meanings = a >> element(s".meaning-meaning") >> text
      val entry    = b + (new Kana(kana, furiganaStr) -> new Definition(meanings))
      entry
    })

    dict.entries = dict.addEntries(entries)

    val dictionary = dict.entries
    val jpnResults = for (entry <- dictionary) yield {
      new JpnWordResult(entry._1, entry._2)
    }
    jpnResults.toList
  }

}
