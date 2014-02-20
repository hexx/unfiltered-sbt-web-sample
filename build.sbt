libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered-directives" % "0.7.1",
  "net.databinder" %% "unfiltered-filter" % "0.7.1",
  "net.databinder" %% "unfiltered-jetty" % "0.7.1"
)

webSettings

jsEngineSettings

lessSettings

resourceManaged in WebKeys.Assets := (classDirectory in Compile).value / "public"
