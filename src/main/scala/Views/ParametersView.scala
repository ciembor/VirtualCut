package virtualcut
package view

import swing._
import javax.swing.JSpinner
import javax.swing.JComboBox
import virtualcut.model.ParametersModel

object ParametersView extends FlowPanel() {
  contents += new Label("Tempo: ")
  val tempo = new JSpinner(ParametersModel.tempo)
  contents += Component.wrap(tempo)
  
  contents += new Label("Metric: ")
  contents += new Label("Note: ")
  val note = new JComboBox(ParametersModel.note)
  contents += Component.wrap(note)

}
