import sbt._

class VirtualCut(info: ProjectInfo) extends DefaultProject(info)
{
  val scalaSwing = "org.scala-lang" % "scala-swing" % "2.9.0"
  val seaGlassLookAndFeel = "com.seaglasslookandfeel" % "seaglasslookandfeel" % "0.1.7.3"
}
