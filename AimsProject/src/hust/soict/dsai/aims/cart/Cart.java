//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Cart {
  private static final int MAX_NUMBERS_ORDERED = 20;									//Số lượng DVD max trong giỏ hàng
  private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];	//Mảng chứa các DVD
  private int qtyOrdered;																//Số lượng DVD trong giỏ hàng
  
//=======================================LAB 02=======================================//    
  //Thêm DVD vào giỏ hàng
  public void addDigitalVideoDisc(DigitalVideoDisc disc) {
	if(disc==null) return;
	if(qtyOrdered==MAX_NUMBERS_ORDERED) System.out.println("The cart is almost full");  //Nếu số lượng DVD trong giỏ hàng = max sẽ thông báo đầy
	else {
	  itemsOrdered[qtyOrdered] = disc;
	  qtyOrdered++;
	  System.out.println("The disc has been added");									//Thông báo thêm vào giỏ hàng thành công
    }
  }
  
  //Xóa 1 DVD khỏi giỏ hàng
  public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
	int temp = -1;
	for(int i=0; i<qtyOrdered; i++) { 
	  if(itemsOrdered[i].equals(disc)) {						
		temp=i;
		break;
	  }
	}
	if(temp==-1) System.out.println("The disc is not found");	//Nếu temp không thay đổi => không tìm thấy đĩa
	else {
	  for(int i=temp; i<qtyOrdered; i++) {
		itemsOrdered[i] = itemsOrdered[i+1];					//Đẩy các đĩa sau đĩa bị xóa lên trước trong mảng
	  }
	  qtyOrdered--;
	  System.out.println("The disc has been deleted");			//Thông báo xóa đĩa thành công
	}
  }

  //Tính tổng
  public float totalCost() {
	float sum = itemsOrdered[0].getCost();
	for(int i=1; i<qtyOrdered; i++) {
	  sum+=itemsOrdered[i].getCost();
	}
	return sum;
  }

//=======================================LAB 03=======================================//  

  //Thêm danh sách các dvd vào giỏ hàng 
  public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
	int n = dvdList.length;
	for(int i=0; i<n; i++) { 
	  addDigitalVideoDisc(dvdList[i]);
	}
  }  
  
  //Thêm các dvd vào giỏ hàng vối số lượng đvd tùy ý
  public void addDigitalVideoDisc2(DigitalVideoDisc... dvds){
	  int n = dvds.length;
	  for(int i=0; i<n; i++) { 
	    addDigitalVideoDisc(dvds[i]);
	}
  }     
  
  //Thêm 2 dvd vào giỏ hàng
  public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
	addDigitalVideoDisc(dvd1);
	addDigitalVideoDisc(dvd2);
  }
//Nguyễn Ngọc Anh Thư - 20215143  
  //Tìm kiếm theo tiêu đề
  public void searchByTitle(String title) {
	if(title.equals(null)) { System.out.println("No match is found"); return; }
	int count=0;
	for(int i=qtyOrdered-1; i>=0; i--) {
	  if(itemsOrdered[i].isMatch(title)) {
		count++;  
		System.out.println((count)+itemsOrdered[i].toString()); 
	  }
	}
	if(count==0) System.out.println("No match is found");
  }
  
  //Tìm kiếm theo id
  public void searchById(int id) {
	int count=0;
	for(int i=qtyOrdered-1; i>=0; i--) {
	  if(itemsOrdered[i].isMatch(id)) {
		count++; 
		System.out.println((count)+itemsOrdered[i].toString()); 
	  }
	}
	if(count==0) System.out.println("No match is found");
  }
  
  //Hiện giỏ hàng
  public void viewCart() {
	System.out.println("**********************************CART**********************************");
	System.out.println("Ordered Items:");
	for(int i=0; i<qtyOrdered; i++) {
	  System.out.println((i+1)+itemsOrdered[i].toString()); 
	}
	System.out.println("Total cost: "+totalCost()+"$");
	System.out.println("************************************************************************");
  }
}