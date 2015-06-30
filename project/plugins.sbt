resolvers += Classpaths.typesafeResolver

resolvers += "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/"

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")
    
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")
    
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "3.0.0")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-start-script" % "0.10.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "0.7.4")