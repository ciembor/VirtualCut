package virtualcut
package model

import java.awt.Dimension
import java.awt.Rectangle
import javax.swing.JLabel
import javax.swing.Scrollable
import javax.swing.SwingConstants
import javax.swing.event.MouseInputListener


class sScrollablePicture extends JLabel with Scrollable{
  
  val FULLSIZE_MAX_UNIT_INCREMENT	= 64	// pixel
  
	setAutoscrolls(true)

//	val mouse	= new MouseScroller(this)
//	addMouseListener(mouse)
//	addMouseMotionListener(mouse)

    def getScrollableUnitIncrement(visibleRect:Rectangle, orientation:Int, direction:Int):Int = {
    	val currentPosition	= if (orientation == SwingConstants.HORIZONTAL)	visibleRect.x else visibleRect.y
        if (direction < 0) {
        	val newPosition = currentPosition - (currentPosition / FULLSIZE_MAX_UNIT_INCREMENT) * FULLSIZE_MAX_UNIT_INCREMENT
            if (newPosition == 0) FULLSIZE_MAX_UNIT_INCREMENT else newPosition
        } 
		else {
            ((currentPosition / FULLSIZE_MAX_UNIT_INCREMENT) + 1) * FULLSIZE_MAX_UNIT_INCREMENT - currentPosition
        }
    }

    def getScrollableBlockIncrement(visibleRect:Rectangle, orientation:Int, direction:Int):Int = {
		if (orientation == SwingConstants.HORIZONTAL)
			visibleRect.width  - FULLSIZE_MAX_UNIT_INCREMENT
		else
			visibleRect.height - FULLSIZE_MAX_UNIT_INCREMENT
    }

    def getPreferredScrollableViewportSize():Dimension = getPreferredSize
    def getScrollableTracksViewportWidth():Boolean	= false
    def getScrollableTracksViewportHeight():Boolean	= false
}
