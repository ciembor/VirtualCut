import swing._

class View(model:Model) extends MainFrame {
  title = "app"
   /* 
  contents = new Panel() {
    preferredSize = new Dimension(600,400)
  }
    
  val menuItemExit = new MenuItem("Exit")
  menuItemExit.tooltip = "Exit"
    
	menuBar = new MenuBar {   
    
    contents += new Menu("Menu") {
      val exitMenuItem = new MenuItem("Exit")
      exitMenuItem.tooltip = "Exit"

      contents += exitMenuItem      
      contents += new MenuItem(Action("Action item") { println(title) })       
      contents += new Separator        
      contents += new CheckMenuItem("Check me")
    }
  
  }
  */
  
  contents = new BoxPanel(Orientation.Vertical) {
  
    val parameters = new FlowPanel() {
      contents += new Label("Tempo: ")
      contents += new ComboBox(Seq("80", "100", "120", "140"))
      contents += new Label("Metric: ")
      contents += new Label("Note: ")
    }
        
    val controls = new FlowPanel() {
      contents += new Button( "klop" ) 
    }
    
    contents += parameters
    contents += controls
    
  }

}
