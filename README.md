# Jisho Word Viewer

View a word or japanese character meaning along with its reading. This is a WIP, and due to the nature of html scrapping, there's bound to be a lot of gotchas.

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
val jpnImplicit = "友達".lookup
println(jpnImplicit)

val engImplicit = "dog".lookup
println(engImplicit)
```

Or using string interpolators.
```scala
import jisho.common.Implicits._
val engUsingInterpolator = eng"car".lookup.toString
val jpnUsingInterpolator = jpn"血液".lookup.toString
```


Example of expected output:
```bash
[info] (よふ) 夜更け | late at night; small hours of the morning
[info] (やきん) 夜勤 | night shift
[info] (やはん) 夜半 | midnight; dead of night
[info] (やこう) 夜行 | walking around at night; night travel
[info] (よるおそ) 夜遅く | late at night; at a late hour
[info] (やかんがいしゅつきんしれい) 夜間外出禁止令 | curfew
[info] (よなか) 夜中 | middle of the night; dead of night
[info] (よどお) 夜通し | all night; throughout the night
[info] (NA) 夜 | counter for nights
[info] (よに) 夜逃げ | night flight (without paying); skipping out by night; moonlight flit
[info] (やかん) 夜間 | night; nighttime
[info] (よる) 夜 | evening; night
[info] (やしょく) 夜食 | supper; night meal; late-night snack; "fourth meal"; midnight snack
[info] (やぐ) 夜具 | bedding; bedclothes
[info] (よぞら) 夜空 | night sky
[info] (よあ) 夜明け | dawn; daybreak
[info] (やけい) 夜景 | night view; night skyline; nightscape
[info] (やこうせい) 夜行性 | nocturnality; nocturnal habits
[info] (よみち) 夜道 | street at night; making a night journey
[info] (よふ) 夜更かし | staying up late; keeping late hours; sitting up late at night; nighthawk
...
```
## Pending

-  Add support for okurigana.
-  Add support for wikipedia definitions.
-  Accept japanese input from the command line.
-  Add support for phrases and not just words.