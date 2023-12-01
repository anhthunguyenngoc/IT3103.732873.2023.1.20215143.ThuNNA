//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;

public class Aims {
  public static void main(String[] args) {
	Book bk = new Book(1, "Book", "cato", 100);
	Cart cart = new Cart();
	cart.addMedia(bk);
	cart.viewCart();
  }
}
