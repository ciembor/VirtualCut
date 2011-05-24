package virtualcut

package view {
  
  import virtualcut.model._
  import swing._
  //import javax.swing.{UIManager}

  class View(model:Model) extends MainFrame {
    title = "VirtualCut"
    //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//    contents = new Panel() {
 //     preferredSize = new Dimension(800,400)
//    }
  
    menuBar = MenuBarView
    
    val container:BoxPanel = new BoxPanel(Orientation.Vertical) {
      preferredSize = new Dimension(800,400)
      contents += ParametersView
      contents += Component.wrap(WaveformView.pictureScrollPane)
      contents += ControlsView
    }
    
    contents = container
  }
  
}
