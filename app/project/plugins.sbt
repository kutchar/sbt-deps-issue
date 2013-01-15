// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += Resolver.url("Typesafe repository", url("http://repo.typesafe.com/typesafe/releases/"))

// Repository for sbt-buildinfo
resolvers += Resolver.url("artifactory", url("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)

// Use the Play sbt plugin for Play projects
addSbtPlugin("play" % "sbt-plugin" % "2.1-SNAPSHOT")

// Add sbt-buildinfo
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.1.2")

