package virtualcut

import virtualcut.model._
import virtualcut.view._
import virtualcut.controller._

import swing._
  //import javax.swing.{UIManager}

object VirtualCut extends App {

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
      contents += ParametersView
      contents += Component.wrap(TrackView.scrollPane)
      contents += ControlsView
    }
    
    contents = container
  }
  
  Window.visible = true

}
