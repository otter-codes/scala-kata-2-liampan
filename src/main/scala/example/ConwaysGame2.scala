package example

import scala.io.StdIn

object ConwaysGame2 extends App {


  val T = true // ALIVE
  val F = false // DEAD

  // 16 step oscillator config:

  var board = Array(
    Array(F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, T, T, F, F, F, T, T, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, T, T, F, T, F, T, F, T, T, F, F, F, F, F, F, F),
    Array(F, F, F, F, T, T, T, F, T, F, T, F, T, T, T, F, F, F, F, F, F),
    Array(F, F, F, T, F, F, F, T, T, F, T, T, F, F, F, T, F, F, F, F, F),
    Array(F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F),
    Array(F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, T, T, F, T, T, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, T, F, T, F, T, F, T, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F),
    Array(F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F)
  )

  var RefBoard = Array.fill[Array[Boolean]](board.length)(Array.fill[Boolean](board(0).length)(F))


  val height = board.length - 2
  val width = board(0).length - 2

  var x = 1
  var y = 1


  def printBoard = {
    board.foreach(row => {
      row.foreach(cell => {
        print(s"${if (cell == T) "▣" else "□"} ")
      })
      println()
    })

  }

  def squareCheck(y: Int, x: Int): Boolean = {
    if ((x >= 1 && x <= width) || (y >= 1 && y <= height)) {
      findLiveAndDecide(y, x)
    }
    else
      false
  }

  def findLiveAndDecide(y: Int, x: Int): Boolean = {
    val state = board(y)(x)
    val neighbors: List[Boolean] = board(y + 1)(x - 1) :: board(y + 1)(x) :: board(y + 1)(x + 1) :: board(y)(x - 1) :: board(y)(x + 1) :: board(y - 1)(x - 1) :: board(y - 1)(x) :: board(y - 1)(x + 1) :: Nil
    val LiveNeighbors = neighbors.count(l => l)
    if (state) {
      if (LiveNeighbors < 2) false // dies of underpopulation
      else if (LiveNeighbors == 2 || LiveNeighbors == 3) true // lives on until next turn
      else false // dies of over population
    }
    else {
      if (LiveNeighbors == 3) {
        true
      } // becomes alive as if due to reproduction
      else false // remain dead
    }

  }


  def conwayLoop(y: Int, x: Int): Unit = {

    RefBoard(y)(x) = squareCheck(y, x)

    if (x == width && y == height) {
      board = RefBoard
      nextStep
    }
    else if (x < width) {
      conwayLoop(y, x + 1)
    }
    else if (x == width) {

      conwayLoop(y + 1, 1)

    }
  }

  def nextStep: Unit = {  // resets all vars, waits half a second and runs the loop again
    Thread.sleep(500)
    printBoard
    y = 1
    x = 1
    RefBoard = Array.fill[Array[Boolean]](board.length)(Array.fill[Boolean](board(0).length)(F))
    conwayLoop(y, x)

  }

  printBoard
  nextStep

}
