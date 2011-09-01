package virtualcut
package view

import java.awt._
import draggable._
import virtualcut.model.SelectionModel

class SelectionView(selection:SelectionModel) extends DraggableComponent(selection:SelectionModel) {


  setBackground(new Color(255,255,255,40))
  
  def update {
    setSize(selection.size)
    if (selection.point.x > 0 && selection.point.x < selection.max) {
      setLocation(selection.point)
    }
  }
  
  update
  
}
