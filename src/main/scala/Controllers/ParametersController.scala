package virtualcut
package controller


import virtualcut.model.ParametersModel
import virtualcut.view.ParametersView

import javax.swing.JSpinner
import javax.swing.JComboBox
import javax.swing.event.ChangeEvent
import javax.swing.event.ChangeListener
import java.awt.event._
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

class ParametersController(model:ParametersModel, track:TrackController, view:ParametersView) {

  val mgr:ScriptEngineManager = new ScriptEngineManager()
  val engine = mgr.getEngineByName("JavaScript")  /* ROTFL :D, just to divide two values */

  object TempoListener extends ChangeListener {
    def stateChanged(e:ChangeEvent):Unit = {
      println("Source: " + e.getSource.asInstanceOf[JSpinner].getValue)
      track.setParameters(model)
    }
  }
  
  object MetricTopListener extends ChangeListener {
    def stateChanged(e:ChangeEvent):Unit = {
      println("Source: " + e.getSource.asInstanceOf[JSpinner].getValue)
      track.setParameters(model)
    }
  }
  
  object MetricBottomListener extends ActionListener {
    def actionPerformed(e:ActionEvent):Unit = {
      println("Source: " + e.getSource.asInstanceOf[JComboBox[Array[java.lang.Object]]].getSelectedItem)
      track.setParameters(model)
    }
  }
  
  object NoteListener extends ActionListener {
    def actionPerformed(e:ActionEvent):Unit = {
      println("Source: " + engine.eval(e.getSource.asInstanceOf[JComboBox[Array[java.lang.Object]]].getSelectedItem.toString))
      track.setParameters(model)
    }
  }

  view.tempo.addChangeListener(TempoListener)
  view.metric_top.addChangeListener(MetricTopListener)
  view.metric_bottom.addActionListener(MetricBottomListener)
  view.note.addActionListener(NoteListener)
  
}
