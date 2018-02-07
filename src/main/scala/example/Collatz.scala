package example

object Collatz extends App {

  val StartNum = 20 :: Nil

  def collartz(num :Int): Int = {
    if 
  }

  def collect(list: List[Int], f: Int => Int): List[Int] ={
    list match {
      case Nil => list
      case head :: tail => f(head) :: collect(tail, f)
    }
  }





}

//def intMap2(list: List[Int], f: Int => Int): List[Int] = {
//  list match {
//  case Nil => list
//  case head :: tail => f(head) :: intMap2(tail, f)
//}
//}
//


// The	Collatz	Conjecture	states	that	for	any	natural	number	n,	if	n	is	even,	divide	it	by	2.	If	n	is	odd,multiply	it	by	3	and	add	1.	If	you	repeat	the	process	continously	for	n,youll eventually hit 1.

// or	example,	if	n	=	20,	the	resulting	sequence will be

// [20,	10,	5,	16,	8, 4, 3, 2, 1] === output

// Write	a	function	that	will	output	the	length	of	the	Collatz	Conjecture	for	any	given	n.	In	the	exampleabove,	the	output	would be 8   === output.length