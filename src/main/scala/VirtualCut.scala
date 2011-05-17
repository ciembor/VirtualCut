package virtualcut

import virtualcut.model._
import virtualcut.view._
import virtualcut.controller._

object VirtualCut extends App {

  val model       = new Model
  val view        = new View(model)
  val controller  = new Controller(model, view)
  
  view.visible = true

}
