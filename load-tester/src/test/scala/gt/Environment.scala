package gt

import scala.concurrent.duration._

object Environment {

  def envOrElse(name: String, alt: String): String = Option(System.getenv(name))
    .orElse(Option(System.getProperty(name)))
    .getOrElse(alt)

  val rampUpTime: FiniteDuration = envOrElse("rampUpTIme", "15").toInt seconds
//  val maxUsers: Int = envOrElse("users", "70000").toInt //OK with virtual

  val maxUsers: Int = envOrElse("users", "3000").toInt //with platform thread

  val baseUrl = "http://localhost:8080"
  val jsonPage = "/json?delay=1000"
  val helloPage = "/hello?delay=200"
  val timePage = "/time?delay=500"
}
