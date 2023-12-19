package hust.soict.dsai.aims.media;
//Nguyễn Ngọc Anh Thư - 20215143
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
  public String getTitle() {
	return title;
  }
  public int getLength() {
	return length;
  }
  //Play Track
  public String play() {
	if(getLength()<=0) {
	  return "The track cannot be played";
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
  public String toString() {
	return this.title +"-"+ this.length;
  }
}
