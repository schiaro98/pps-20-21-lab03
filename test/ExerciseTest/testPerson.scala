package ExerciseTest

import Exercise.personTask.coursesOf
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u02.Modules.Person
import u03.Lists.List.{Cons, Nil}

class testPerson {

  private val bravetti: Person = Person.Teacher("Bravetti", "LCMC")
  private val omicini: Person = Person.Teacher("Omicini", "SD")
  private val golfarelli: Person = Person.Teacher("Golfarelli", "SI")

  //private val teacherList = Cons(bravetti, Cons(omicini, Cons(golfarelli, Nil())))

  @Test
  def testCoursesOfTeacher(){
    assertEquals(Cons("LCMC", Cons("SD", Nil())), coursesOf(Cons(bravetti, Cons(omicini, Nil()))))
    assertEquals(Cons("LCMC", Cons("SD", Cons("SI", Nil()))), coursesOf(Cons(bravetti, Cons(omicini, Cons(golfarelli, Nil())))))
    assertEquals(Cons("LCMC", Nil()), coursesOf(Cons(bravetti, Nil())))
  }
}
