package virtualcut
package model

import javax.swing.SpinnerNumberModel
import javax.swing.DefaultComboBoxModel

object ParametersModel {
  val tempo = new SpinnerNumberModel(120:Double, 1, 300, 1)
  var metrum_top = 1
  var metrum_bottom = 4
 // private val notes = {"𝅝", "𝅗𝅥", "𝅘𝅥", "𝅘𝅥𝅮", "𝅘𝅥𝅯", "𝅘𝅥𝅰", "𝅘𝅥𝅱", "𝅘𝅥𝅲"}
  val note = new DefaultComboBoxModel(Array[java.lang.Object]("𝅝", "𝅗𝅥", "𝅘𝅥", "𝅘𝅥𝅮", "𝅘𝅥𝅯", "𝅘𝅥𝅰", "𝅘𝅥𝅱", "𝅘𝅥𝅲")
)
}
