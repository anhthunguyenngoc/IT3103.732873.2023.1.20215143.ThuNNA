//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import javax.naming.LimitExceededException;
import hust.soict.dsai.aims.exception.MediaException;
import hust.soict.dsai.aims.media.Media;

public class Store {
  private final static int MAX_NUMBERS_ITEMS = 1000;
  private ArrayList<Media> itemsInStore = new ArrayList<Media>();
  
  public Store() { }
  
 //Thêm 1 DVD vào cửa hàng
  public boolean addMedia(Media media) throws Exception {
	//Nếu media's title rỗng hoặc chỉ chứa khoảng trắng
	if(media.getTitle().trim().isEmpty()) 	   throw new NullPointerException("ERROR: The media's title is NULL");
	
	//Nếu số lượng media trong cửa hàng đã đầy
	if(itemsInStore.size()==MAX_NUMBERS_ITEMS) throw new LimitExceededException("ERROR: The number of media has reached its limit"); 
	
	//Nếu media đã có trog cửa hàng
	if(itemsInStore.contains(media)) 		   throw new MediaException("ERROR: The media has already on the store");
	
	//Thêm media vào giỏ hàng và return true
	itemsInStore.add(media);
	return true;
  }
  
  //Xóa 1 DVD khỏi cửa hàng
  public boolean removeMedia(Media media) throws MediaException { 
	if(itemsInStore.contains(media)) {		//Ktra media có trong giỏ hàng không?
	  itemsInStore.remove(media);
	  return true;										
	}
	throw new MediaException("ERROR: The media hasn't on the store"); //nếu không tìm thấy 
  }
  
  //Nguyễn Ngọc Anh Thư - 20215143

  //Phương thức kiểm tra có tồn tại media có tiêu đề=title trong store không?
  public Media mediaInStore(String title) {
	for(Media media : itemsInStore) {
	  if(media.getTitle().equals(title)) {
		return media;			//Nếu tìm thấy trả về media
	  }	
	} return null;				//Không tìm thấy trả về null
  }

  //Trả về mảng các media trong cửa hàng
  public ArrayList<Media> getItemsInStore() {
	return itemsInStore;
  }
}
