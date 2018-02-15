package example



object teste extends App {

  val CorrectAns = List("a", "b", "c", "d")
  var x = 0
  var score = 0

  def CheckAns(StuAns: List[String]): Int = {
    if (x == CorrectAns.length) {
      score
    }
    else if (StuAns(x) == "") {
      x = x + 1
      score
      CheckAns(StuAns)
    }
    else if (CorrectAns(x) == StuAns(x)) {
      x = x + 1
      score = score + 4
      CheckAns(StuAns)
    }
    else {
      x = x + 1
      score = score - 1
      CheckAns(StuAns)
    }
  }

  val input = List("a", "b", "b", "") // +4 +4 -1 +0 = 7


  println(CheckAns(input))
}

