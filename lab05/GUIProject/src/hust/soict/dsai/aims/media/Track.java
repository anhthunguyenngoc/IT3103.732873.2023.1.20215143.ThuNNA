package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
  private String title;
  private int length;
  
  //Constructor
  public Track() { super(); }
  public Track(String title, int length) {
	super();
	this.title = title; this.length = length;
  }  
  //Getter
  public String getTitle() { return title; }
  public int getLength() { return length; }
  
  //Play Track								//Nguyễn Ngọc Anh Thư - 20215143
  public String play() throws PlayerException{
	if(getLength()<=0) {
	  throw new PlayerException("ERROR: Track's length is non-positive!");
	}
	String str = "<html>Playing Track: " + this.getTitle();
	str += "<br/>Track length: " + this.getLength()+"</html>";  
	return str;
  }
  
  //Override equals nếu title và length bằng nhau thì 2 Track giống nhau
  public boolean equals(Object obj) {
	if(obj instanceof Track) {
	  Track other = (Track) obj;
	  if(other.title.equals(this.title) && other.length == this.length) return true;
	  return false;
	} return false;
  }
  
  //Trả về thông tin Track
  public String toString() { return this.title +"-"+ this.length;  }
}
