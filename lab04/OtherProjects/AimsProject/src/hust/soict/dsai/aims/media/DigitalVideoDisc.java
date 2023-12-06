package hust.soict.dsai.aims.media;
//Nguyễn Ngọc Anh Thư - 20215143

import java.util.Comparator;

public class DigitalVideoDisc extends Disc implements Playable, Comparator<DigitalVideoDisc>{
//Tạo các constructor
  public DigitalVideoDisc() {
	super(); 
  }
  public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
	super(title, category, cost, director, length);
  }
  
  //Trả về thông tin của dvd 
  public String toString() {
    return this.id+". DVD - "+this.title+" - "+this.category+" - "+this.director+" - "+this.length+": "+this.cost+"$";
  }
  
  //Play dvd
  public void play() {
	if(getLength()<=0) {
	  System.out.println("The DVD cannot be played");
	  return;
	}
	System.out.println("Playing DVD: " + this.getTitle());
	System.out.println("DVD length: " + this.getLength());
  }
@Override
  public int compare(DigitalVideoDisc o1, DigitalVideoDisc o2) {
	if(o1.title.equals(o2.title)) {				//Nếu tiêu đề giống nhau thì so sánh length
	  if(o1.length == o2.length) {				//Nếu tiêu đề giống nhau thì so sánh cost
		if(o1.cost == o2.cost) return 0;
		else if(o1.cost > o2.cost) return 1;
		else return -1;
	  }			
	  else if(o1.length > o2.length) return 1;
	  else return -1;
	} else return o1.title.compareTo(o2.title); //Nếu tiêu đề khác thì trả vè kết quả của compareTo
  }
}
