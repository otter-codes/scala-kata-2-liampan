package example

object basic extends App {

  val StartNum: Int = 53
  var x = 1

  def collartz(num: Int):Int={
    x = x+1
    println(num)
    if (num == 1) {x-1}
    else if (num % 2 == 0) {
      collartz(num / 2)
    }
    else {
      collartz((num * 3)+1)
    }
  }

    println(s"answer is ${collartz(StartNum)}")


}
