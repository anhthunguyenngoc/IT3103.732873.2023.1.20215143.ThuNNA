package hust.soict.dsai.aims.screen;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame{
  private Store store;
  private Cart cart = new Cart();
  
  JPanel createNorth() {
	JPanel north = new JPanel();
	north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
	north.add(createMenuBar());
	north.add(createHeader());
	return north;
  }
  
  JMenuBar createMenuBar() {
	JMenu menu = new JMenu("Options");
	
	JMenu smUpdateStore = new JMenu("Update Store");
	
	JMenuItem addBook = new JMenuItem("Add Book");
	addBook.addActionListener(new ActionListener() {
		@Override
	    public void actionPerformed(ActionEvent e) {
			new AddBookToStoreScreen();
		}
	});
	smUpdateStore.add(addBook);
	
	JMenuItem addCD = new JMenuItem("Add CD");
	addCD.addActionListener(new ActionListener() {
		@Override
	    public void actionPerformed(ActionEvent e) {
			new AddCompactDiscToStoreScreen();
		}
	});
	smUpdateStore.add(addCD);
	
	JMenuItem addDVD = new JMenuItem("Add DVD");
	addDVD.addActionListener(new ActionListener() {
		@Override
	    public void actionPerformed(ActionEvent e) {
			new AddDigitalVideoDiscToStoreScreen();
		}
	});
	smUpdateStore.add(addDVD);
	
	menu.add(smUpdateStore);

	//
	JMenuItem viewStore = new JMenuItem("View store");
	viewStore.addActionListener(new viewStoreListener(this.store));
	menu.add(viewStore);
	
	//
	JMenuItem viewCart = new JMenuItem("View cart");
	viewCart.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent evt) {
			new CartScreen(cart);
		  }
		});
	menu.add(viewCart);
	
	JMenuBar menuBar = new JMenuBar();
	menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	menuBar.add(menu);
	
	return menuBar;
  }
  
  private class viewStoreListener implements ActionListener {
	Store store = new Store();
    public viewStoreListener(Store store) {
    	this.store = store;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		new StoreScreen(store);
		
	}
}

JPanel createHeader() {
	JPanel header = new JPanel();
	header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
	
	JLabel title = new JLabel("AIMS - NNAT - 20215143");
	title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
	//title.setForeground(new Color(70, 130, 180));
	title.setForeground(new Color(0, 0 , 128));
	
	JButton viewcart = new JButton("View cart");
	viewcart.setPreferredSize(new Dimension(100, 50));
	viewcart.setMaximumSize(new Dimension(100, 50));
	viewcart.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent evt) {
		new CartScreen(cart);
	  }
	});
	
	header.add(Box.createRigidArea(new Dimension(10, 10)));
	header.add(title);
	header.add(Box.createHorizontalGlue());
	header.add(viewcart);
	header.add(Box.createRigidArea(new Dimension(10, 10)));
  
	return header;
  }
  
  JPanel createCenter() {
	JPanel center = new JPanel();
	center.setLayout(new GridLayout(3, 3, 2, 2));
	
	ArrayList<Media> mediaInStore = store.getItemsInStore();
    for(int i=0; i<mediaInStore.size(); i++) {
      MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
      center.add(cell);
    }
    
    return center;
  }

  public StoreScreen(Store store) {
	this.store = store;
	Container cp = getContentPane();
	cp.setLayout(new BorderLayout());
	
	cp.add(createNorth(), BorderLayout.NORTH);
	cp.add(createCenter(), BorderLayout.CENTER);

	setVisible(true);
	setTitle("Store - NNAT - 20215143");
	setSize(1024, 768);
  }
  
  public void reloadStoreScreen() {
	new StoreScreen(this.store);
	this.dispose();
  }
}
