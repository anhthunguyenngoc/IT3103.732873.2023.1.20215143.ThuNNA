package hust.soict.dsai.aims.screen;
import java.awt.*;
import hust.soict.dsai.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen{

  public AddBookToStoreScreen() {
	super();
	GridBagConstraints c = new GridBagConstraints();	
	title.setText("Add Book"); 
	
	//Thêm add button vào hàng 4
	c.insets = new Insets(0, 20, 0, 20);
	c.gridx = 0;
	c.gridy = 4;
	c.gridwidth = 2;
	c.fill = GridBagConstraints.NONE;
	c.anchor = GridBagConstraints.CENTER;
	
	btnAdd.setText("Add book");
	panel.add(btnAdd, c);
  }
//Nguyễn Ngọc Anh Thư - 20215143
  public boolean addMedia() throws Exception {	
	try { //Xử lí exception nếu float không phải là số
	  Float.parseFloat(tfCost.getText());
	}catch(NumberFormatException e) {
	  throw new NumberFormatException("ERROR: The cost isnot a number");
	}
	//Trả về kết quả của addMedia trong store (true/false)
    return store.addMedia(new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText())));
  }
}
