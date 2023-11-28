//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.lab02;

public class Cart {
  private static final int MAX_NUMBERS_ORDERED = 20;									//Số lượng DVD max trong giỏ hàng
  private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];	//Mảng chứa các DVD
  private int qtyOrdered;																//Số lượng DVD trong giỏ hàng
  
  //Thêm DVD vào giỏ hàng
  public void addDigitalVideoDisc(DigitalVideoDisc disc) {
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
  
  //Hiện giỏ hàng
  public void viewCart() {
	System.out.println("======================================Your current cast=====================================");
	for(int i=0; i<qtyOrdered; i++) {
	  System.out.println((i+1)+". "+itemsOrdered[i].getTitle()+", "+itemsOrdered[i].getCategory()+", "+itemsOrdered[i].getCost()); 
	}
	System.out.println("The total cost is: "+totalCost());
	System.out.println("============================================================================================");
  }
}
