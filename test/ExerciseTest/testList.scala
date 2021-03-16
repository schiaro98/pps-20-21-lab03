package ExerciseTest

import u03.Lists.List._
import Exercise.ListTask._
import org.junit.jupiter.api.Assertions.{assertEquals, assertNotEquals}
import org.junit.jupiter.api.Test
import u02.Optionals.Option.{None, Some}

class testList {
  private val lst = Cons(10, Cons(20, Cons(30, Nil())))
  private val lstPlusOne = Cons(11, Cons(21, Cons(31, Nil())))
  private val lstFlatAdded = Cons(11, Cons(12, Cons(21, Cons(22, Cons(31, Cons(32, Nil()))))))
  private val lstMultTen = Cons(100, Cons(200, Cons(300, Nil())))

  @Test
  def testDrop(){
    assertEquals(Cons(20, Cons(30, Nil())), drop(lst,1))
    assertEquals(Cons(30, Nil()), drop(lst,2))
    assertEquals(Nil(), drop(lst,3))
    assertEquals(Nil(), drop(lst,4))
    assertEquals(Nil(), drop(lst,5))
  }

  @Test
  def testFlatMap(){
    assertEquals(flatMap(lst)(v => Cons(v+1, Nil())), lstPlusOne)
    assertEquals(flatMap(lst)(v => Cons(v+1, Cons(v+2, Nil()))), lstFlatAdded)
    assertEquals(flatMap(lst)(v => Cons(v*10, Nil())), lstMultTen)
  }

  @Test
  def testMapUsingFlatmap(){
    assertEquals(mapUsingFlatmap(lst)(v => v+1), lstPlusOne)
    assertEquals(mapUsingFlatmap(lst)(v => v*10), lstMultTen)
  }

  @Test
  def testFilterUsingFlatmap(){
    assertEquals(Cons(20,Cons(30, Nil())),filterUsingFlatmap(lst)(_>10))
    assertEquals(Cons(30, Nil()),filterUsingFlatmap(lst)(_>20))
    assertEquals(Nil(),filterUsingFlatmap(lst)(_>30))
  }

  @Test
  def testMax(){
    val test = Cons(1, Cons(0, Cons(8, Cons(12, Cons(4, Cons(9, Nil()))))))
    assertEquals(None(), max(Nil()))
    assertEquals(Some(30), max(lst))
    assertEquals(Some(31), max(lstPlusOne))
    assertNotEquals(Some(10), max(lst))
    assertEquals(Some(12), max(test))
  }
}
