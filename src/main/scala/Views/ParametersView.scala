package virtualcut
package view


import javax.swing.JSpinner
import javax.swing.JComboBox
import javax.swing._
//import java.awt._; 

import swing._
//import scala.swing.event._
import virtualcut.model.ParametersModel

class ParametersView(parametersModel:ParametersModel) extends FlowPanel {
  
  val tempo = new JSpinner(parametersModel.tempo)
  val metric_top = new JSpinner(parametersModel.metric_top)
  val metric_bottom = new JComboBox(parametersModel.metric_bottom)
  val note = new JComboBox(parametersModel.note)
  
  contents += new Label("Tempo: ")
  contents += Component.wrap(tempo)
  contents += new Label("Metric: ")
  contents += Component.wrap(metric_top)
  contents += new Label("/")
  contents += Component.wrap(metric_bottom)
  contents += new Label("Note: ")
  contents += Component.wrap(note)

}
