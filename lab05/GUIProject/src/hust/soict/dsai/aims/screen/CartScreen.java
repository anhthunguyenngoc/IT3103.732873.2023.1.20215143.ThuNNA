package hust.soict.dsai.aims.screen;
import java.io.IOException;

import javax.swing.JFrame;
import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//Nguyễn Ngọc Anh Thư - 20215143
public class CartScreen extends JFrame{
  private Cart cart = new Cart();	
  private JFXPanel fxPanel = new JFXPanel();
  
  public CartScreen(Cart cart) {
	super();
	this.cart = cart;
	
	this.add(fxPanel);
	
	this.setTitle("Cart - NNAT - 20215143");
	this.setSize(1040, 640);
	this.setVisible(true);
	Platform.runLater(new cartScreen(this));	
  }
  
  private class cartScreen implements Runnable{
	private JFrame jframe;
	
	public cartScreen(JFrame jframe) {
	  this.jframe = jframe;
	}
	  @Override
	public void run() {
	  try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
		CartScreenController controller = new CartScreenController(cart, jframe);
		loader.setController(controller);
		Parent root = loader.load();
		fxPanel.setScene(new Scene(root));
	  }catch (IOException e) {
		e.printStackTrace();
	  }
	}
  }
}
