package jisho.models.lang

import scala.collection.immutable.HashMap

case class Kana(kana: String, furiganaReading: Option[String]) {
  val furigana = this.furiganaReading match {
    case Some(f) => f
    case None    => ""
  }
}

case class Definition(meanings: String)
//case class Entry(kanaObj:Kana, definition: Definition)

case class Dict() {
  var entries = HashMap[Kana, Definition]()
  def addEntries(
    entry: HashMap[Kana, Definition]
  ): HashMap[Kana, Definition] = {
    entries ++ entry
  }
}
