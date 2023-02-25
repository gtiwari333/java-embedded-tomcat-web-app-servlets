
import gt.simulations.MySimulation
import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

/**
 * this can be used to run simulations from IDE
 */
object Engine extends App {


    val props = new GatlingPropertiesBuilder()
        .resourcesDirectory(IDEPathHelper.mavenResourcesDirectory.toString)
        .resultsDirectory(IDEPathHelper.resultsDirectory.toString)
        .binariesDirectory(IDEPathHelper.mavenBinariesDirectory.toString)

        /*
        uncomment and put the simulation that you want to run

        Or run mvn gatling:test to run all tests
            runMultipleSimulations is true
         */

        .simulationClass(classOf[MySimulation].getName) //

    Gatling.fromMap(props.build)
}
