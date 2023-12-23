package hust.soict.dsai.aims.screen;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.exception.MediaException;
import hust.soict.dsai.aims.store.Store;
//Nguyễn Ngọc Anh Thư - 20215143
public class RemoveMediaFromStoreScreen extends JFrame{
  private Store store = Aims.store;
  private JTextField tfTitle = new JTextField();
  private JPanel panel = new JPanel();
  private JLabel title = new JLabel();
  private JButton btnRev = new JButton();
  
  public RemoveMediaFromStoreScreen() { 
	//Thêm menu option panel 
    this.add(PlayScreenAndOptionsMenu.createMenuBar(this), BorderLayout.NORTH);
    panel.setLayout(new GridBagLayout());
	  GridBagConstraints c = new GridBagConstraints();
	  
	//Thêm label title vào hàng 0, cột 0 của GridBagLayout()
	  c.gridx = 0; c.gridy = 0;
	  c.gridwidth = 2;
	  c.weightx = 0.3; 
	  c.anchor = GridBagConstraints.CENTER;
	  
	//Đổi màu và phông chữ cho label  
	  title.setText("Remove Media");
	  title.setFont(new Font(title.getFont().getName(), Font.BOLD, 24));
	  title.setForeground(new Color(0, 0 , 128));  
	  
	  panel.add(title, c);
	  
	//Thêm label vào cột 0, hàng 1
	  c.gridwidth = 1;
	  c.weightx = 0.3;
	  c.insets = new Insets(0, 20, 0, 20);
	  c.anchor = GridBagConstraints.LINE_END;
	  
	  c.gridx = 0; c.gridy = 1;
	  panel.add(new JLabel("Title"), c);
	  
	//Thêm TextField vào cột 1, hàng 1
	  c.insets = new Insets(0, 20, 0, 80);
	  c.weightx = 1; c.weighty = 1;	  
	  c.anchor = GridBagConstraints.LINE_START;
	  c.fill = GridBagConstraints.HORIZONTAL;
	  
	  c.gridx = 1; c.gridy = 1;
	  panel.add(tfTitle, c); 
	 
	//Thêm Button vào hàng 2
	  c.gridy = 2;
	  btnRev.setSize(25, 50);
	  btnRev.addActionListener(new btnRevPressed(this.store));
	  btnRev.setText("Remove Media");
	  panel.add(btnRev, c);
	  
	  this.add(panel, BorderLayout.CENTER);
	  this.setTitle("Remove Media");
	  this.setVisible(true);
	  this.setSize(400, 200);
  }
  
  //ActionListener khi click vào button
  private class btnRevPressed implements ActionListener {
	Store store = new Store();
	public btnRevPressed(Store store) {
	  this.store = store;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	  boolean check = false;
	//Xử lý các exception
	  try {				//removeMedia trả về true nếu thành công
		check = store.removeMedia(store.mediaInStore(tfTitle.getText()));
	  } catch (MediaException e1) { //Nếu không có trong giỏ hàng 
		JOptionPane.showMessageDialog(null, e1.getMessage(), "Add media failed", 0);
	  }
	  
	//Nếu add thành công thì đóng frame và thông báo thêm thành công  
	  if(check) {
		close();
		JOptionPane.showMessageDialog(null, "The media has been removed", "Add media successful", 1);
      }	
	}
  }
  
  //Đóng frame
  private void close(){
	this.dispose();			
	new StoreScreen(this.store);
  }
}
