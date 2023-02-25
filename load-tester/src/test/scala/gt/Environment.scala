package gt

import scala.concurrent.duration._
import scala.language.postfixOps

object Environment {

  def envOrElse(name: String, alt: String): String = Option(System.getenv(name))
    .orElse(Option(System.getProperty(name)))
    .getOrElse(alt)

  val rampUpTime: FiniteDuration = envOrElse("rampUpTIme", "15").toInt seconds
  val maxUsers: Int = envOrElse("users", "100000").toInt //OK with virtual

//  val maxUsers: Int = envOrElse("users", "70000").toInt

  val baseUrl = "http://localhost:8080"
  val jsonPage = "/json"
  val helloPage = "/hello"
  val timePage = "/time"
}
