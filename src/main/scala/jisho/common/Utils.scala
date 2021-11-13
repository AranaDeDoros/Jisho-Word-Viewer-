package jisho.common

import scala.util.matching.Regex

object Utils {
  val jpnUnicodeRegex =
    "([\u3000-\u303F]|[\u3040-\u309F]|[\u30A0-\u30FF]|[\uFF00-\uFFEF]|[\u4E00-\u9FAF]|[\u2605-\u2606]|[\u2190-\u2195]|\u203B/)+".r
  def isJapaneseString(str: String): Boolean = jpnUnicodeRegex.matches(str)
}
