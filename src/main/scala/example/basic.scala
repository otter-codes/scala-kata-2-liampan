package example

object basic extends App {

  val StartNum: Int = 21
  var x = 1
  var list = List(StartNum)

  def collartz(num: Int):Int={
    x = x+1
    list = num :: list
    if (num == 1) {x-1}
    else if (num % 2 == 0) {
      collartz(num / 2)
    }
    else {
      collartz((num * 3)+1)
    }
  }

    println(s"answer is ${collartz(StartNum)}")
    println(list)

}
