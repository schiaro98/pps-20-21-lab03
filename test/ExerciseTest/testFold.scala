package ExerciseTest

import Exercise.FoldOver.{foldLeft, foldRight}
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u03.Lists.List.{Cons, Nil}

class testFold {

  private val lst = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))
  private val lstOfOne = Cons(1, Nil())

  @Test
  def testFoldLeft() {
    assertEquals(-16, foldLeft(lst)(0)(_-_))
    assertEquals(16, foldLeft(lst)(0)(_+_))
    assertEquals(-1, foldLeft(lstOfOne)(0)(_-_))
    assertEquals(1, foldLeft(lstOfOne)(0)(_+_))
  }

  @Test
  def testFoldRight(): Unit ={
    assertEquals(-8,foldRight(lst)(0)(_-_))
    assertEquals(16, foldRight(lst)(0)(_+_))
    assertEquals(1, foldRight(lstOfOne)(0)(_-_))
    assertEquals(1, foldRight(lstOfOne)(0)(_+_))
  }

}
