//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.aims.media;
import java.util.Comparator;
public class MediaComparatorByCostTitle implements Comparator<Media>{
  public MediaComparatorByCostTitle() {
	super();	//Constructor 
  }
  @Override
  public int compare(Media o1, Media o2) {
	if(o1.cost == o2.cost) {				//Nếu cost = nhau 
	  return o1.title.compareTo(o2.title);  //thì trả về kết quả của compareTo
	}else if(o1.cost>o2.cost) return 1;
	else return -1;
  }
}
