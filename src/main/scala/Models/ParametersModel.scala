package virtualcut
package model

import javax.swing.SpinnerNumberModel
import javax.swing.DefaultComboBoxModel

class ParametersModel {
  val tempo = new SpinnerNumberModel(200:Double, 1, 300, 1)
  val metric_top = new SpinnerNumberModel(1, 1, 100, 1)
  val metric_bottom = new DefaultComboBoxModel(Array[java.lang.Object]("1", "2", "4", "8", "16", "32", "64", "128"))

  //val note = new DefaultComboBoxModel(Array[java.lang.Object]("𝅝", "𝅗𝅥", "𝅘𝅥", "𝅘𝅥𝅮", "𝅘𝅥𝅯", "𝅘𝅥𝅰", "𝅘𝅥𝅱", "𝅘𝅥𝅲"))
  
  val note = new DefaultComboBoxModel(Array[java.lang.Object]("1", "1/2", "1/4", "1/8", "1/16", "1/32", "1/64", "1/128"))

}
