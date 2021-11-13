package jisho.common

import jisho.models.koto._

object Implicits {
  implicit def strToWord[A <: Word](str: String): Word = {
    val word = str match {
      case s if (Utils.isJapaneseString(s)) => new JpnWord(str)
      case _                                => new EngWord(str)
    }
    word
  }
}
