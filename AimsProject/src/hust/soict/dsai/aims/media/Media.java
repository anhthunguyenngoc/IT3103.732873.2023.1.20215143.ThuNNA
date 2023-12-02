package hust.soict.dsai.aims.media;
import java.util.Comparator;

public abstract class Media {
  protected String title;
  protected String category;
  protected float cost;
  private static int nbDigitalVideoDiscs=1;
  protected int id=nbDigitalVideoDiscs;
  public static Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
  public static Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
  public Media() {
	super();
	nbDigitalVideoDiscs++; 
  }

  public Media(String title, String category, float cost) {
	super();
	this.title = title;
	this.category = category;
	this.cost = cost;
	nbDigitalVideoDiscs++; 
  }

  public int getId() {
	return id;
  }

  public String getTitle() {
	return title;
  }

  public String getCategory() {
	return category;
  }

  public float getCost() {
	return cost;
  }
  
  public boolean equals(Object obj) {
	if(obj instanceof Media) {
	  Media other = (Media) obj;
	  return other.title.equals(this.title);
	}
	return false;
  }
  
  public abstract String toString();
  
}
