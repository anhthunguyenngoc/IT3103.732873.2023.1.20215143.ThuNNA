import java.util.Scanner;

public class SolveEquation{

//Hàm void giải phương trình bậc nhất 1 ẩn ax+b=0 => x=-b/a
  private static void firstDegreeOneVar(){
  	Scanner keyboard = new Scanner(System.in);
    double a, b;

    do{
      System.out.print("Enter a: ");
      a = keyboard.nextDouble();
      System.out.print("Enter b: ");
      b = keyboard.nextDouble();
    }while(a == 0);

    System.out.print("The equation has a unique solution: x=" + -b/a);
  }

//Hàm void giải hệ phương trình bậc nhất 2 ẩn a11.x1 + a12.x2 = b1; a21.x1 + a22.x2 = b2;
//Tính D, D1, D2, có 3 trường hợp
  //TH1: D != 0, hệ pt có 1 nghiệm (x1,x2) = (D1/D, D2/D)
  //TH2: D = 0, hệ pt vô nghiệm
  //TH3: D = D1 = D2 = 0, hệ pt có vô số nghiệm	  
  private static void firstDegreeTwoVar(){
	//Khai báo
  	Scanner keyboard = new Scanner(System.in);
    double a11, a12, a21, a22, b1, b2;
    double D, D1, D2;
    
    //Input hệ số
    System.out.print("Enter a11 a12 b1: ");
    a11 = keyboard.nextDouble();
    a12 = keyboard.nextDouble();
    b1 = keyboard.nextDouble();
    System.out.print("Enter a21 a22 b2: ");
    a21 = keyboard.nextDouble();
    a22 = keyboard.nextDouble();
    b2 = keyboard.nextDouble();
      
    //Tính D, D1, D2
    D = a11*a22 - a21*a12;
    D1 = b1*a22 - b2*a12;
    D2 = a11*b2 - a21*b2;
    
    //Xét các trường hợp bằng if-else và in ra kết quả
    if(D!=0) {
      System.out.println("The system of equations has a unique solution: x1=" + D1/D + " x2=" + D2/D);
    }else if(D==0 && D1!=0 && D2!= 0) {
      System.out.println("The system of equations has no solution.");
    }else {
      System.out.println("The system of equations has infinitely many solutions.");
    }
  }

//Hàm void giải phương trình bậc hai 1 ẩn ax^2+bx+c=0
//Xét trường hợp a=0, phương trình trở thành giải hệ pt bậc nhất 1 ẩn có nghiệm x=-c/b
//Xét trường hợp a!=0
	//Tính delta=b^2-4*a*c, có 3 trường hợp
	  //TH1: delta < 0, pt vô nghiệm
	  //TH2: delta = 0, pt có 1 nghiệm kép x1 = x2 = -b/(2*a)
	  //TH3: delta > 0, pt có 2 nghiệm phân biệt x1 = (-b+sqrt(delta))/(2*a), x2 = (-b-sqrt(delta))/(2*a)
  private static void secondDegreeOneVar(){
	//Khai báo
  	Scanner keyboard = new Scanner(System.in);
    double a, b, c, delta;

    //Input hệ số
    System.out.print("Enter a b c: ");
    a = keyboard.nextDouble();
    b = keyboard.nextDouble();
    c = keyboard.nextDouble();
    
    //Xét trường hợp a=0, phương trình trở thành giải hệ pt bậc nhất 1 ẩn
    System.out.println("The equation has a unique solution: x=" + -c/b);
    
    //Xét trường hợp a!=0, tính delta
    delta = b*b - 4*a*c;
    
    //Xét các trường hợp bằng if-else và in ra kết quả
    if(delta < 0) {
        System.out.println("The equation has no solution.");
      }else if(delta == 0) {
        System.out.println("The system of equations has a unique solution: x=" + -c/a);
      }else {
        System.out.println("The system of equations has a unique solution: x1=" + (-b + Math.sqrt(delta))/(2*a) + " x2=" + (-b - Math.sqrt(delta))/(2*a));
      }
  }

  
  public static void main(String args[]){
  	Scanner keyboard = new Scanner(System.in);
    int choice;
    
    do {
      System.out.println("1. The first-degree equation (linear equation) with one variable");
      System.out.println("2. The system of first-degree equations (linear system) with two variables");
      System.out.println("3. The second-degree equation with one variable");
      System.out.print("Enter number: ");
      choice = keyboard.nextInt();

      switch (choice) {
        case 1:
          firstDegreeOneVar();
          break;
        case 2:
          firstDegreeTwoVar();
          break;
        case 3: 
          secondDegreeOneVar();
          break;
      }
      System.out.print("Do you want to continue (y/n)");
      //choice = keyboard.nextLine();
    }while(choice == 64);
    
  }
}