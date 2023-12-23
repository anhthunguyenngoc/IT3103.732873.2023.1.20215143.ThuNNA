package hust.soict.dsai.aims.screen;
import java.awt.event.*;
import javax.swing.*;
import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class OptionsListener implements ActionListener {
  private Store store = Aims.store;
  private Cart cart = Aims.cart;
  private JFrame jframe;  
  public OptionsListener(JFrame jframe){ this.jframe = jframe;  }
//Nguyễn Ngọc Anh Thư - 20215143  
  @Override //Xử lí các sự kiện trong menu options
  public void actionPerformed(ActionEvent e) {
	String cmd = e.getActionCommand();
	if(cmd.equals("Add Book")) {
	  new AddBookToStoreScreen();
    }
	else if(cmd.equals("Add CD")) {
	  new AddCompactDiscToStoreScreen();
	}
	else if(cmd.equals("Add DVD")) {
	  new AddDigitalVideoDiscToStoreScreen();
	}
	else if(cmd.equals("View store")) {
	  new StoreScreen(this.store);
	}
	else if(cmd.equals("View cart")) {
	  new CartScreen(this.cart);
	}
	else if(cmd.equals("Remove Media")) {
	  new RemoveMediaFromStoreScreen();
	}
		
	jframe.dispose();
  }
}