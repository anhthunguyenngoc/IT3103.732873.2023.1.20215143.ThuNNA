//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.aims.cart;
import java.util.Collections;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
  private static final int MAX_NUMBERS_ORDERED = 20;				//Số lượng DVD max trong giỏ hàng
  private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();	//Mảng chứa các DVD														
  
  public Cart() {
	super();
  }
//Thêm DVD vào giỏ hàng
  public int addMedia(Media media) {
		if(media==null) {
		  return -1;
		}//Nếu số lượng DVD trong giỏ hàng = max sẽ thông báo đầy
		if(itemsOrdered.size()==MAX_NUMBERS_ORDERED) return -2;  
		else {
		  if(itemsOrdered.contains(media)) {							//Ktra media đã được thêm vào hay chưa
			return -3;
		  }
		  itemsOrdered.add(media);						//In ra số lượng media trong giỏ hàng
		  return 0;
		}
	  }
  //Xóa 1 DVD khỏi giỏ hàng 
  public void removeMedia(Media media) {
	if(itemsOrdered.contains(media)) {					//Nếu trong mảng chứa media
	  itemsOrdered.remove(media);						//Xóa khỏi giỏ hàng
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
//====Option 1: Filter Cart (ById & ByTitle)=================================
  public static void filterCartMenu() {
	System.out.println("Options: ");
	System.out.println("--------------------------------");
	System.out.println("1. Filter by id");
	System.out.println("2. Filter by title");
	System.out.println("0. Cancel");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2");
  }
  public ObservableList<Media> filterById(int id) {
	ObservableList<Media> filteredList = FXCollections.observableArrayList();
	for(int i=0; i<itemsOrdered.size(); i++) {
	  if(itemsOrdered.get(i).getId()==id) {
		filteredList.add(itemsOrdered.get(i));
	  }	
	}
	return filteredList;
  }
  
  public ObservableList<Media> filterByTitle(String title) {
	ObservableList<Media> filteredList = FXCollections.observableArrayList();
	for(int i=0; i<itemsOrdered.size(); i++) {
	  if(itemsOrdered.get(i).getTitle().contains(title)) {
		filteredList.add(itemsOrdered.get(i));
	  }	
	}
	return filteredList;
  }
 
//====Option 2: Sort Cart (ByTitle & ByCost)=================================
  public static void sortCartMenu() {
	System.out.println("Options: ");
	System.out.println("--------------------------------");
	System.out.println("1. Sort by title");
	System.out.println("2. Sort by cost");
	System.out.println("0. Cancel");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2");
  }
  
  public void sortCart(int num) {
	if(num==1) sortByTitle();
	else if(num==2) sortByCost();
  }
  
  public void sortByTitle() {
	Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
  }
  
  public void sortByCost() {
	Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
  }

  public Media mediaInCart(String title) {
	for (Media media : itemsOrdered) {
	  if(media.getTitle().equals(title)) return media;
	}
	return null;
  }
  
  public void emptyCart() {
	itemsOrdered.clear();
  }
//Nguyễn Ngọc Anh Thư - 20215143   
  //Hiện giỏ hàng
  public void viewCart() {
	System.out.println("**********************************CART**********************************");
	System.out.println("Ordered Items:");
	for(int i=0; i<itemsOrdered.size(); i++) {
	  System.out.println(itemsOrdered.get(i).toString()); 
	}
	if(itemsOrdered.size()==0) System.out.println("The cart is empty");
	System.out.println("Total cost: "+totalCost()+"$");
	System.out.println("************************************************************************");
  }
  
  public static void cartMenu() {
	System.out.println("Options: ");
	System.out.println("--------------------------------");
	System.out.println("1. Filter medias in cart");
	System.out.println("2. Sort medias in cart");
	System.out.println("3. Remove media from cart");
	System.out.println("4. Play a media");
	System.out.println("5. Place order");
	System.out.println("0. Back");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2-3-4-5");
  }
  
  public ObservableList<Media> getItemsOrdered(){
	return itemsOrdered;
  }
}