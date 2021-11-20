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
[info] (けつえきない) 血液内科 | haematology; hematology
[info] (けつえき) 血液中 | within the blood; blood-borne
[info] (けつえきのうかんもん) 血液脳関門 | blood-brain barrier
[info] (けつえきがた) 血液型 | blood type; blood group
[info] (NA) 血液検査の参考基準値 | Reference ranges for blood tests
[info] (けつえき) 血液病 | hematological disease; haematological disease
[info] (けつえきかん) 血液循環 | blood circulation
[info] (けつえきとうせき) 血液透析 | hemodialysis; haemodialysis
[info] (けつえきぎんこう) 血液銀行 | blood bank
[info] (けつえきとう) 血液中の糖 | blood sugar
[info] (けつえき) 血液ドーピング | blood doping
[info] (けつえきせいざい) 血液製剤 | blood products
[info] (けつえきけん) 血液検査 | blood test; hemanalysis
[info] (けつえきがく) 血液学 | hematology
[info] (けつえき) 血液 | blood
[info] (けつえき) 血液恐怖症 | hemophobia; haemophobia; blood phobia
[info] (けつえき) 血液ガス | blood agent
...
```
## Pending

-  Add support for okurigana.
-  Accept japanese input from the command line.
-  Add support for phrases and not just words.