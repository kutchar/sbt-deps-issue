import sbt._
import Keys._
import play.Project._
import sbtbuildinfo.Plugin._

object ApplicationBuild extends Build {

  val appName    = "app"
  val appVersion = "1.0"

  val appDependencies = Seq(
    "com.company"            %% "lib"       % "1.0"   withSources(),
    "org.codehaus.jackson" %  "jackson-core-asl"   % "1.9.11" notTransitive(),
    "org.codehaus.jackson" %  "jackson-mapper-asl" % "1.9.11" notTransitive(),
    "org.codehaus.jackson" %  "jackson-smile"      % "1.9.11" notTransitive() withSources()
  )

  val main = play.Project(appName, appVersion, appDependencies, settings = Defaults.defaultSettings ++ buildInfoSettings).settings(
    organization := "com.company",
    publishTo := Some("Company Releases" at "http://repo.company.com/artifactory/company-release-local/"),
    credentials += Credentials("Artifactory Realm", "repo.company.com", "XXX", "XXX"),
    resolvers += "Company Releases" at "http://repo.company.com/artifactory/company-release-local/",

    sourceGenerators in Compile <+= buildInfo,
    buildInfoKeys := Seq[Scoped](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "com.company.app"
  )

}
