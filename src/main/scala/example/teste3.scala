package example

object teste3 extends App {

    def markAns(a: String) : Option[Boolean] ={
      if (a.nonEmpty){
        Some(a == "dog")
      }else None
    }

  val scoreForQ1 : Option[Boolean] = markAns("doggy")
  println(scoreForQ1)

  if (scoreForQ1.isDefined){
    val score = scoreForQ1.getOrElse(false)
    println(score)
  }

  scoreForQ1.map(
    b => b
  )

  scoreForQ1.fold(false)(b => {println(s"$b ** LINE 23")
    b})

  scoreForQ1 match {
    case None => ???
    case Some(x) => x
  }
}
