// Exercises 6.6: Matrix.java
package hust.soict.dsai.lab01;

import java.util.Scanner;
public class Ex6_6_Matrix {
  //Hàm nhập mảng
  private static int[][] inputMatrix(int a, int b) {
	Scanner keyboard = new Scanner(System.in);
	int iC[][];
	iC = new int[a][b];
	for(int i=0; i<a; i++)
	{
	  for(int j=0; j<b; j++)
	  {
		iC[i][j] = keyboard.nextInt(); 
	  }
	} 
	return iC;
  }
  //Hàm cộng 2 mảng
  private static int[][] addMatrix(int iA[][], int iB[][], int a, int b) {
	int iC[][];
	iC = new int[a][b];
	for(int i=0; i<a; i++)
	{
	  for(int j=0; j<b; j++)
	  {
		iC[i][j] = iA[i][j] + iB[i][j]; 
	  }
	} 
	return iC;
  }
  //Hàm in ra mảng
  private static void print(int iC[][], int a, int b) {
	for(int i=0; i<a; i++)
	{
	  for(int j=0; j<b; j++)
	  {
		System.out.print(iC[i][j] +" "); 
	  }
	System.out.print("\n");
	} 
  }
  
  public static void main(String args[]) {
	//Khai báo
	int iA[][], iB[][], a, b;
	Scanner keyboard = new Scanner(System.in);
	//Input
	System.out.print("The size of two matrix (a b): ");
	a = keyboard.nextInt();
	b = keyboard.nextInt();
	iA = new int[a][b];
	iB = new int[a][b];	
	System.out.print("Matrix A: \n");
	iA = inputMatrix(a, b);
	System.out.print("Matrix B: \n");
	iB = inputMatrix(a, b);
	//Output
	System.out.println("Matrix A + Matrix B = ");
	print(addMatrix(iA, iB, a, b), a, b); //gọi hàm in ra tổng của 2 mảng
  }
}
