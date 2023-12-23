package hust.soict.dsai.aims.screen;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame{
  private Store store = new Store();
  
  JPanel createNorth() {
	JPanel north = new JPanel();
	north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
	north.add(createMenuBar());
	north.add(createHeader());
	return north;
  }
  
  JMenuBar createMenuBar() {
	return PlayScreenAndOptionsMenu.createMenuBar(this);
  }
  						
  JPanel createHeader() {
	JPanel header = new JPanel();
	header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
	
	JLabel title = new JLabel("AIMS - NNAT - 20215143");
	title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
	title.setForeground(new Color(0, 0 , 128));
	
	JButton viewcart = new JButton("View cart");
	viewcart.setPreferredSize(new Dimension(100, 50));
	viewcart.setMaximumSize(new Dimension(100, 50));
	viewcart.addActionListener(new OptionsListener(this));
	
	header.add(Box.createRigidArea(new Dimension(10, 10)));
	header.add(title);
	header.add(Box.createHorizontalGlue());
	header.add(viewcart);
	header.add(Box.createRigidArea(new Dimension(10, 10)));
  
	return header;
  }
  							//Nguyễn Ngọc Anh Thư - 20215143
  JPanel createCenter() {
	JPanel center = new JPanel();
	center.setLayout(new GridLayout(3, 3, 2, 2));
	
	ArrayList<Media> mediaInStore = store.getItemsInStore();
    for(int i=0; i<mediaInStore.size(); i++) {
      MediaStore cell = new MediaStore(mediaInStore.get(i));
      center.add(cell);
    }
    
    return center;
  }

  public StoreScreen(Store store){
	this.store = store;
	Container cp = getContentPane();
	cp.setLayout(new BorderLayout());
	
	cp.add(createNorth(), BorderLayout.NORTH);
	cp.add(createCenter(), BorderLayout.CENTER);
	
	setVisible(true);
	setTitle("Store - NNAT - 20215143");
	setSize(1024, 768);
  }
}
