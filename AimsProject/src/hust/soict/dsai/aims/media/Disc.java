package hust.soict.dsai.aims.media;

public class Disc extends Media {
  protected String director;
  protected int length;
  
  public String getDirector() {
	return director;
  }

  public int getLength() {
	return length;
  } 
  
  public Disc() {
	super();
  }
  
  public Disc(String director) {
	super();
	this.director = director;
  }

  public Disc(String director, int length) {
	super();
	this.director = director;
	this.length = length;
  }
}
