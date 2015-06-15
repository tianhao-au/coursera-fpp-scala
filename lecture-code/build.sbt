name := "lecture-code"

version := "1.0"

autoCompilerPlugins := true

libraryDependencies ++= Seq(
  "org.specs2"    %% "specs2"    % "2.3.12" % "test" withSources(),
  "org.scalatest" %% "scalatest" % "2.2.4"  % "test" withSources()
)
