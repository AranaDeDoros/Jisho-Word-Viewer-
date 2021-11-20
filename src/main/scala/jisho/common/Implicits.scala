package jisho.common

import jisho.models.koto._

object Implicits {

  implicit class WordInterpolator(sc: StringContext) {

    def jpn(args: Any*): JpnWord = {
      new JpnWord(sc.parts.mkString)
    }
    def eng(args: Any*): EngWord = {
      new EngWord(sc.parts.mkString)

    }
  }

  implicit def strToWord[A <: Word](str: String): Word = {
    val word = str match {
      case s if (Utils.isJapaneseString(s)) => new JpnWord(str)
      case _                                => new EngWord(str)
    }
    word
  }
}
