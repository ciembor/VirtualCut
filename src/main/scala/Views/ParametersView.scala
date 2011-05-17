package virtualcut
package view

import swing._
import javax.swing.JSpinner
import javax.swing.SpinnerNumberModel

object ParametersView extends FlowPanel {
  contents += new Label("Tempo: ")
  val spinnerModel = new SpinnerNumberModel(120:Double, 1, 300, 1)
  val spinner = new JSpinner(spinnerModel)
  contents += Component.wrap(spinner)
  
  contents += new Label("Metric: ")
  contents += new Label("Note: ")
}
