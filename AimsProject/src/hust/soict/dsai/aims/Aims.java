//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.aims;
import hust.soict.dsai.aims.media.Book;

public class Aims {
  public static void main(String[] args) {
	Book bk = new Book(1);
	bk.addAuthor("Bob");
	bk.addAuthor("Bobby");
	bk.addAuthor("Bob");
	bk.removeAuthor("Bob");
	bk.removeAuthor("Bobb");
  }
}
