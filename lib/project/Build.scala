import sbt._
import Keys._
import play.Project._
import sbtbuildinfo.Plugin._

object ApplicationBuild extends Build {

  val appName    = "lib"
  val appVersion = "1.0"

  val appDependencies = Seq(
    // Play comes with multiple versions of commons-codec, we are explicitly asking for version 1.7
    "commons-codec"                  %  "commons-codec" % "1.7"    notTransitive(),
    "commons-io"                     %  "commons-io"    % "2.4"    notTransitive()  withSources(),
    "com.github.stephenc.eaio-uuid"  %  "uuid"          % "3.2.0"  notTransitive()  withSources(),
    "com.google.code.findbugs"       %  "jsr305"        % "2.0.1",
    "com.google.guava"               %  "guava"         % "13.0.1",
    "org.imgscalr"                   %  "imgscalr-lib"  % "4.2"    notTransitive()  withSources(),
    "org.iq80.snappy"                %  "snappy"        % "0.2"    notTransitive()  withSources()
  )

  val main = play.Project(appName, appVersion, appDependencies, settings = Defaults.defaultSettings ++ buildInfoSettings).settings(
    organization := "com.company",
    publishTo := Some("Company Releases" at "http://repo.company.com/artifactory/company-release-local/"),
    credentials += Credentials("Artifactory Realm", "repo.company.com", "XXX", "XXX"),
    resolvers += "Company Releases" at "http://repo.company.com/artifactory/company-release-local/",

    sourceGenerators in Compile <+= buildInfo,
    buildInfoKeys := Seq[Scoped](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "com.company.commons"
  )

}
