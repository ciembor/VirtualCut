import sbt._

class VirtualCut(info: ProjectInfo) extends DefaultProject(info)
{
  lazy val hi = task { println("Hello World"); None }
  val scalaSwing = "org.scala-lang" % "scala-swing" % "2.9.0"
}
