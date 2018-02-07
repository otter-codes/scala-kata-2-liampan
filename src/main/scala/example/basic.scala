package example

object basic extends App {

  val StartNum: Int = 20
  var x = 1

  def collartz(num: Int)={
    x = x+1
    if (num == 1) {s"done in $x"}
    else if (num % 2 == 0) {
      collartz(num / 2)
    }
    else {
      collartz((num * 3)+1)
    }
  }

    println(collartz(StartNum))


}
