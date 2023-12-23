package hust.soict.dsai.aims.screen;
import java.awt.*;
import javax.swing.*;
import hust.soict.dsai.aims.media.CompactDisc;
//Nguyễn Ngọc Anh Thư - 20215143
public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
  private JTextField tfDirectory = new JTextField();
  private JTextField tfArtist = new JTextField();
	
  public AddCompactDiscToStoreScreen() {  
    super();
    GridBagConstraints c = new GridBagConstraints();
    title.setText("Add CD");
   
      //Thêm các label vào cột 0, hàng 4-5
	  c.weightx = 0.3; 
	  c.gridwidth = 1;
	  c.insets = new Insets(0, 20, 0, 20);
	  c.anchor = GridBagConstraints.LINE_END;
	  
	  c.gridx = 0;
	  
	  c.gridy = 4;
	  panel.add(new JLabel("Directory"), c);
	  c.gridy = 5;
	  panel.add(new JLabel("Artist"), c);
	  
	  //Thêm các label vào cột 1, hàng 4-5
	  c.gridwidth = 2;
	  c.weightx = 1;
	  c.insets = new Insets(0, 20, 0, 80);
	  c.anchor = GridBagConstraints.LINE_START;
	  c.fill = GridBagConstraints.HORIZONTAL;
	  
	  c.gridx = 1;
	  
	  c.gridy = 4;
	  panel.add(tfDirectory, c);  
	  c.gridy = 5;
	  panel.add(tfArtist, c);
	  
	  //Thêm add button vào cột 0, hàng 6
	  c.insets = new Insets(0, 20, 0, 20);
		c.gridwidth = 2;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
	  c.gridx = 0; ++c.gridy;
	  
		btnAdd.setText("Add CD");
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
	return store.addMedia(new CompactDisc(tfTitle.getText(), tfCategory.getText(), 
			Float.parseFloat(tfCost.getText()), tfDirectory.getText(), tfArtist.getText()));
  }
}
