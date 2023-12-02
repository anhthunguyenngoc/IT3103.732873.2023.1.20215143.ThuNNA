package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
  public MediaComparatorByTitleCost() {
	super();
  }
  @Override
  public int compare(Media o1, Media o2) {
	if(o1.title.equals(o2.title)) {
	  if(o1.cost == o2.cost) return 0;
	  else if(o1.cost > o2.cost) return 1;
	  else return -1;
	} else return o1.title.compareTo(o2.title);
  }
}
