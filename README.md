# Jisho Word Viewer

View a word or japanese character meaning along with its definition.

## Usage

You can use it the classic OOP way.

```scala
import jisho.models.koto.JpnWord
val jpnObj = new JpnWord("ore").lookup.toString
println(jpnObj)
```

Or via implicit conversions.
```scala
import jisho.common.Implicits.strToWord
val jpnImplicit = "友達".lookup
println(jpnImplicit)
```