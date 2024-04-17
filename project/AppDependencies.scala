import play.sbt.PlayImport._
import sbt._

object AppDependencies {
  val bootStrapPlayVersion = "8.5.0"

  val compile: Seq[ModuleID] = Seq(
    ws,
    "uk.gov.hmrc" %% "bootstrap-frontend-play-30" % bootStrapPlayVersion,
  )

  val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc" %% "bootstrap-test-play-30" % bootStrapPlayVersion,
    //"org.pegdown"          % "pegdown"                  % "1.6.0"  % "test",
    "com.vladsch.flexmark" % "flexmark-profile-pegdown" % "0.64.8",
    "org.scalatest"        %% "scalatest"               % "3.2.18"
  ).map(_ % Test)
}
