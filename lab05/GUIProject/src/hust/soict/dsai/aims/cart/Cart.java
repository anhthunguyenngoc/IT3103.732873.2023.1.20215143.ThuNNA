//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.aims.cart;
import java.util.Collections;
import javax.naming.LimitExceededException;
import hust.soict.dsai.aims.exception.MediaException;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.*;

public class Cart {
  private static final int MAX_NUMBERS_ORDERED = 20;				//Số lượng DVD max trong giỏ hàng
  private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();	//Mảng chứa các DVD														
  
  public Cart() { }
  
  //Thêm DVD vào giỏ hàng
  public boolean addMedia(Media media) throws Exception{
	//Nếu media's title rỗng hoặc chỉ chứa khoảng trắng
	if(media.getTitle().isEmpty()) 				 throw new NullPointerException("ERROR: The media's title is NULL");
	
	//Nếu số lượng media trong cửa hàng đã đầy
	if(itemsOrdered.size()==MAX_NUMBERS_ORDERED) throw new LimitExceededException("ERROR: The number of media has reached its limit");  
	
	//Nếu media đã có trog cửa hàng
	if(itemsOrdered.contains(media)) 			 throw new MediaException("ERROR: The media has already on the cart");
	
	//Thêm media vào giỏ hàng và return true
	itemsOrdered.add(media);					
	return true;
  }
  
  //Xóa 1 DVD khỏi giỏ hàng 
  public boolean removeMedia(Media media) throws MediaException {
	if(itemsOrdered.contains(media)) {	//Nếu trong mảng chứa media
	  itemsOrdered.remove(media);		//Xóa khỏi giỏ hàng
	  return true;
	}
	throw new MediaException("ERROR: The media hasn't on the cart");  //nếu không tìm thấy
  }
  
  //Tính tổng 
  public float totalCost() {
	float sum = 0;
	for(int i=0; i<itemsOrdered.size(); i++) {
	  sum+=itemsOrdered.get(i).getCost();
	}
	return sum;
  }
  
  //Sort by title
  public void sortByTitle() {
	Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
  }
  
  //Sort by cost
  public void sortByCost() {
	Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
  }
  
  //Clear giỏ hàng sau khi place order
  public void emptyCart() {
	itemsOrdered.clear();
  }
 
  //Trả về danh sách các media trong giỏ hàng
  public ObservableList<Media> getItemsOrdered(){
	return itemsOrdered;
  }

}