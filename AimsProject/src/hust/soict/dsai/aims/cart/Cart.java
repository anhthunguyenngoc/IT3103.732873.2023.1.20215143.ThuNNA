//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Cart {
  private static final int MAX_NUMBERS_ORDERED = 20;				//Số lượng DVD max trong giỏ hàng
  private ArrayList<Media> itemsOrdered = new ArrayList<Media>();	//Mảng chứa các DVD														
    
  //Thêm DVD vào giỏ hàng
  public void addMedia(Media media) {
	if(media==null) return;
	if(itemsOrdered.size()==MAX_NUMBERS_ORDERED) System.out.println("The cart is almost full");  //Nếu số lượng DVD trong giỏ hàng = max sẽ thông báo đầy
	else {
	  if(itemsOrdered.contains(media)) {
		System.out.println("The media is already on the cart");
		return;
	  }
	  itemsOrdered.add(media);
	  System.out.println("The media has been added");									//Thông báo thêm vào giỏ hàng thành công
    }
  }
  
  //Xóa 1 DVD khỏi giỏ hàng
  public void removeMedia(Media media) {
	if(itemsOrdered.contains(media)) {
	  itemsOrdered.remove(media);
	  System.out.println("The media has been removed");
	}
	else System.out.println("The media is not found");		
  }

  //Tính tổng
  public float totalCost() {
	float sum = 0;
	for(int i=0; i<itemsOrdered.size(); i++) {
	  sum+=itemsOrdered.get(i).getCost();
	}
	return sum;
  }
  
  //Hiện giỏ hàng
  public void viewCart() {
	System.out.println("**********************************CART**********************************");
	System.out.println("Ordered Items:");
	for(int i=0; i<itemsOrdered.size(); i++) {
	  System.out.println((i+1)+itemsOrdered.get(i).getTitle()); 
	}
	System.out.println("Total cost: "+totalCost()+"$");
	System.out.println("************************************************************************");
  }
}