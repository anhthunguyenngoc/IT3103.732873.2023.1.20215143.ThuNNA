package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {
  private String artist;
  private List<Track> tracks = new ArrayList<Track>();
  
  public CompactDisc() {
	super();
  }
	
  public CompactDisc(String artist) {
	super();
	this.artist = artist;
  }

  public String getArtist() {
	return artist;
  }
  
  public int getLength() {
	int sum=0;
	for(Track c : tracks) {
	  sum+=c.getLength();
	}
	return sum;
  }
  
  public void addTrack(Track trk) {
	if(!tracks.contains(trk)) {
	  tracks.add(trk);
	  System.out.println("The track has been added.");
	} else System.out.println("The track is already on the list.");
  }
  
  public void removeTrack(Track trk) {
	if(tracks.contains(trk)) {
	  tracks.remove(trk);
	  System.out.println("The track has been removed.");
	} else System.out.println("The track isn't on the list.");
  }
}
