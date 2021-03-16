package Exercise

import u02.Modules.Person
import u02.Modules.Person.Teacher
import u03.Lists.List
import Exercise.ListTask.mapUsingFlatmap

object personTask {
  //Simplest solution
  /*def coursesOf(l: List[Person]): List[String] = l match {
    case Cons(Teacher(_, course), tail) => Cons(course, coursesOf(tail))
    case Cons(Teacher(_, course), Nil()) => Cons(course, Nil())
    case _ => Nil()
  }*/

  def coursesOf(l: List[Person]): List[String] = mapUsingFlatmap(l)(x => getCourseName(x))

  //Funzione di mapping
  def getCourseName(teacher: Person): String = teacher match {
    case Teacher(_, n) => n
    case _ => null
  }
}
