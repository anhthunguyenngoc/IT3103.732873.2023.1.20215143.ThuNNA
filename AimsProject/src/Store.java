//Nguyễn Ngọc Anh Thư - 20215143

public class Store {
  private final static int MAX_NUMBERS_ITEMS = 1000;
  private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_ITEMS];
  private int itemsNumber;
  
  //Thêm 1 DVD vào cửa hàng
  public void addDVD(DigitalVideoDisc disc) {
    if(disc==null) return;
    if(itemsNumber==MAX_NUMBERS_ITEMS) System.out.println("The store is almost full");//Nếu số lượng DVD trong cửa hàng = max sẽ thông báo đầy
    else {
	  itemsInStore[itemsNumber] = disc;
	  itemsNumber++;
	  System.out.println("The disc has been added");								  //Thông báo thêm vào cửa hàng thành công
    }
  }
  
  //Xóa 1 DVD khỏi cửa hàng
  public void removeDVD(DigitalVideoDisc disc) {
	int temp = -1;
	for(int i=0; i<itemsNumber; i++) { 
	  if(itemsInStore[i].equals(disc)) {						
		temp=i;
		break;
	  }
	}
	if(temp==-1) System.out.println("The disc is not found");	//Nếu temp không thay đổi => không tìm thấy đĩa
	else {
	  for(int i=temp; i<itemsNumber; i++) {
		itemsInStore[i] = itemsInStore[i+1];					//Đẩy các đĩa sau đĩa bị xóa lên trước trong mảng
	  }
	  itemsNumber--;
	  System.out.println("The disc has been deleted");			//Thông báo xóa đĩa thành công
	}
  }
}
