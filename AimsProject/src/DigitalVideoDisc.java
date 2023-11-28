//Nguyễn Ngọc Anh Thư - 20215143
import java.util.Objects;
public class DigitalVideoDisc {
  private String title;
  private String category;
  private String director;
  private int length;
  private float cost;
  private static int nbDigitalVideoDiscs=1;
  private int id=nbDigitalVideoDiscs;

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

  @Override
  public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	DigitalVideoDisc other = (DigitalVideoDisc) obj;
	return Objects.equals(category, other.category) && Float.floatToIntBits(cost) == Float.floatToIntBits(other.cost)
			&& Objects.equals(director, other.director) && length == other.length && Objects.equals(title, other.title);
  }
}