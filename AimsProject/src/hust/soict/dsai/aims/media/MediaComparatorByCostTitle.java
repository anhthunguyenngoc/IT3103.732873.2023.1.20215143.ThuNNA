package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{
  public MediaComparatorByCostTitle() {
	super();	
  }
  @Override
  public int compare(Media o1, Media o2) {
	if(o1.cost == o2.cost) {
	  return o1.title.compareTo(o2.title);
	}else if(o1.cost>o2.cost) return 1;
	else return -1;
  }
}
