package virtualcut
package view

import swing._
import javax.swing.JSpinner
import javax.swing.JComboBox
import virtualcut.model.ParametersModel

object ParametersView extends FlowPanel() {
  
  val tempo = new JSpinner(ParametersModel.tempo)
  val metric_top = new JSpinner(ParametersModel.metric_top)
  val metric_bottom = new JComboBox(ParametersModel.metric_bottom)
  val note = new JComboBox(ParametersModel.note)
  
  contents += new Label("Tempo: ")
  contents += Component.wrap(tempo)
  contents += new Label("Metric: ")
  contents += Component.wrap(metric_top)
  contents += new Label("/")
  contents += Component.wrap(metric_bottom)
  contents += new Label("Note: ")
  contents += Component.wrap(note)

}
