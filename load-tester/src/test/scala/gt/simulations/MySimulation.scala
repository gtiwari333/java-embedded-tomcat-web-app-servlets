package gt.simulations

import gt.Environment
import gt.scenarios.TestScenarios
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class MySimulation extends Simulation {

  val httpConfig: HttpProtocolBuilder = http.baseUrl(Environment.baseUrl)

  //scenario
  val scn = scenario("open pages one by one")
    .exec(TestScenarios.jsonPage())
    .pause(1.milliseconds, 5.milliseconds)
    .exec(TestScenarios.helloPage())
    .pause(1.milliseconds, 5.milliseconds)
    .exec(TestScenarios.timePage())
    .pause(1.milliseconds, 5.milliseconds)

  before {
    //data prep
  }

  setUp(
    scn.inject(
      //load scenario
      nothingFor(1 seconds),
      atOnceUsers(5000),
      rampUsers(Environment.maxUsers) during Environment.rampUpTime
    ).protocols(httpConfig.inferHtmlResources()) // inferHtmlResources will fetch everything on the page (JS, CSS, images etc.)
  )

}
