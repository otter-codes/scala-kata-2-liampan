package example

object Collatz extends App {

  val StartNum:Int= 20
  val list: List[Int] = Nil

  def collartz(num :Int,list: List[Int]):(Int,List[Int]) = {
    if (num % 2 == 0){
      collect(num/2, list)}
    else{collect((num*3)+1,list)}
}
  def collect(num : Int, list: List[Int]):(Int,List[Int]) = {
    val p = num :: list
    if (p.head == 1){(p.length,p)}
    else {collartz(p.head,p)}
  }
println(s"It takes ${collect(StartNum,list)_1} calculations to convert $StartNum to 1 via collatz \n the process is as follows : ${(collect(StartNum,list)_2).reverse} ")
}
// this uses no mutable collections or values