package model

import scala.util.Random
import scala.io.StdIn._

trait Library {
  var library = Array(
    "vase",
    "hot",
    "desire",
    "busy",
    "borrow",
    "charming",
    "skate",
    "impolite",
    "whip",
    "creepy"
  )
}

object Hangman extends App with Library {

  def getWord(): List[Char]  = {
    val random = new Random()
    library(
      random.nextInt(library.length)
    ).toList
  }

  def getInitResult(word: List[Char]): List[Char] = {
    List.fill(word.length)('*')
  }

  def applyLetter(word: List[Char], currentResult: List[Char], letter: Char): List[Char] = {
    var updatedResult: List[Char] = currentResult
    if (word.contains(letter)) {
      var flagGuessed = false
      println("Hit!")
      updatedResult = word.zipWithIndex.map { wordLetter =>
        if (wordLetter._1 == letter && updatedResult(wordLetter._2) == '*') letter
        else if (wordLetter._1 == letter && updatedResult(wordLetter._2) == letter) {
          flagGuessed = true
          letter
        }
        else if (updatedResult(wordLetter._2) != '*') updatedResult(wordLetter._2)
        else '*'
      }
      if (flagGuessed)
        println("You've guessed this letter before")
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
    currentResult = applyLetter(word, currentResult, letter)
  }

  if (currentResult.contains('*')) println("You lost!")
  else println("You won!")

}
