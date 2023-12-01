//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
  private final static int MAX_NUMBERS_ITEMS = 1000;
  private ArrayList<Media> itemsInStore = new ArrayList<Media>();
  
  //Thêm 1 DVD vào cửa hàng
  public void addMedia(Media media) {
    if(media==null) return;
    if(itemsInStore.size()==MAX_NUMBERS_ITEMS) System.out.println("The store is almost full");//Nếu số lượng DVD trong cửa hàng = max sẽ thông báo đầy
    else {
      if(itemsInStore.contains(media)) {
    	System.out.println("The media is already on the store");	
    	return;
      }
	  itemsInStore.add(media);
	  System.out.println("The media has been added");								  //Thông báo thêm vào cửa hàng thành công
    }
  }
  
  //Xóa 1 DVD khỏi cửa hàng
  public void removeMedia(Media media) { 
	if(itemsInStore.contains(media)) {
	  itemsInStore.remove(media);
	  System.out.println("The media has been deleted");	//Thông báo xóa đĩa thành công
	}
	else System.out.println("The media is not found");	//không tìm thấy đĩa
  }
}
