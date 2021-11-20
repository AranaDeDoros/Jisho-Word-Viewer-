package jisho.models.lang

import scala.collection.immutable.HashMap

case class Kana(kana: String, furiganaReading: String) {
  val furigana = this.furiganaReading
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
