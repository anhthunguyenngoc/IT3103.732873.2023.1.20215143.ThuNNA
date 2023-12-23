package hust.soict.dsai.aims.screen;
import java.awt.*;
import java.awt.event.*;
import javax.naming.LimitExceededException;
import javax.swing.*;
import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.store.Store;
//Nguyễn Ngọc Anh Thư - 20215143
public abstract class AddItemToStoreScreen extends JFrame{
  protected JTextField tfTitle = new JTextField();
  protected JTextField tfCategory = new JTextField();
  protected JTextField tfCost = new JTextField();
  protected JPanel panel = new JPanel();  
  protected JLabel title = new JLabel();
  protected JButton btnAdd = new JButton();
  protected Store store = Aims.store;
	  
  public AddItemToStoreScreen(){   
	//Thêm menu option panel 
    this.add(PlayScreenAndOptionsMenu.createMenuBar(this), BorderLayout.NORTH);
    
    //design center của JFrame
	panel.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	//Thêm label title vào hàng 0, cột 0 của GridBagLayout()
	c.gridx = 0; c.gridy = 0;
	c.gridwidth = 2;			//merge 2 ô ngang
	c.anchor = GridBagConstraints.CENTER;  
	  
	//Đổi màu và phông chữ cho label
	title.setFont(new Font(title.getFont().getName(), Font.BOLD, 24));
	title.setForeground(new Color(0, 0 , 128));  
	  
	panel.add(title, c); //thêm vào panel
	  
	//Thêm các label vào cột 0  
	  c.gridwidth = 1;
	  c.weightx = 0.3; 
	  c.insets = new Insets(0, 20, 0, 20);
	  
	  c.gridx = 0;  //cột 0
	  c.anchor = GridBagConstraints.LINE_END;
	  
	  //hàng 1-3
	  c.gridy = 1;  
	  panel.add(new JLabel("Title"), c);
	  
	  c.gridy = 2;
	  panel.add(new JLabel("Category"), c);
	  
	  c.gridy = 3;
	  panel.add(new JLabel("Cost"), c);  
	  	  
	//Thêm các TextField vào cột 1
	  c.insets = new Insets(0, 20, 0, 80);
	  c.weightx = 1;
	  c.anchor = GridBagConstraints.LINE_START;
	  c.fill = GridBagConstraints.HORIZONTAL;
	  
	  c.gridx = 1;  //cột 1

	  //hàng 1-3
	  c.gridy = 1;
	  panel.add(tfTitle, c); 
	  
	  c.gridy = 2;
	  panel.add(tfCategory, c);	
	  
	  c.gridy = 3;
	  panel.add(tfCost, c);
	   
	//set button Add
	  btnAdd.setSize(25, 50);
	  btnAdd.addActionListener(new btnAddPressed()); //Xử lí sự kiện khi click vào button Add
	    
	  this.add(panel, BorderLayout.CENTER);
	  this.pack();
	  this.setTitle("Add Media");
	  this.setVisible(true);
	  this.setSize(400, 200);
  }
  
  //ActionListener khi click vào button
  private class btnAddPressed implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
	  boolean check = false;
	  //Xử lý các exception
	  try {
	    check = addMedia();		//addMedia trả về true nếu thành công
	  } catch (NullPointerException e1) { //Nếu title rỗng hoặc chỉ chứa khoảng trắng
	    JOptionPane.showMessageDialog(null, e1.getMessage(), "Add media failed", 0);
	  } catch(LimitExceededException e2) {//Nếu số lượng media trong store đã đạt max
	    JOptionPane.showMessageDialog(null, e2.getMessage(), "Add media failed", 0);
	  }catch(MediaException e3) {		  //Nếu media đã có trong giỏ hàng
	    JOptionPane.showMessageDialog(null, e3.getMessage(), "Add media failed", 0);
	  }catch (Exception e4) {
	    JOptionPane.showMessageDialog(null, e4.getMessage(), "Add media failed", 0);
	  }
	  
	  //Nếu add thành công thì đóng frame và thông báo thêm thành công
	  if(check) {
	    try {
		  close();	
		  JOptionPane.showMessageDialog(null, "The media has been added", "Add media successful", 1);
	    } catch (PlayerException e1) {  }
	  }
    }
  }
  
  public abstract boolean addMedia() throws Exception;
  
  private void close() throws PlayerException {
	this.dispose();
	new StoreScreen(this.store);
  }
}
