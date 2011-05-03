import swing._

object VirtualCut extends Application {

  val model       = new Model
  val view        = new View(model)
  val controller  = new Controller(model, view)
  
  view.visible = true

}
