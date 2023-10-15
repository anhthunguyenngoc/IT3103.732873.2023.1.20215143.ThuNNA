// Exercises 6.1: ChoosingOption.java
import javax.swing.JOptionPane;
public class Ex6_1_ChoosingOption {
  public static void main(String[] args) {
	 int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
	  
	 //Hiển thị thông báo chỉ có 2 lựa chọn "Yes" và "No"
	 /*
	 int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?",
	 null, JOptionPane.YES_NO_OPTION);
	  */
	 
	 //Hiển thị thông báo chỉ có 2 lựa chọn "I do" và "I don't"
	 /* 
	 String[] answer = {"I do","I don't"};
	 int option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?", 
	 null, JOptionPane.YES_NO_OPTION, 0, null, answer, answer[0]);
	 */
	 JOptionPane.showMessageDialog(null, "You've chosen: " + (option==JOptionPane.YES_OPTION?"Yes":"No"));
	 System.exit(0);
  }
}