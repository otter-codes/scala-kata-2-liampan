package example

object teste2 extends App {

  val CorrectAns = List("a","b","c","d")
  val StuAns = List("a", "b", "d","")

  val kevin = CorrectAns.zip(StuAns)

  def Check(ans: (String, String)):Int = {
    if (ans._2 == ""){0}
    else if (ans._1 == ans._2){4}
    else {-1}

  }


  println(kevin.map(x => Check(x)))

  val score = kevin.map(x => Check(x)).sum

  println(score)


}
