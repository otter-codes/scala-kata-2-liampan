package example

object genderless extends App {

//
//  case class User(name: String, gender: Option[String])
//  case class Employee(ID: Int, override val name: String, override val gender: Option[String]=None) extends User(name, gender)
//
//  object UserRep {
//    private val _people = List(
//      User("adam", Some("male"))
//      , User("Toni", None)
//      , Employee(123, "janis")
//    )
//
//    def findByName(name: String): Option[User] = {
//      _people.find(u => u.name == name)
//    }
//
//
//    def findEmployees() : List[Employee] = {
//      _people.flatMap {
//        case User(_, _) =>
//          None
//        case e @ Employee(_, _, _) =>
//          Some(e)
//      }
//    }
//  }
//
//  val filtered = UserRep.findByName("adam")
//    .flatMap(
//      _.gender.map(
//      _ == "male")
//    )
//  println(filtered)
//
//  val userString = for {
//    user <- UserRep.findByName("adam")
//  } yield s"${user.name}"
//


}