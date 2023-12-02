package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
  private List<String> author = new ArrayList<String>();

  public Book() {
	super();
  }

  public Book(String title, String category, float cost) {
	super(title, category, cost);
  }

  public void addAuthor(String au) {
	if(!author.contains(au)) {
	  author.add(au);
	  System.out.println("The author has been added.");
	}else System.out.println("The author is already on the list.");
  }
  
  public void removeAuthor(String au) {
	if(author.contains(au)) {
	  author.remove(au);
	  System.out.println("The author has been removed.");
	}else System.out.println("The author isn't on the list.");
  }
  
  public String toString() {
	String str = this.id+". Book - "+this.title+" - "+this.category+" - "+"Authors: ";
	if(author.size()>0) {
	  str += author.get(0);
	  for(int i=1; i<author.size(); i++) {
	    str += ", "+author.get(i);
	  }
	}
	str += ": " + this.cost+"$";
	return str;
  }
}
