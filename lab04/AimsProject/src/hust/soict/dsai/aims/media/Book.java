//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media {
  private List<String> author = new ArrayList<String>();
  //Constructor
  public Book() {
	super();
  }
  public Book(String title, String category, float cost) {
	super(title, category, cost);
  }
  //Thêm tên tác giả
  public void addAuthor(String au) {
	if(!author.contains(au)) {		//Kiểm tra trong list có tên tác giả không?
	  author.add(au);				//Nếu không có thì thêm vào
	  System.out.println("The author has been added.");
	}else System.out.println("The author is already on the list.");
  }
  //Xóa tên tác giả
  public void removeAuthor(String au) {
	if(author.contains(au)) {		//Kiểm tra trong list có tên tác giả không?
	  author.remove(au);			//Nếu có thì xóa
	  System.out.println("The author has been removed.");
	}else System.out.println("The author isn't on the list.");
  }
  //Trả về thông tin của Book
  public String toString() {
	String str = this.id+". Book - "+this.title+" - "+this.category+" - "+"Authors: ";
	if(author.size()>0) {			//Nếu có tên tác giả thì trả về danh sách các tên
	  str += author.get(0);
	  for(int i=1; i<author.size(); i++) {
	    str += ", "+author.get(i);
	  }
	}
	str += ": " + this.cost+"$";
	return str;
  }
}
