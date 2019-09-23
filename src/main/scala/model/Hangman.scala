package model

import scala.util.Random
import scala.io.StdIn._


object Hangman extends App {

  def getWord() = {
    val random = new Random
    params.library(
      random.nextInt(params.library.length)
    ).toList
  }

  def getInitResult(word: List[Char]) = {
    List.fill(word.length)('*')
  }

  def applyLetter(word: List[Char], currentResult: List[Char], letter: Char) = {
    var updatedResult: List[Char] = currentResult
    if (word.contains(letter)) {
      println("Hit!")
      word.zipWithIndex.map { wordLetter =>
        println( s"${wordLetter.toString()}")
        if (wordLetter._1 == letter) updatedResult = currentResult.updated(wordLetter._2, letter)

      }
      println(s"The word: ${updatedResult.mkString("")}")
    } else {
      mistakeCount += 1
      println(s"Missed, mistake $mistakeCount out of 5.")
      println(s"The word: ${updatedResult.mkString("")}")
    }
    updatedResult
  }

  var mistakeCount: Int = 0

  val word = getWord()

  var currentResult = getInitResult(word)

  while (mistakeCount < 5 && currentResult.contains('*'))  {
    println("Guess a letter:")
    val letter = readChar()
    applyLetter(letter)
  }

  if (currentResult.contains('*')) println("You lost!")
  else println("You won!")

}
