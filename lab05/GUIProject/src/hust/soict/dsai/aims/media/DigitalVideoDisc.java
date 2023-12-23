package hust.soict.dsai.aims.media;
import java.util.Comparator;
import hust.soict.dsai.aims.exception.PlayerException;

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
  
  //Play dvd										//Nguyễn Ngọc Anh Thư - 20215143
  public String play() throws PlayerException {
	if(getLength()<=0) {	//Ktra nếu length <=0 thì throw exception
	  throw new PlayerException("ERROR: DVD's length is non-positive!");
	}
	String str = "<html>Playing DVD: " + this.getTitle();
	str += "<br/>DVD length: " + this.getLength()+"</html>";
	return str;
  }
}
