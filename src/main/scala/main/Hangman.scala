package main

import params._
import scala.util.Random

object Hangman extends App {
  val flag = true
  val words = params.library
  val random = new Random
  val word = words(
    random.nextInt(words.length)
  )
//  while (flag) {
//
//  }
  println(word)

}
