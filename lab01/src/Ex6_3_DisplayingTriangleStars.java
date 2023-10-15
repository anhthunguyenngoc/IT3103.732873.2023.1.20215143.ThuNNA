// Exercises 6.3: DisplayingTriangleStars.java
import java.util.Scanner;
public class Ex6_3_DisplayingTriangleStars { 
  private static void print(int n) {
	//mỗi dòng in ra n-i khoảng trắng ở 2 bên và 2i-1 dấu * ở giữa
	for(int i=1; i<=n; i++) { 
	  for(int j=0; j<(n-i); j++)  //in khoẳng trắng bên trái
	    System.out.print(" ");
	  for(int j=0; j<2*i-1; j++)  //in dấu *
		System.out.print("*");
	  for(int j=0; j<(n-i); j++)  //in khoẳng trắng bên phải
		System.out.print(" ");
	  System.out.print("\n");	  //xuống dòng
    }	  
  }

  public static void main (String args[]) {
    Scanner keyboard = new Scanner(System.in);
    int n;
    do {
      System.out.print("Nhập n: ");
      n = keyboard.nextInt();  //Nhập n
      if(n==0) System.out.print("Vui lòng nhập n>0. \n");
    }while(n==0);
    print(n);
  }
}