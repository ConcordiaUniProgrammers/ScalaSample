
import NativePackagerKeys._

packageArchetype.java_application

version       := "0.1"

scalaVersion  := "2.11.2"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += Resolver.url("sbt-plugin-snapshots", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots/"))(Resolver.ivyStylePatterns)

  libraryDependencies ++= Seq(
	"org.apache.logging.log4j" % "log4j-core" % "2.3",
	"org.apache.logging.log4j" % "log4j-api" % "2.3",
    "org.mongodb"   	  				%%  "casbah"    	 	 	  % "2.8.0"
    )
  
  