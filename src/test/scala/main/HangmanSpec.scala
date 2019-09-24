package main

import org.scalatest.words._
import org.scalatest.Tag
import org.scalatest._
import model.Hangman

import scala.util.Random

case class CaseId(id: Int) {
  override def toString: String = {
    id + " "
  }
}
object TagRegress extends Tag("Regress")

class HangmanSpec extends ShouldVerb with FlatSpecLike {
  CaseId(1) + "Word selector" should "check existing of selected word in library" taggedAs TagRegress in {
    val word = Hangman.getWord().mkString("")
    val library = params.library
    assert(library.contains(word) ,"selected word is not in library")
  }

  CaseId(2) + "Init result" should "have the same length as selected word" taggedAs TagRegress in {
    val word = Hangman.getWord()
    val initResult = Hangman.getInitResult(word)
    assert(word.length == initResult.length, "length of word from ´*´ is not the same as selected word length")
  }

  CaseId(3) + "Apply letter" should "should give right middle result" taggedAs TagRegress in {
    val word = Hangman.getWord()
    val initResult = Hangman.getInitResult(word)
    val random = new Random
    val letter = word.apply(random.nextInt(word.length))
    val updatedResult = Hangman.applyLetter(word, initResult, letter)
    val currentUpdatedResult = word.zipWithIndex.map { wordLetter =>
      if (wordLetter._1 == letter) letter
      else '*'
    }
    assert(updatedResult == currentUpdatedResult, "letter applies wrong")
  }
}
