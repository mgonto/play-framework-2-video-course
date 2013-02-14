import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "agenda"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
        "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
        "logger-mod" % "logger-mod_2.9.1" % "1.0-SNAPSHOT"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
