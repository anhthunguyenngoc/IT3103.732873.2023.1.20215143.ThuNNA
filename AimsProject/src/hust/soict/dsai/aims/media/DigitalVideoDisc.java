package hust.soict.dsai.aims.media;
import java.util.Objects;
//Nguyễn Ngọc Anh Thư - 20215143
public class DigitalVideoDisc extends Disc implements Playable{
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
  
  //Kiểm tra dvd có tiêu đề có chứa chuỗi đang tìm không
  public boolean isMatch(String title) {
	return this.title.contains(title);
  }
  
  //Kiểm tra dvd có id giống với id đang tìm không
  public boolean isMatch(int id) {
	return this.id == id;
  }
  
  public void play() {
	if(getLength()<=0) {
	  System.out.println("The DVD cannot be played");
	  return;
	}
	System.out.println("Playing DVD: " + this.getTitle());
	System.out.println("DVD length: " + this.getLength());
  }
}
