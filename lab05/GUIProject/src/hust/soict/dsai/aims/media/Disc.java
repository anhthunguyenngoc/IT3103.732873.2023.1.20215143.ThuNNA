package hust.soict.dsai.aims.media;
//Nguyễn Ngọc Anh Thư - 20215143
public class Disc extends Media {
  protected String director;
  protected int length;
  //Constructor
  public Disc() {
	super();
  }
  public Disc(String title, String category, float cost, String director, int length) {
	super(title, category, cost);
	this.director = director;
	this.length = length;
  }
  //Getter
  public String getDirector() {
	return director;
  }

  public int getLength() {
	return length;
  }   
  //Override toString 
  public String toString() {
	return null;
  }
}
