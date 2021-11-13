package jisho.models.koto

import jisho.query.JishoQueryBuilder
import jisho.query.WordQueryResult
import jisho.models.result.JpnWordResult

class JpnWord(jpnStr: String) extends Word {
  val term                       = this.jpnStr
  val builder: JishoQueryBuilder = new JishoQueryBuilder()
  def lookup: WordQueryResult[JpnWordResult] = {
    builder.make(this)
  }
}
