package Exercise

import u03.Lists.List
import u03.Lists.List.{Cons, Nil, append, filter, map}
import u02.Optionals.Option

import scala.annotation.tailrec

object ListTask {

  @tailrec
  def drop[E](lst: List[E], n: Int): List[E] = lst match {
    case Cons(_, t) if n==1 => t
    case Cons(_, t) => drop(t, n-1)
    case _ => Nil()
  }

  def flatMap[A,B](lst: List[A])(f: A => List[B]): List[B] = lst match {
    case Cons(h, t) => append(f(h),flatMap(t)(f))
    case _ => Nil()
  }

  def mapUsingFlatmap[A,B](l: List[A])(mapper: A=>B): List[B] =
    flatMap(l)(x => Cons(mapper(x),Nil()))

  def filterUsingFlatmap[A](l1: List[A])(pred: A=>Boolean): List[A] = l1 match {
    case Cons(h,t) if pred(h) => Cons(h, filterUsingFlatmap(t)(pred))
    case Cons(_,t) => filterUsingFlatmap(t)(pred)
    case Nil() => Nil()
  }

  @tailrec
  def max(l: List[Int]) : Option[Int] = l match {
    case Cons(h, Nil()) => Option.Some(h) //Lista di un solo elemento
    case Cons(head, Cons(tail, Nil())) => if (head>tail) Option.Some(head) else Option.Some(tail)
    case Cons(h, t) => max(List.filter(t)(_>h)) //
    case Nil() => Option.None() //Lista vuota
  }
}
