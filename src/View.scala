import swing._

class View(model:Model) extends MainFrame {
  
    title = "VirtualCut"
    
    val menubar = new MenuBar
    val menu = new Menu("Menu")
    val menuItemExit = new MenuItem("Exit")
    menuItemExit.tooltip = "Exit VirtualCut"
    
    //menu.menus ::= menuItemExit
    //menubar.menus ::= menu
    
    contents = {menubar}
  
}
