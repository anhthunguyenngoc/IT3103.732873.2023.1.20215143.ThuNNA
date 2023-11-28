//2.2.5: Calculating sum, difference, product, and quotient of 2 double numbers which are entered by users
package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;
public class Ex2_2_5_CalculatingTwoNumbers {
  public static void main (String[] args){
    String strNum1, strNum2, str;
    Double sum, difference, product, quotient;
    //Nhập số thứ nhất
    strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
    sum = Double.parseDouble(strNum1);
    difference = Double.parseDouble(strNum1);
    product = Double.parseDouble(strNum1);
    quotient = Double.parseDouble(strNum1);
    //Nhập số thứ hai
    strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
    sum += Double.parseDouble(strNum2);
    difference -= Double.parseDouble(strNum2);
    product *= Double.parseDouble(strNum2);
    quotient /= Double.parseDouble(strNum2);
    //Chuỗi hiển thị
    str = "The sum of "+ strNum1 +" and "+ strNum2 + ": " + sum + "\n"+
    "The difference of "+ strNum1 +" and "+ strNum2 + ": " + difference + "\n"+
    "The product of "+ strNum1 +" and "+ strNum2 + ": " + product + "\n"+
    "The quotient of "+ strNum1 +" and "+ strNum2 + ": " + quotient;
    
    JOptionPane.showMessageDialog(null, str, null, JOptionPane.INFORMATION_MESSAGE);
  	System.exit(0);
  }
}