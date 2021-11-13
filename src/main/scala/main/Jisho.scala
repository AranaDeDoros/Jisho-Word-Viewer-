package jisho

/*object Jisho extends App {

  import jisho.models.koto.JpnWord

  val jpnObj = new JpnWord("ore").lookup.toString
  println(jpnObj)

  import jisho.common.Implicits.strToWord
  val jpnImplicit = "僕は友達が少".lookup
  println(jpnImplicit)

}
*/

object Jisho{

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


}