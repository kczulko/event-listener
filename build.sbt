name := "event-listener"

version := "1.0"

scalaVersion := "2.11.1"

val akkaV = "2.3.9"
val sprayV = "1.3.3"
val specsCoreV = "2.3.11"

libraryDependencies ++= Seq(
  "io.spray" %% "spray-can" % sprayV,
  "io.spray" %% "spray-routing" % sprayV,
  "io.spray" %% "spray-json" % sprayV,
  "io.spray" %% "spray-testkit"  % sprayV % "test",
  "com.typesafe.akka" %%  "akka-actor" % akkaV,
  "com.typesafe.akka" %%  "akka-testkit" % akkaV % "test"
)

resolvers += Resolver.sonatypeRepo("releases")
resolvers += "spray repo" at "http://repo.spray.io"

enablePlugins(JavaAppPackaging)
//addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
    