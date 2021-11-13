package jisho.models.koto

import jisho.query.WordQueryResult
import jisho.models.result.JpnWordResult

trait Word {
  val term: String
  def lookup: WordQueryResult[JpnWordResult]
}
