import swing._

class View(model:Model) extends MainFrame {
  
    title = "VirtualCut"
    
    contents = new Panel() {
      preferredSize = new Dimension(600,400)
    }
    
    val menuItemExit = new MenuItem("Exit")
    menuItemExit.tooltip = "Exit VirtualCut"
    
	menuBar = new MenuBar {   
      contents += new Menu("Menu") {
		val exitMenuItem = new MenuItem("Exit")
		exitMenuItem.tooltip = "Exit VirtualCut"
		
        contents += exitMenuItem      
        contents += new MenuItem(Action("Action item") { println(title) })       
        contents += new Separator        
        contents += new CheckMenuItem("Check me")
      }
    }
  
}
