//Example 2.2.3: Ex2_2_3_HelloNameDialog.java
package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;
public class Ex2_2_3_HelloNameDialog{
  public static void main (String[] args){
    String result;
    result = JOptionPane.showInputDialog("Please enter your name:");
    JOptionPane.showMessageDialog(null, "Hi "+ result +"!");
  	System.exit(0);
  }
}