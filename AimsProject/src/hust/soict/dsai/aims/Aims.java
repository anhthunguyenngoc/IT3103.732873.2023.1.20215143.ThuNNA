//Nguyễn Ngọc Anh Thư - 20215143
package hust.soict.dsai.aims;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
  static Store store = new Store();
  static Cart cart = new Cart();
  static Scanner keyboard = new Scanner(System.in);
	
  public static void main(String[] args) {
	int num=0;
	do {
	  showMenu(); //show Menu
	  num = keyboard.nextInt();
	  switch(num) {	  
	  case 1: // view Store
		aimsViewStore();
		break;
	  case 2: //Update store
		aimsUpdateStore();		  
		break;
	  case 3: //See current cart
		aimsSeeCart();
		break;
	  case 0: break; // Exit
	  }
	}while(num!=0);
  }
  
  private static void aimsViewStore() {
	int num=0;
	String title;
	Media media;
	store.viewStore();
	do{	
	  Store.storeMenu(); // store Menu
	  num = keyboard.nextInt();
	  switch(num) {
	  case 1: //  See a media’s details
		storeMediaDetails();
		break;
	  case 2: //Add a media to cart
		System.out.println("Enter title: ");
		title = keyboard.next();
		media = store.mediaInStore(title);
		if(media == null) System.out.println("Cannot found the media with that name in cart");
		else cart.addMedia(media);
		break;
	  case 3: // Play a media
		System.out.println("Enter title: ");  
		title = keyboard.next();
	    media = store.mediaInStore(title);
		playMedia(media);
	    break;
	  case 4: //See current cart
		cart.viewCart(); 
		break;
	  case 0: break;
	  }
	}while(num!=0);
  }
  
  private static void aimsUpdateStore() {	
	Store.updateStoreMenu();
	int	num = keyboard.nextInt();
	Media media;
	switch(num) {
	case 1:
	  addMediaOptions();
	  int op = keyboard.nextInt();
	  String str = "Please enter title, category, cost";
	  if(op==2) str += ", director, artist";
	  else if(op==3) str += ", director, length";
	  System.out.println(str);
	  String title = keyboard.next();
	  String category = keyboard.next();
	  float cost = keyboard.nextFloat(); 
	  switch(op) {
	  case 1:
		Book book = new Book(title, category, cost);
		store.addMedia(book);
		System.out.println("Do you want to add list of authors (1-yes, 0-no): 1/0");
		int ans = keyboard.nextInt();
		if(ans==1) {
		  String au;
		  System.out.println("Enter author's name (enter # to stop).");
		  while(true) {
			au = keyboard.next();
		    if(au.equals("#")) break;
		    book.addAuthor(au);
		  }
		}
		break;
	  case 2:
		String director = keyboard.next();
		String artist = keyboard.next();
		CompactDisc cd = new CompactDisc(title, category, cost, director, artist);
		store.addMedia(cd);
		System.out.println("Do you want to add list of tracks (1-yes, 0-no): 1/0");
		ans = keyboard.nextInt();
		if(ans==1) {
		  System.out.println("Enter title and length (enter # to stop).");
		  while(true) {
			title = keyboard.next();
			if(title.equals("#")) break;
			int length = keyboard.nextInt();
		    cd.addTrack(new Track(title, length));
		  }
		}
		break;
	  case 3:
		director = keyboard.next();
		int length = keyboard.nextInt();
		DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, director, length);
		store.addMedia(dvd);
		break;
	  case 0:
		break;
	  } 
	  break;
	case 2:
	  title = keyboard.next();
	  media = store.mediaInStore(title);
	  store.removeMedia(media);
	case 0: break;
	}	
  }
  
  private static void storeMediaDetails() {
	int num=0;
	String title;
	System.out.println("Enter title: ");
	title = keyboard.next();
	Media media = store.mediaInStore(title);
	if(media == null) System.out.println("The media is not found");
	else {
	  System.out.println(media.toString());	
	  do{
	    Store.mediaDetailsMenu();
	    num = keyboard.nextInt();
	    if(num==1) {
		  cart.addMedia(media);
		  break;
	    }
	    if(num==2) {
		  playMedia(media);
	    }
	  }while(num!=0);
    }
  }
  
  private static void playMedia(Media media) {
	if(media == null) System.out.print("Please check the media's title");
	else {
	  if(media instanceof CompactDisc) {
		CompactDisc cd = (CompactDisc) media;
		cd.play();
	  }
	  else if(media instanceof DigitalVideoDisc) {
		DigitalVideoDisc dvd = (DigitalVideoDisc) media;
		dvd.play();
	  } else System.out.println("Only CD and DVD can be played");
	}
  }
  
  private static void aimsSeeCart() {
	int num = 0;
	String title;
	Media media;
	cart.viewCart();
	do{
	  Cart.cartMenu();
	  num = keyboard.nextInt();
	  switch(num) {	  
	  case 1:
		Cart.filterCartMenu();;
		int op = keyboard.nextInt();
		if(op==1) {
		  System.out.println("Enter id: ");
		  int id = keyboard.nextInt();
		  cart.filterById(id);
		}
		else if(op==2){
		  title = keyboard.next();
		  cart.filterByTitle(title);
		}
		break;
	  case 2:
		Cart.sortCartMenu();;
		op = keyboard.nextInt();
		cart.sortCart(op);
		break;
	  case 3:
		System.out.println("Enter title: ");  
		title = keyboard.next();
		media = store.mediaInStore(title);
		if(media == null) System.out.print("Cannot found the media with that name in store");
		else cart.removeMedia(media);
	    break;
	  case 4:
		System.out.println("Enter title: "); 
		title = keyboard.next();
	    media = cart.mediaInCart(title);
		playMedia(media);
		break;
	  case 5:
		System.out.println("An order is created");
		cart.emptyCart();
		break;
	  case 0: break;
	  }
	}while(num!=0);
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

  public static void addMediaOptions() {
	System.out.println("Choose type of media: ");
	System.out.println("--------------------------------");
	System.out.println("1. Book");
	System.out.println("2. CD");
	System.out.println("3. DVD");
	System.out.println("0. Cancel");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2-3");
  }
  
  
}
