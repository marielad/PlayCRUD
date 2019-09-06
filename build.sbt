name := """PlayCRUD"""

version := "20190830"

lazy val root = (project in file(".")).enablePlugins(PlayJava, SbtWeb)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies += javaJpa
libraryDependencies += javaWs

// https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager
libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "5.2.10.Final"
libraryDependencies += "org.julienrf" %% "play-jsmessages" % "3.0.0"
libraryDependencies += "org.postgresql" % "postgresql" % "9.4.1212"


// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test

libraryDependencies ++= Seq(evolutions, jdbc)

// CACHE
libraryDependencies ++= Seq(
  ehcache
)

// SWT tokens
libraryDependencies += "com.auth0" % "java-jwt" % "3.3.0"

// TEMPORALY FIX: https://github.com/playframework/playframework/issues/7832#issuecomment-336014319
// https://github.com/playframework/playframework/blob/2.6.x/framework/project/Dependencies.scala#L11
val akkaVersion = "2.5.6"
dependencyOverrides ++= Seq( // Seq for SBT 1.0.x
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.google.guava" % "guava" % "22.0",
  "org.slf4j" % "slf4j-api" % "1.7.25"
)

// Skip javadoc on scala 2.12 ( Fix bug )
scalacOptions in(Compile, doc) ++= Seq(scalaVersion.value).flatMap {
  case v if v.startsWith("2.12") => Seq("-no-java-comments") //workaround for scala/scala-dev#249
  case _ => Seq()
}


