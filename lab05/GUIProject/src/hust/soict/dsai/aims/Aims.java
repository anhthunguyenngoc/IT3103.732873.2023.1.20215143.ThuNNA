//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class Aims {
  public static Store store = new Store();
  public static Cart cart = new Cart();
  
	public static void main(String[] args) {	
	//Thêm các media vào store
	  Book book = new Book("Star Wars", "Science Fiction", 54.45f ); 
	  CompactDisc cd = new CompactDisc("Sousou no frieren", "Adventure", 40.00f, "Keiichirou Saitou", null);
	  DigitalVideoDisc dvd = new DigitalVideoDisc("An Lion King", "Animation", 19.95f, "Roger Allers", 87);  
	  Book book1 = new Book("Star War", "Science Fiction", 54.45f ); 
	  CompactDisc cd1 = new CompactDisc("Sousou no friere", "Adventure", 40.00f, "Keiichirou Saitou", null);
	  DigitalVideoDisc dvd1 = new DigitalVideoDisc("An Lion Kin", "Animation", 19.95f, "Roger Allers", 87); 
	  Book book2 = new Book("Star Wr", "Science Fiction", 54.45f ); 
	  
	//catch exception của addMedia
	  try {
		store.addMedia(cd);store.addMedia(book); 
		store.addMedia(dvd); 
		store.addMedia(book1); store.addMedia(cd1); store.addMedia(dvd1); store.addMedia(book2);
	  } catch (Exception e) { } 
	
	//Mở cửa hàng
	  new StoreScreen(Aims.store);
	}
}  