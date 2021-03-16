package Exercise

import u03.Lists.List
import u03.Lists.List.{Cons, Nil}

import scala.annotation.tailrec

object FoldOver {

  @tailrec
  def foldLeft[A,B](lst: List[A])(acc: A)(f: (A, A) => A): A = lst match {
    case Cons(head, tail) => foldLeft(tail)(f(acc,head))(f)
    case _ => acc
  }

  def foldRight[A,B](lst: List[A])(acc: A)(f: (A, A) => A): A = lst match {
    case Cons(head, Nil()) => f(head, acc)
    case Cons(head, tail) => f(head, foldRight(tail)(acc)(f))
  }
}
