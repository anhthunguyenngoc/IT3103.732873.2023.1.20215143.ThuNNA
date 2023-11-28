//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {

  public static void main(String[] args) {
	Cart cart = new Cart();									//Tạo giỏ hàng
	DigitalVideoDisc dvdList[] = new DigitalVideoDisc[20];	//Tạo mảng danh sách các dvd
	
	//Tạo dvd
	dvdList[0] = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
	dvdList[1] = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
	dvdList[2] = new DigitalVideoDisc("Sousou no frieren", "Adventure", 40.00f);		
	dvdList[3] = new DigitalVideoDisc("The Husky Bob", "Comedy", "Bobby", 180, 99.00f);	
	
	//----------THÊM DVD	 
	cart.addDigitalVideoDisc(dvdList);					//Thêm danh sách các dvd vào giỏ hàng
	//cart.addDigitalVideoDisc(dvdList[0], dvdList[1]);	//Thêm 2 dvd vào giỏ hàng
	//cart.addDigitalVideoDisc2(dvdList[0], dvdList[1], dvdList[2], dvdList[3]); //Thêm các dvd vào giỏ hàng vối số lượng đvd tùy ý
	
	//----------HIỆN GIỎ HÀNG
	cart.viewCart();
	
	//----------TÌM KIẾM DVD
	System.out.println("Search Results:");
	//Tìm kiếm theo id
	//cart.searchById(1);						
	//cart.searchById(10);						//không có dvd có id=10
	
	//Tìm kiếm theo tiêu đề
	//cart.searchByTitle("The Lion King");		//tìm kiếm theo tiêu đề cụ thể
	//cart.searchByTitle("The");				//tìm kiếm theo từ khóa
	//cart.searchByTitle("Shingeki no Kyojin"); //dvd không có trong giỏ hàng    
	}
}
