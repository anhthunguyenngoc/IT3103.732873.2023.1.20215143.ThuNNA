package hust.soict.dsai.aims.media;

public class Track implements Playable{
  private String title;
  private int length;
  
  public Track() {
	super();
  }

  public Track(String title, int length) {
	super();
	this.title = title;
	this.length = length;
  }
  
  public String getTitle() {
	return title;
  }
  
  public int getLength() {
	return length;
  }
  
  public void play() {
	if(getLength()<=0) {
	  System.out.println("The track cannot be played");
	  return;
	}
	System.out.println("Playing Track: " + this.getTitle());
	System.out.println("Track length: " + this.getLength());  
  }
  
  public boolean equals(Object obj) {
	if(obj instanceof Track) {
	  Track other = (Track) obj;
	  if(other.title.equals(this.title) && other.length == this.length) return true;
	  return false;
	}
	return false;
  }
  
  public String toString() {
	return this.title +"-"+ this.length;
  }
}
