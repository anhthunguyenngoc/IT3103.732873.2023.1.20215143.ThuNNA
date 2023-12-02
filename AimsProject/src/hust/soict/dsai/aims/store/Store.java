//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
  private final static int MAX_NUMBERS_ITEMS = 1000;
  private ArrayList<Media> itemsInStore = new ArrayList<Media>();

 //=================================Update Store (ADD & REMOVE method)=================================
  public static void updateStoreMenu() {
	System.out.println("Options: ");
	System.out.println("--------------------------------");
	System.out.println("1. Add to store");
	System.out.println("2. Remove from store");
	System.out.println("0. Cancel");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2");
  }
  
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
  
//=================================
  //Hiện cửa hàng
  public void viewStore() {
	System.out.println("**********************************STORE*********************************");
	System.out.println("Store Items:");
	for(int i=0; i<itemsInStore.size(); i++) {
	  System.out.println(itemsInStore.get(i).toString()); 
	}
	if(itemsInStore.size()==0) System.out.println("The store is empty");
	System.out.println("************************************************************************");
  }
  
  public Media mediaInStore(String title) {
	for(Media media : itemsInStore) {
	  if(media.getTitle().equals(title)) {
		return media;
	  }	
	}
	return null;
  }
//=================================Store Menus=================================  
  public static void storeMenu() {
	System.out.println("Options: ");
	System.out.println("--------------------------------");
	System.out.println("1. See a media’s details");
	System.out.println("2. Add a media to cart");
	System.out.println("3. Play a media");
	System.out.println("4. See current cart");
	System.out.println("0. Back");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2-3-4");
  }
  
  public static void mediaDetailsMenu() {
	System.out.println("Options: ");
	System.out.println("--------------------------------");
	System.out.println("1. Add to cart");
	System.out.println("2. Play");
	System.out.println("0. Back");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2");
  }
  
  
  
}
