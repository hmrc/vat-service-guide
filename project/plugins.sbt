resolvers ++= Seq(
  Resolver.url("HMRC-open-artefacts-ivy", url("https://open.artefacts.tax.service.gov.uk/ivy2"))(Resolver.ivyStylePatterns),
  "HMRC-open-artefacts-maven" at "https://open.artefacts.tax.service.gov.uk/maven2")

addSbtPlugin("uk.gov.hmrc" % "sbt-auto-build" % "3.24.0")
addSbtPlugin("uk.gov.hmrc" % "sbt-distributables" % "2.5.0")
addSbtPlugin("org.playframework" % "sbt-plugin"         % "3.0.2")
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0" exclude("org.scala-lang.modules", "scala-xml_2.12"))
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.10.2")
