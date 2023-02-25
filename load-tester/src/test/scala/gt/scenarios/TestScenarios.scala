package gt.scenarios

import gt.Environment
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object TestScenarios {

    def jsonPage(): HttpRequestBuilder = {
        http("json page")
            .get(Environment.jsonPage)
    }

    def helloPage(): HttpRequestBuilder = {
        http("hello page")
          .get(Environment.helloPage)
    }


    def timePage(): HttpRequestBuilder = {
        http("time page")
          .get(Environment.timePage)
    }


    //other methods

}
