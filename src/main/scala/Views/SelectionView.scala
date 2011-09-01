package virtualcut
package view

import java.awt._
import draggable._
import virtualcut.model.SelectionModel

class SelectionView(selection:SelectionModel) extends DraggableComponent(selection:SelectionModel) {
  
  setSize(selection.size)
  setBackground(new Color(255,255,255,40))
  
}
