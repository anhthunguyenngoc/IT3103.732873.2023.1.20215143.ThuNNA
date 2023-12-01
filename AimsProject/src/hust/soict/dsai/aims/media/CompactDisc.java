package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
  private String artist;
  private List<Track> tracks = new ArrayList<Track>();
  
  public CompactDisc() {
	super();
  }
	
  public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
	super(id, title, category, cost, director, length);
	this.artist = artist;
  }

  public String getArtist() {
	return artist;
  }
  
  public String getTitle() {
	return title;
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
  
  public void play() {
	if(getLength()<=0) {
	  System.out.println("The CD cannot be played");
	  return;
	}
	System.out.println("Playing CD: " + this.getTitle());
	System.out.println("CD length: " + this.getLength());
	System.out.println("Playing list of tracks: " + this.getTitle());
	for(Track c : tracks) {
	  c.play();
	}
  }
}
