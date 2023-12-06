//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.lab02;

public class Aims {
  public static void main(String[] args) {
//Tạo giỏ hàng
    Cart anOrder = new Cart(); 

//Tạo DVD    
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");										//Tạo DVD bằng tiêu đề
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Sousou no frieren", "Adventure", 40.00f);				//Tạo DVD bằng tiêu đề, phân loại, giá
    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Good night world","Thrilling" ,"Uru Okabe", 25.50f);	//Tạo DVD bằng tiêu đề, phân loại, đạo diễn, giá
    DigitalVideoDisc dvd4 = new DigitalVideoDisc("Hametsu no Oukoku", "Fiction", "Yoruhashi", 32.35f);
    DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion Bob", "Comedy", "Bobby", 180, 99.00f);		//Tạo DVD bằng tiêu đề, phân loại, đạo diễn, thời lượng, giá

//TestCase1: Thêm DVD vào giỏ hàng thành công
    anOrder.addDigitalVideoDisc(dvd1); anOrder.addDigitalVideoDisc(dvd2); anOrder.addDigitalVideoDisc(dvd3); anOrder.addDigitalVideoDisc(dvd4); anOrder.addDigitalVideoDisc(dvd5); //Thêm DVD 1-5 vào giỏ hàng

//TestCase2: Thêm DVD thứ 21 thất bại (giỏ hàng đầy)    
//    anOrder.addDigitalVideoDisc(dvd1); anOrder.addDigitalVideoDisc(dvd2); anOrder.addDigitalVideoDisc(dvd3); anOrder.addDigitalVideoDisc(dvd4); anOrder.addDigitalVideoDisc(dvd5); //Thêm DVD 6-10 vào giỏ hàng
//    anOrder.addDigitalVideoDisc(dvd1); anOrder.addDigitalVideoDisc(dvd2); anOrder.addDigitalVideoDisc(dvd3); anOrder.addDigitalVideoDisc(dvd4); anOrder.addDigitalVideoDisc(dvd5); //Thêm DVD 11-15 vào giỏ hàng
//    anOrder.addDigitalVideoDisc(dvd1); anOrder.addDigitalVideoDisc(dvd2); anOrder.addDigitalVideoDisc(dvd3); anOrder.addDigitalVideoDisc(dvd4); anOrder.addDigitalVideoDisc(dvd5); //Thêm DVD 16-20 vào giỏ hàng    
//    anOrder.addDigitalVideoDisc(dvd5);		//Thêm DVD thứ 21 vào giỏ hàng

//TestCase3: Xóa 1 DVD khỏi giỏ hàng       
//    anOrder.viewCart(); 					//Xem giỏ hàng
//    anOrder.removeDigitalVideoDisc(dvd5);   //Xóa dvd5 khỏi giỏ hàng
//    anOrder.viewCart();  

//TestCase4: Xóa 1 DVD khỏi giỏ hàng thất bại (không tìm thấy DVD)
//    DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Lion Bobbe");	//Tạo DVD mới nhưng không thêm vào giỏ hàng
//    anOrder.removeDigitalVideoDisc(dvd6); 							//Chương trình thông báo không tìm thấy đĩa trong giỏ hàng
 
//TestCase5: Hiện tổng tiền   
// 	  System.out.println("Total Cost is: " + anOrder.totalCost());		//Hiện tổng tiền  
  }
}
