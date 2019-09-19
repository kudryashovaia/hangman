package main

import scala.util.Random
import scala.io.StdIn._

object Hangman extends App {
  var mistakeCount: Int = 0
  val words = params.library
  val random = new Random
  val word = words(
    random.nextInt(words.length)
  ).toList
  var currentResult = List.fill(word.length)('*')
  while (mistakeCount < 5 && currentResult.contains('*'))  {
    println("Guess a letter:")
    val letter = readChar()
    if (word.contains(letter)) {
      println("Hit!")
      word.zipWithIndex.map { wordLetter =>
        println( s"${wordLetter.toString()}")
        if (wordLetter._1 == letter) currentResult = currentResult.updated(wordLetter._2, letter)

      }
      println(s"The word: ${currentResult.mkString("")}")
    } else {
      mistakeCount += 1
      println(s"Missed, mistake $mistakeCount out of 5.")
      println(s"The word: ${currentResult.mkString("")}")
    }
  }

  if (currentResult.contains('*')) println("You lost!")
  else println("You won!")


}
