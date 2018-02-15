package example

object ConwaysGame extends App {

  val T = true
  val F = false

  var board = Array(
    Array(F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F),
    Array(F, F, T, F, F, F, F, T, F, F),
    Array(F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, T, F, F, F, F, F),
    Array(F, F, F, F, T, F, F, F, F, F),
    Array(F, T, F, F, F, F, F, F, T, F),
    Array(F, F, T, T, T, T, T, T, F, F),
    Array(F, F, F, F, F, F, F, F, F, F),
  )
  val RefBoard = Array(
    Array(F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F),
  )



  val height = board.length
  val width = board(height).length

  var x = 1
  var y = 1

  def printBoard = {
    board.foreach(row => {
      row.foreach(cell => {
        print(s"${if (cell == T) "■" else "□"} ")
      })
      println()
    })
  }

  def got8Nbors(y: Int, x: Int) = {
    if (x <= 0 || y <= 0 || x >= width || y >= height) makeNewBoard(y,x,false) // fell off the world or some shit - could implement wrapping if y == 0, y = height -1
    else findLiveNbors(y, x)
  }

  def findLiveNbors(y: Int, x: Int) = {
    val state = board(y)(x)
    val neighbors: List[Boolean] = board(y + 1)(x - 1) :: board(y + 1)(x) :: board(y + 1)(x + 1) :: board(y)(x - 1) :: board(y)(x + 1) :: board(y - 1)(x - 1) :: board(y - 1)(x) :: board(y - 1)(x + 1) :: Nil
    val LiveNeighbors = neighbors.count(l => l)
    LiveOrDie(LiveNeighbors, state, y, x)

  }

  def LiveOrDie(int: Int, state: Boolean,y:Int,x:Int) = {
    if (state) {
      if (int <= 1) makeNewBoard(y,x, false) // underpopulation
      else if (int == 2 || int == 3) makeNewBoard(y,x,true) // lives on until next turn
      else makeNewBoard(y,x,false) // over population
    }
    else if (int == 3) makeNewBoard(y,x,true) // becomes alive reproduction
    else makeNewBoard(y,x,false) // remain dead

  }



  def makeNewBoard(y:Int,x:Int,state:Boolean) = {
    RefBoard(y)(x) = state
    if (x == width && y == height) {
      board = RefBoard
      printBoard}
    else if (x < width){}
     // got8Nbors(y,x+1)}
    else if (x == width){}
     // got8Nbors(y+1,0)}
    else {println("failure")}

  }


  println(height, width)
  got8Nbors(y, x)
  printBoard


}
