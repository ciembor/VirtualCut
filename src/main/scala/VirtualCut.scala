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


  var file = new File("/home/ciembor/mr-magoo.wav");
  var audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream (new FileInputStream (file)));
 // var  file = new File("/home/ciembor/Alesis-Fusion-Bass-Loop.wav");
 
  var parametersModel = new ParametersModel()
  var parametersView = new ParametersView(parametersModel)
  
 // var selectionModel = new SelectionModel(parametersModel)
 
  var trackModel = new TrackModel(audioInputStream)
  var trackView = new TrackView(trackModel)
  var trackController = new TrackController(parametersModel, trackModel, trackView)
  
  object openFileChooser extends OpenFileChooser(trackController)
  object saveFileChooser extends SaveFileChooser(trackController)
  
  var controlsView = new ControlsView()
  var controlsController = new ControlsController(trackModel, trackController, controlsView)
  
  
//var parametersController = new ParametersController(parametersModel, parametersView)
  
  object Window extends MainFrame {
    title = "VirtualCut"
  //  UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
 //   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//    contents = new Panel() {
 //     preferredSize = new Dimension(800,400)
//    }
    preferredSize = new Dimension(800, 355)
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
