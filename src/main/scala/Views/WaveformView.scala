package virtualcut
package view

import java.awt._
import java.awt.event._
import javax.swing._
import javax.swing.border._
import components._

object WaveformView extends JScrollPane {
  //  columnView:Rule
   // rowView:Rule
   // isMetric:JToggleButton 
  //  var picture:ScrollablePicture

    val waveform = new ImageIcon("/home/ciembor/B4MwD.jpg");
        
    val columnView = new Rule()
 //   val rowView = new Rule(Rule.VERTICAL, true);

    if (waveform != null) {
      columnView.setPreferredWidth(waveform.getIconWidth())
   //   rowView.setPreferredHeight(waveform.getIconHeight())
    } else {
      columnView.setPreferredWidth(320);
   //   rowView.setPreferredHeight(480);
    }
        
    //Create the corners.
 //   val buttonCorner = new JPanel //use FlowLayout
 //   val isMetric = new JToggleButton("cm", true)
 //   isMetric.setFont(new Font("SansSerif", Font.PLAIN, 11))
 //   isMetric.setMargin(new Insets(2,2,2,2))
  //  isMetric.addItemListener(this)
 //   buttonCorner.add(isMetric)
        
        
//Set up the scroll pane.
    val picture = new ScrollablePicture(waveform, columnView.getIncrement())
    val pictureScrollPane = new JScrollPane(picture)
    pictureScrollPane.setPreferredSize(new Dimension(300, 250))
    pictureScrollPane.setViewportBorder(
      BorderFactory.createLineBorder(Color.black))
    pictureScrollPane.setColumnHeaderView(columnView);
  //  pictureScrollPane.setRowHeaderView(rowView);
	//Set the corners.
        //In theory, to support internationalization you would change
        //UPPER_LEFT_CORNER to UPPER_LEADING_CORNER,
        //LOWER_LEFT_CORNER to LOWER_LEADING_CORNER, and
        //UPPER_RIGHT_CORNER to UPPER_TRAILING_CORNER.  In practice,
        //bug #4467063 makes that impossible (in 1.4, at least).
 //   pictureScrollPane.setCorner("UPPER_LEFT_CORNER", buttonCorner)
 //   pictureScrollPane.setCorner("LOWER_LEFT_CORNER", new Corner())
 //   pictureScrollPane.setCorner("UPPER_RIGHT_CORNER", new Corner())
        //Put it in this panel.
    add(pictureScrollPane)
    setBorder(BorderFactory.createEmptyBorder(20,20,20,20))
      
//  val waveform = new ScrollablePicture
  

}
