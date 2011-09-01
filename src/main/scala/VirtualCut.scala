package virtualcut

import virtualcut.model._
import virtualcut.view._
import virtualcut.controller._
import virtualcut.helper._
import java.io._
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import swing._
//import javax.swing.{UIManager}

object VirtualCut extends App {

  var audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream (getClass.getResourceAsStream("/mr-magoo.wav")));
 // ("/home/ciembor/Alesis-Fusion-Bass-Loop.wav");
 
  var parametersModel = new ParametersModel()
  var trackModel = new TrackModel(audioInputStream)
 // var selectionModel = new SelectionModel(parametersModel)
 
  var parametersView = new ParametersView(parametersModel)
  var trackView = new TrackView(trackModel)
  var controlsView = new ControlsView()
  
  var trackController = new TrackController(parametersModel, trackModel, trackView)
  var controlsController = new ControlsController(trackModel, trackController, controlsView)
  var parametersController = new ParametersController(parametersModel, trackController, parametersView)

  object openFileChooser extends OpenFileChooser(trackController)
  object saveFileChooser extends SaveFileChooser(trackController)
  
  object Window extends MainFrame {
    title = "VirtualCut"
  //  UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
 //   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//    contents = new Panel() {
 //     preferredSize = new Dimension(800,400)
//    }
   // preferredSize = new Dimension(800, 355)
    menuBar = MenuBarView
    
    val container:BoxPanel = new BoxPanel(Orientation.Vertical) {
      contents += parametersView
      contents += Component.wrap(trackView.scrollPane)
      contents += controlsView
    }
    
    contents = container
  }
  
  Window.visible = true

}
