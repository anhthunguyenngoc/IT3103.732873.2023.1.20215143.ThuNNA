package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
  private List<String> author = new ArrayList<String>();
  
  public Book(int id) {
	super();
	this.id = id;
}

public void addAuthor(String au) {
	if(!author.contains(au)) {
	  author.add(au);
	  System.out.println("The author has been added.");
	}else System.out.println("The author has already in the list.");
  }
  
  public void removeAuthor(String au) {
	if(author.contains(au)) {
	  author.remove(au);
	  System.out.println("The author has been removed.");
	}else System.out.println("The author isn't in the list.");
  }
}
