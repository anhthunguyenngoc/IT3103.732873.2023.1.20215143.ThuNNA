package hust.soict.dsai.aims.media;
import java.util.Objects;
//Nguyễn Ngọc Anh Thư - 20215143
public class DigitalVideoDisc extends Media {
  private String director;
  private int length;
  private static int nbDigitalVideoDiscs=1;
  
//Tạo các constructor
  public DigitalVideoDisc(String title) {
	super(); 
	this.title = title;
	nbDigitalVideoDiscs++; 
  }
  
  public DigitalVideoDisc(String title, String category, float cost) {
	super();
	this.title = title;
    this.category = category;
    this.cost = cost;
    nbDigitalVideoDiscs++;
  }

  public DigitalVideoDisc(String title, String category, String director, float cost) {
	super();
	this.title = title;
	this.category = category;
	this.director = director;
	this.cost = cost;
	nbDigitalVideoDiscs++;
  }
  
  public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
	this.title = title;
	this.category = category;
	this.director = director;
	this.length = length;
	this.cost = cost;
	nbDigitalVideoDiscs++;
  }

//Nguyễn Ngọc Anh Thư - 20215143
//Tạo các phương thức getter
  public String getTitle() {
	return title;
  }

  public String getCategory() {
	return category;
  }

  public String getDirector() {
	return director;
  }

  public int getLength() {
	return length;
  }

  public float getCost() {
	return cost;
  }
  
  public void setTitle(String title) {
	this.title = title;
  }
//Nguyễn Ngọc Anh Thư - 20215143  
  @Override //override equals
  public boolean equals(Object obj) {
	if (obj instanceof DigitalVideoDisc) {
	  DigitalVideoDisc other = (DigitalVideoDisc) obj;
	  if(!this.title.equals(other.title)) return false;
	  if(!this.category.equals(other.category)) return false;
	  if(!this.director.equals(other.director)) return false;
	  if(this.cost != other.cost) return false;
	  if(this.length != other.length) return false;
	  if(this.id != other.id) return false;
	  return true;
	}
	return false;
  }
  
//=======================================LAB 03=======================================// 
  
  //Trả về thông tin của dvd 
  public String toString() {
    return ". DVD - "+this.title+" - "+this.category+" - "+this.director+" - "+this.length+": "+this.cost+"$";
  }
  
  //Kiểm tra dvd có tiêu đề có chứa chuỗi đang tìm không
  public boolean isMatch(String title) {
	return this.title.contains(title);
  }
  
  //Kiểm tra dvd có id giống với id đang tìm không
  public boolean isMatch(int id) {
	return this.id == id;
  }
}
