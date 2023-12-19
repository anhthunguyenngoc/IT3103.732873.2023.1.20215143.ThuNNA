//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.aims;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	public static Store store = new Store();
	public static void main(String[] args) {	
		Book book = new Book("Star Wars", "Science Fiction", 54.45f ); 
		CompactDisc cd = new CompactDisc("Sousou no frieren", "Adventure", 40.00f, "Keiichirou Saitou", null);
		DigitalVideoDisc dvd = new DigitalVideoDisc("An Lion King", "Animation", 19.95f, "Roger Allers", 87);  
		Book book1 = new Book("Star War", "Science Fiction", 54.45f ); 
		CompactDisc cd1 = new CompactDisc("Sousou no friere", "Adventure", 40.00f, "Keiichirou Saitou", null);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("An Lion Kin", "Animation", 19.95f, "Roger Allers", 87); 
		Book book2 = new Book("Star Wr", "Science Fiction", 54.45f ); 
		store.addMedia(book); store.addMedia(cd); store.addMedia(dvd); 
		store.addMedia(book1); store.addMedia(cd1); store.addMedia(dvd1); store.addMedia(book2);
		new StoreScreen(store);
	  }	
	/*
  static Store store = new Store();
  static Cart cart = new Cart();
  static Scanner keyboard = new Scanner(System.in);
  public static void main(String[] args) {
	//Test case
	Book book = new Book("Star Wars", "Science Fiction", 54.45f ); 
	CompactDisc cd = new CompactDisc("Sousou no frieren", "Adventure", 40.00f, "Keiichirou Saitou", null);
	DigitalVideoDisc dvd = new DigitalVideoDisc("An Lion King", "Animation", 19.95f, "Roger Allers", 87);  
	store.addMedia(book); store.addMedia(cd); store.addMedia(dvd);
	
	cart.addMedia(dvd); cart.addMedia(cd); cart.addMedia(dvd); 
	cd.addTrack(new Track("Yuusha", 198)); cd.addTrack(new Track("Anytime Anywhere", 227)); cd.addTrack(new Track("Yuusha", 200));
	new CartScreen(cart); 
	//
	int num=0;  					//biến num để đọc lựa chọn của người dùng
	do {							//vòng lặp hiện Menu, đọc num, chuyển hướng tùy vào num.
	  showMenu(); 					//show Menu	
	  num = keyboard.nextInt();		//đọc lựa chọn của người dùng 
	  switch(num) {	  				//chuyển hướng = switch case
	  case 1: 						//num = 1 => View store
		aimsViewStore();
		break;
	  case 2: 						//num = 2 => Update store
		aimsUpdateStore();		  
		break;
	  case 3: 						//num = 3 => See current cart
		aimsSeeCart();
		break;
	  case 0: 						//num = 0 => Exit
		System.out.println("Exit");  
		break; 				
	  }
	}while(num!=0);
  }
  
  private static void aimsViewStore() {		  
	int num=0;
	String title;
	Media media;
	store.viewStore();						  //Hiện danh sách các Media trong cửa hàng
	do{	
	  Store.storeMenu(); 					  //Show store menu
	  num = keyboard.nextInt();				  //đọc lựa chọn của người dùng
	  switch(num) {
	  case 1: 								  //  See a media’s details
		storeMediaDetails();
		break;
	  case 2: 								  //Add a media to cart
		System.out.println("Enter title: ");  //Nhập tiêu đề
		keyboard.nextLine(); title = keyboard.nextLine();
		media = store.mediaInStore(title);	  //Gọi hàm trả về kiểu Media để check xem có tồn tại Media có tiêu đề người dùng tìm không? 
		if(media == null) System.out.println("Cannot found the media with that name in cart"); //Nếu Media rỗng => không tồn tại
		else cart.addMedia(media);			  //Media khác rỗng thì thêm vào trong giỏ hàng
		break;
	  case 3: 								  // Play a media
		System.out.println("Enter title: ");  //Nhập tiêu đề
		keyboard.nextLine(); title = keyboard.nextLine();
	    media = store.mediaInStore(title);	  //Gọi hàm trả về Media có tiêu đề đang tìm, trả về media rỗng nếu không có
		playMedia(media);					  //Gọi hàm trong Aims.java
	    break;
	  case 4: 								  //See current cart
		cart.viewCart(); 
		break;
	  case 0: break;						  //Quay lại
	  }
	}while(num!=0);
  }
 
  private static void aimsUpdateStore() {	
	Store.updateStoreMenu();					//Show update menu (add/remove)
	int	num = keyboard.nextInt();				//Ng dùng nhập lựa chọn
	switch(num) {
	case 1:
	  showAddMediaMenu();						//Show add media menu (Book/CD/DVD)
	  addToStore();								//Add a Media
	  break;
	case 2:										//Remove a Media
	  System.out.println("Enter tilte: ");		//Yêu cầu ng dùng nhập tiêu đề
	  keyboard.nextLine();
	  String title = keyboard.nextLine();
	  Media media = store.mediaInStore(title);	//Kiểm tra media có tiêu đề ng dùng vừa nhập có trong store?
	  if(media!=null) store.removeMedia(media); //Nếu có thì xóa khỏi store
	  else System.out.println("The media isn't found"); //Nếu không có thì thông báo
	case 0: break;
	}	
  }

  private static void aimsSeeCart() {
	int num = 0; String title; Media media;
	cart.viewCart();							//Hiện thông tin giỏ hàng
	do{
	  Cart.cartMenu();							//Show cart menu
	  num = keyboard.nextInt();					//Ng dùng nhập option
	  switch(num) {	  
	  case 1:									//Filter cart
		Cart.filterCartMenu();;					//Show filter menu (By id/By title)
		int op = keyboard.nextInt();			//Ng dùng nhập option
		if(op==1) {								//Filter by id
		  System.out.println("Enter id: ");		//Người dùng nhập id
		  int id = keyboard.nextInt();
		  cart.filterById(id);					//Gọi hàm filter trong Cart.java
		}
		else if(op==2){							//Filter by title
		  System.out.println("Enter title: ");  //Người dùng nhập title
		  keyboard.nextLine(); title = keyboard.nextLine();  
		  cart.filterByTitle(title);			//Gọi hàm filter trong Cart.java
		}
		break;
	  case 2:									//Sort cart
		Cart.sortCartMenu();					//Show sort menu (By cost/ By title)
		op = keyboard.nextInt();				//Ng dùng nhập option
		cart.sortCart(op);						//Gọi phương thức trong Cart.java
		break;
	  case 3:									//Remove from cart
		System.out.println("Enter title: ");  	//Ng dùng nhập title
		keyboard.nextLine(); title = keyboard.nextLine();
		media = store.mediaInStore(title);		//Trả về media khác null nếu có trong store
		if(media == null) System.out.println("Cannot found the media with that name in store");
		else cart.removeMedia(media);			//Xóa khỏi giỏ hàng
	    break;
	  case 4:									//Play a media
		System.out.println("Enter title: "); 	//Ng dùng nhập tiêu đề
		keyboard.nextLine(); title = keyboard.nextLine();
	    media = cart.mediaInCart(title);		//Trả về media có tiêu đề vừa nhập, null nếu không có trong cart
		playMedia(media);						//Gọi phương thức trong Aims.java
		break;	  
	  case 5:									//Place an order
		System.out.println("An order is created");
		cart.emptyCart();						//Clear cart
		break;
	  case 0: break;
	  }
	}while(num!=0);
  }

  private static void storeMediaDetails() {
	int num=0;									//biến num đọc lựa chọn của người dùng
	String title;
	System.out.println("Enter title:");			
	keyboard.nextLine();						
	title = keyboard.nextLine(); 				//Yêu cầu người dùng nhập tiêu đề 
	Media media = store.mediaInStore(title);	//Gọi hàm trong Store.java trả về kiểu Media
	if(media == null) System.out.println("The media is not found");  //Nếu trả về Media rỗng => không có Media có tiêu đề người dùng nhập
	else {
	  System.out.println(media.toString());		//Media không rỗng thì in ra thông tin của media
	  do{										
	    Store.mediaDetailsMenu();				//Hiện menu 
	    num = keyboard.nextInt();				//Nhập option
	    if(num==1) {							//num = 1 => thêm media vừa xem thông tin vào giỏ hàng => quay lại
		  cart.addMedia(media);					//gọi hàm trong Cart.java
		  break;
	    }
	    if(num==2) {							//num = 2 => play media
		  playMedia(media);						//gọi hàm trong Aims.java
	    }
	  }while(num!=0);							//num = 0 => quay lại
    }
  }

  private static void addToStore() {
	int op = keyboard.nextInt();								  //Người dùng nhập lựa chọn (Book, CD, DVD)
	String category = null, director; float cost = 0;
	String str = "Please enter title, category, cost";			  //In ra yêu cầu tùy vào option
	if(op==2) str += ", director, artist";
	else if(op==3) str += ", director, length";
	System.out.println(str);	
	keyboard.nextLine(); String title = keyboard.nextLine();	  //Người dùng nhập title, category, cost
	Media media = store.mediaInStore(title);
	if(media==null) {
	  category = keyboard.nextLine();
	  cost = Float.parseFloat(keyboard.next()); 
	}else System.out.println("The media is already on the store");
	
	switch(op) {												  
	case 1:														  //op=1 Add Book
	  Book book;
	  if(media == null) {
		book = new Book(title, category, cost); store.addMedia(book);					  
	  }
	  else book = (Book) media;
	  
	  System.out.println("Do you want to add list of authors (1-yes, 0-no): 1/0"); //Thêm danh sách các tác giả
	  int ans = keyboard.nextInt();								  //nhập ans
	  if(ans==1) {
		String au;
		System.out.println("Enter author's name (enter # to stop).");
		keyboard.nextLine(); 
		while(true) {											  //Thêm tên các tác giả, nếu người dùng nhâp # thì dừng lại
		  au = keyboard.nextLine();
		  if(au.equals("#")) break;
		  book.addAuthor(au);
		}
	  }
	  break; 
	case 2:														//Add CD
	  CompactDisc cd;									
	  if(media == null) {										//Nếu CD không có trong store 
		keyboard.nextLine(); director = keyboard.nextLine();    //thì yêu cầu người dùng nhập thêm thông tin để tạo mới
	    String artist = keyboard.next();
		cd = new CompactDisc(title, category, cost, director, artist); store.addMedia(cd);				  
	  }
	  else cd = (CompactDisc) media;							//Nếu có thì downcasting media
	  
	  System.out.println("Do you want to add list of tracks (1-yes, 0-no): 1/0"); //Hỏi ng dùng có muốn thêm track?
	  ans = keyboard.nextInt();
	  if(ans==1) {
		System.out.println("Enter title and length (enter # to stop)."); 		  //Nhập track đến khi ng dùng nhâp #
		while(true) {
		  keyboard.nextLine(); title = keyboard.nextLine();
		  if(title.equals("#")) break;							//Nguyễn Ngọc ANh Thư - 20215143
		  int length = keyboard.nextInt();
		  cd.addTrack(new Track(title, length));				//Thêm track vào CD
		}
	  }
	  break;
	case 3:
	  if(media == null) { 
	  keyboard.nextLine(); director = keyboard.nextLine();
	  int length = keyboard.nextInt();
	  DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, director, length);
	  store.addMedia(dvd);
	  }
	  break;
	case 0:
	  break;
	} 
  }
//Nguyễn Ngọc Anh Thư - 20215143
  private static void playMedia(Media media) {
	if(media == null) System.out.println("Please check the media's title"); //Nếu media rỗng 
	else {																  //=> trong store không có media có tiêu đề người dùng tìm
	  if(media instanceof CompactDisc) {					      //Nếu Media là CD
		CompactDisc cd = (CompactDisc) media;					  //Downcasting
		cd.play();												  //Play CD
	  }
	  else if(media instanceof DigitalVideoDisc) {				  //Nếu Media là DVD
		DigitalVideoDisc dvd = (DigitalVideoDisc) media;		  //Downcasting
		dvd.play();												  //Play DVD
	  } else System.out.println("Only CD and DVD can be played"); //Nếu media là Book thì báo lỗi
	}
  }
  
  public static void showMenu() {
	System.out.println("AIMS: ");
	System.out.println("--------------------------------");
	System.out.println("1. View store");
	System.out.println("2. Update store");
	System.out.println("3. See current cart");
	System.out.println("0. Exit");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2-3");
  }

  public static void showAddMediaMenu() {
	System.out.println("Choose type of media: ");
	System.out.println("--------------------------------");
	System.out.println("1. Book");
	System.out.println("2. CD");
	System.out.println("3. DVD");
	System.out.println("0. Cancel");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2-3");
  }
  */
}  