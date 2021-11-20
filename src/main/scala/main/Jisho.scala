package jisho

import java.nio.charset.Charset
import jisho.models.koto.EngWord

object Jisho extends App {

  import jisho.models.koto.JpnWord

  val jpnObj = new JpnWord("car").lookup.toString
  //println(jpnObj)

  val engObj = new EngWord("rain").lookup.toString
  //println(engObj)

  import jisho.common.Implicits._
  val jpnImplicit = "友達".lookup
  //println(jpnImplicit)

  val engImplicit = "dog".lookup
  //println(engImplicit)

  //val engUsingInterpolator = eng"car".lookup.toString
  val jpnUsingInterpolator = jpn"血液".lookup.toString
  //println(engUsingInterpolator)
  println(jpnUsingInterpolator)
}


/*object Jisho{

def main(args:Array[String]) = {
  ask()

  import scala.annotation.tailrec
  @tailrec
  def ask(): Unit = {
   while (true) {
       println("Enter a word")
       try{
       val input : String = scala.io.StdIn.readLine()
       import jisho.common.Implicits.strToWord
       val res = input.lookup.toString
       printf("%75s",res)
     } catch {
       case e : Exception => {
        /*println(e.printStackTrace())*/
        println("またね！")
        return
       }
     }
    }
    ask()
   }
}


}*/