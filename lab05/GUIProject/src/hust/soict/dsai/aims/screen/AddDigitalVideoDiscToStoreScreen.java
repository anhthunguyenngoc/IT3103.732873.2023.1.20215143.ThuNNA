package hust.soict.dsai.aims.screen;
import java.awt.*;
import javax.swing.*;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
//Nguyễn Ngọc Anh Thư - 20215143
public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
  private JTextField tfDirectory = new JTextField();
  private JTextField tfLength = new JTextField(); 
  
  public AddDigitalVideoDiscToStoreScreen() {
	super();
	GridBagConstraints c = new GridBagConstraints();
	title.setText("Add DVD");	  
	   
	//Thêm các label vào cột 0, hàng 4-5
		  c.gridwidth = 1;
		  c.weightx = 0.3; 
		  c.insets = new Insets(0, 20, 0, 20);
		  c.anchor = GridBagConstraints.LINE_END;
		  
		  c.gridx = 0;
 
		  c.gridy = 4;
		  panel.add(new JLabel("Directory"), c);
		  c.gridy = 5;
		  panel.add(new JLabel("Length"), c);
		  
	//Thêm các label vào cột 1, hàng 4-5
		  c.insets = new Insets(0, 20, 0, 80);
		  c.weightx = 1;
		  c.gridwidth = 2;
		  c.anchor = GridBagConstraints.LINE_START;
		  c.fill = GridBagConstraints.HORIZONTAL;
		  
		  c.gridx = 1;
		  
		  c.gridy = 4;
		  panel.add(tfDirectory, c);  
		  c.gridy = 5;
		  panel.add(tfLength, c);
	
		//Thêm add button vào cột 0, hàng 6
		  c.insets = new Insets(0, 20, 0, 20);
			c.gridx = 0;
			++c.gridy;
			c.gridwidth = 2;
			c.fill = GridBagConstraints.NONE;
			c.anchor = GridBagConstraints.CENTER;
		
			btnAdd.setText("Add DVD");
			panel.add(btnAdd, c);
  }
  
  public boolean addMedia() throws Exception {
	//Xử lí exception nếu float không phải là số
	try {
	  Float.parseFloat(tfCost.getText());
	}catch(NumberFormatException e) {
	  throw new NumberFormatException("ERROR: The cost isnot a number");
	}
	//Trả về kết quả của addMedia trong store (true/false)
	return store.addMedia(new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), 
			Float.parseFloat(tfCost.getText()), tfDirectory.getText(), Integer.parseInt(tfLength.getText())));
  }
}
