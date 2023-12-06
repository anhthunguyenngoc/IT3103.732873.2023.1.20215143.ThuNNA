package hust.soict.dsai.aims.media;
import java.util.Comparator;
public class MediaComparatorByTitleCost implements Comparator<Media>{
  public MediaComparatorByTitleCost() {
	super();  									//Constructor
  }
  @Override 
  public int compare(Media o1, Media o2) {
	if(o1.title.equals(o2.title)) {				//Nếu tiêu đề giống nhau thì so sánh cost
	  if(o1.cost == o2.cost) return 0;			
	  else if(o1.cost > o2.cost) return 1;
	  else return -1;
	} else return o1.title.compareTo(o2.title); //Nếu tiêu đề khác thì trả vè kết quả của compareTo
  }
}
//Nguyễn Ngọc Anh Thư - 20215143