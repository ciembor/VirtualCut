package virtualcut

package view {
  
  import virtualcut.model._
  import swing._

  class View(model:Model) extends MainFrame {
    title = "VirtualCut"
    
    contents = new Panel() {
      preferredSize = new Dimension(600,400)
    }
  
    menuBar = MenuBarView
    
    val container:BoxPanel = new BoxPanel(Orientation.Vertical) {
  
      contents += ParametersView
      contents += ControlsView
      
    }
    
    contents = container

  }
  
}
