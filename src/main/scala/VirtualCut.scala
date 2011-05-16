import swing._
import javax.swing.JSpinner
import javax.swing.SpinnerNumberModel

object VirtualCut extends App {

  val model       = new Model
  val view        = new View(model)
  val controller  = new Controller(model, view)
  
  view.visible = true

}
