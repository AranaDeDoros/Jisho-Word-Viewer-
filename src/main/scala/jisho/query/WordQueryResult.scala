package jisho.query

import jisho.models.result._

final class WordQueryResult[A <: Queryable](jpnWords: List[A])
    extends QueryResult[A] {

  val results: List[A] = jpnWords
  val nResults: Int    = results.length
  val isEmpty: Boolean = nResults > 0

  override def toString = {
    val list = this.results
    val asString = list.foldRight(List.empty[String])((a, b) => {
      val str = a match {
        case a: JpnWordResult =>
          //println(a.kana.furigana)
          val furiganaLength = a.kana.furigana.length()
          val furigana = if(furiganaLength > 1){
            s"(${a.kana.furigana})"
          } else {
            "(NA)"
          }
          s"$furigana ${a.kana.kana} | ${a.definition.meanings}\n"
        case a: JpnSentenceResult => s"\n"
      }
      b :+ str
    })
    asString.mkString
  }


}
