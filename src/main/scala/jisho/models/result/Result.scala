package jisho.models.result

import jisho.models.lang._

case class JpnSentenceResult(sentence: String) extends Queryable

case class JpnWordResult(
    kana: Kana,
    definition: Definition
) extends Queryable
