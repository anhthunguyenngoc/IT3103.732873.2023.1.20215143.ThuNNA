// Exercises 6.5: Array.java
package hust.soict.dsai.lab01;

import java.util.Scanner;
public class Ex6_5_Array {
  private static int iA[];
  private static int n;
  
  //Hàm merge 2 mảng và sắp xếp
  private static void merge(int iA[], int L, int M, int R) {
	int iB[];
	iB = new int[L+R+2];
	int i = L; int j = M+1; int k=L;
	for(int v=L;v<=R;v++)
	{
	  if(i>M) { iB[k++]=iA[j++]; }
	  else if(j>R) { iB[k++]=iA[i++]; }
	  else if(iA[i]<=iA[j]) {
	    iB[k++]=iA[i];
	    i++;
	  }else {
	    iB[k++]=iA[j];
	    j++;
	  }
	}
	for(int v=L;v<=R;v++) iA[v]=iB[v];
  }
  private static void mergeSort(int iA[], int l, int r )
  {
	if(l>=r) return;
	int m=(l+r)/2;
	mergeSort(iA,l,m);
	mergeSort(iA,m+1,r);
	merge(iA,l,m,r);
  }
  
  //Hàm tính tổng các phần tử của mảng
  private static long sum(int iA[], int n) {
	long sum = iA[0];
	  for(int i=1; i<=n; i++) sum+=iA[i];
	return sum;
  }
  
  public static void main (String args[]) {
	Scanner keyboard = new Scanner(System.in);
	System.out.print("Nhập n: ");
	n = keyboard.nextInt();
	iA = new int[n+1];
	System.out.print("Nhập mảng: ");
	for(int i=0; i<n; i++)
	  iA[i] = keyboard.nextInt();
	
	mergeSort(iA,0,n-1); // gọi hàm sắp xếp mergeSort
	System.out.print("The sorted array: "); // in ra mảng đã được sắp xếp
	for(int i=0; i<n; i++)
	  System.out.print(iA[i] + " ");
	System.out.print("\nSum: ");			// in ra tổng
	System.out.print(sum(iA, n));
	System.out.print("\nAverage: ");		// in ra trung bình cộng
	System.out.print((double)sum(iA, n)/n);
  }
}
