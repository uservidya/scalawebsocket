import sbt._
import Keys._

object BuildSettings {
  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := "scalawebsocket",
    name := "scalawebsocket",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.10.0"
  )
}

object Dependencies {
  val asynchttpclient = "com.ning" % "async-http-client" % "1.7.13"

  //logging
  val scalalogging = "com.typesafe" %% "scalalogging-log4j" % "1.0.1"
  val log4japi = "org.apache.logging.log4j" % "log4j-api" % "2.0-beta4"
  val log4jcore = "org.apache.logging.log4j" % "log4j-core" % "2.0-beta4"
  val logback = "ch.qos.logback" % "logback-classic" % "1.0.9"

  val logging = Seq(scalalogging, log4japi, log4jcore, logback)

  //jetty is used to setup test server
  val jettyServer = "org.eclipse.jetty" % "jetty-server" % "8.1.7.v20120910" % "test"
  val jettyWebsocket = "org.eclipse.jetty" % "jetty-websocket" % "8.1.7.v20120910" % "test"
  val jettyServlet = "org.eclipse.jetty" % "jetty-servlet" % "8.1.7.v20120910" % "test"
  val jettyServlets = "org.eclipse.jetty" % "jetty-servlets" % "8.1.7.v20120910" % "test"

  val jetty = Seq(jettyServer, jettyWebsocket, jettyServlet, jettyServlets)

  val scalatest = "org.scalatest" %% "scalatest" % "1.9.1" % "test"
}

object SWSBuild extends Build {

  import Dependencies._
  import BuildSettings._

  val root = Project("scalawebsocket", file("."), settings = buildSettings)
    .settings(libraryDependencies := Seq(asynchttpclient, scalatest) ++ logging ++ jetty)
}