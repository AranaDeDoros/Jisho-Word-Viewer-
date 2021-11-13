# Jisho Word Viewer

View a word or japanese character meaning along with its reading.

## Usage

You can use it the classic OOP way.

```scala
val jpnObj = new JpnWord("ore").lookup.toString
println(jpnObj)

val engObj = new EngWord("rain").lookup.toString
println(engObj)
```

Or via implicit conversions.

```scala
import jisho.common.Implicits.strToWord
val jpnImplicit = "僕は友達が少".lookup
println(jpnImplicit)

val engImplicit = "dog".lookup
println(engImplicit)
```

## Pending

Accept japanese input from the command line.