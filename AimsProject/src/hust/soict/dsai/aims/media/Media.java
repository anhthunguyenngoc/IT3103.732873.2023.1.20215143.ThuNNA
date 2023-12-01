package hust.soict.dsai.aims.media;

public abstract class Media {
  protected String title;
  protected String category;
  protected float cost;
  private static int nbDigitalVideoDiscs=1;
  protected int id=nbDigitalVideoDiscs;
  
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
  
}
