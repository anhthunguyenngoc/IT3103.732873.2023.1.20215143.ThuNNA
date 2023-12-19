package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
//Nguyễn Ngọc Anh Thư - 20215143
public class CompactDisc extends Disc implements Playable {
  private String artist;
  private List<Track> tracks = new ArrayList<Track>();
  //Constructor
  public CompactDisc() {
	super();
  }
  public CompactDisc(String title, String category, float cost, String director, String artist) {
	super(title, category, cost, director, 0);
	this.artist = artist;
  }
  //Getter
  public String getArtist() {
	return artist;
  }
  public int getLength() {  		//Length CD = tổng length các track
	int sum=0;
	for(Track c : tracks) {
	  sum+=c.getLength();
	}
	return sum;
  }
  //Thêm track
  public void addTrack(Track trk) {
	if(!tracks.contains(trk)) {
	  tracks.add(trk);
	  System.out.println("The track has been added.");
	} else System.out.println("The track is already on the list.");
  }
  //Xóa Track
  public void removeTrack(Track trk) {
	if(tracks.contains(trk)) {
	  tracks.remove(trk);
	  System.out.println("The track has been removed.");
	} else System.out.println("The track isn't on the list.");
  }
  //Play CD
  public String play() {
	if(getLength()<=0) {
	  return "The CD cannot be played";
	}
	String str = "<html>Playing CD: " + this.title;
	str+="<br/>CD length: " + this.getLength();
	str+="<br/>Playing list of tracks: ";
	for(Track c : tracks) {
	  str+= "<br/>"+c.play();				//Gọi hàm play() của Track
	}
	str += "</html>";
	return str;
  }
  //Trả về thông tin của CD
  public String toString() {
	String str = this.id+". CD - "+this.title+" - "+this.category+" - "+this.director+" - "+this.artist+" - "+this.length+" - "+" Tracks: ";
    if(tracks.size()>0) {
      str += tracks.get(0);
      for(int i=1; i< tracks.size(); i++) {
    	str += ", " + tracks.get(i);
      }
    }
    str += ": " +this.cost+"$";
	return str;
  }
}
