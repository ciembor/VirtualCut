import swing._

class View(model:Model) extends MainFrame {
  title = "VirtualCut"
  
  contents = new Panel() {
    preferredSize = new Dimension(600,400)
  }
  
  // used in menu and in control panel
  val saveFile = new FileChooser();
  
  menuBar = new MenuBar {   
    
    contents += new Menu("Menu") {
      val exitMenuItem = new MenuItem("Exit")
      exitMenuItem.tooltip = "Exit VirtualCut"

      val openFile = new FileChooser();

      contents += new MenuItem(Action("Open file") { 
        openFile.showOpenDialog(VirtualCut.view.container);
      })

      contents += new MenuItem(Action("Save sample") { 
        saveFile.showSaveDialog(VirtualCut.view.container);
      })
           
      contents += new Separator        
      contents += exitMenuItem      

    }
  
  }
  
  val container:BoxPanel = new BoxPanel(Orientation.Vertical) {
  
    val parameters = new FlowPanel {
      contents += new Label("Tempo: ")
      contents += new ComboBox(Seq("80", "100", "120", "140"))
      contents += new Label("Metric: ")
      contents += new Label("Note: ")
    }
     
    val wafeform = new ScrollPane
        
    val controls = new FlowPanel() {
      contents += new Button("pause")
      contents += new Button("play")
      contents += new Button("stop")
      val saveSampleButton = new Button(Action("Save sample") { 
        saveFile.showSaveDialog(VirtualCut.view.container);
      })
      contents += saveSampleButton
    }
    
    contents += parameters
    controls += waveform
    contents += controls
    
  }
  
  contents = container

}
