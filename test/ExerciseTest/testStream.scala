package ExerciseTest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u03.Streams.Stream
import u03.Lists.List.{Cons, Nil}
import u03.Streams.Stream.{constant, fibs}

class testStream {

  @Test
  def testDrop(): Unit ={
    val s = Stream.take(Stream.iterate(0)(_+1))(10) //{0,1,2,...,8,9}
    val listToBeDropped = Stream.toList(Stream.drop(s)(6))
    val droppedList = Cons(6, Cons(7, Cons(8, Cons(9, Nil()))))
    assertEquals(droppedList, listToBeDropped)
  }

  @Test
  def testConstant(): Unit ={
    val constantList = Cons("x", Cons("x", Cons("x", Cons("x", Cons("x", Nil())))))
    val constantResult = Stream.toList(Stream.take(constant("x"))(5))
    val constantList2 = Cons("x", Nil())
    assertEquals(constantResult, constantList)
    assertEquals(Stream.toList(Stream.take(constant("x"))(1)), constantList2)
  }

  @Test
  def testFibonacci(): Unit ={
    val fibList = Stream.toList(Stream.take(fibs)(8))
    val result = Cons(0,Cons(1, Cons(1, Cons(2, Cons(3, Cons(5, Cons(8, Cons(13, Nil()))))))))
    assertEquals(fibList, result)
  }
}
