package hust.soict.dsai.aims.screen;
import java.awt.*;
import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen{

  public AddBookToStoreScreen() {
	super();
	GridBagConstraints c = new GridBagConstraints();	
	title.setText("Add Book");
	
	c.insets = new Insets(0, 20, 0, 20);
	c.gridx = 0;
	c.gridy = 4;
	c.gridwidth = 2;
	c.fill = GridBagConstraints.NONE;
	c.anchor = GridBagConstraints.CENTER;
	
	btnAdd.setText("Add book");
	panel.add(btnAdd, c);
  }
  
  public int addMedia() {
	  return Aims.store.addMedia(new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText())));
  }
}
