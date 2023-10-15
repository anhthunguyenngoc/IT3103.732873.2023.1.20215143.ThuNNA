// Exercises 6.4: TheNumberDaysOfMonth.java
import java.util.Scanner;
public class Ex6_4_TheNumberDaysOfMonth {
  //Hàm chuyển tháng dạng kí tự về dạng số
  private static String convertMonth(String month) {
	if(month.equals("January") || month.equals("Jan") || month.equals("Jan.")) 		return "1";
	if(month.equals("February") || month.equals("Feb") || month.equals("Feb.")) 	return "2";
	if(month.equals("March") || month.equals("Mar") || month.equals("Mar."))		return "3";
	if(month.equals("April") || month.equals("Apr") || month.equals("Apr.")) 		return "4";
	if(month.equals("May"))															return "5";
	if(month.equals("June") || month.equals("Jun"))									return "6";
	if(month.equals("July") || month.equals("Jul"))									return "7";
	if(month.equals("August") || month.equals("Aug") || month.equals("Aug.")) 		return "8";
	if(month.equals("September") || month.equals("Sep") || month.equals("Sept.")) 	return "9";
	if(month.equals("October") || month.equals("Oct") || month.equals("Oct.")) 		return "10";
	if(month.equals("November") || month.equals("Nov") || month.equals("Nov.")) 	return "11";
	if(month.equals("December") || month.equals("Dec") || month.equals("Dec.")) 	return "12";
	return "0"; //trả về 0 nếu người dùng nhập sai định dạng
  }
  //Hàm kiểm tra có phải năm nhuận hay k?
  private static boolean isLeapYear(int year) {
	if(year%4 == 0 && year%100 !=0 || year%400 ==0) return true;
	else return false;
  }
  //Hàm trả về số ngày trong tháng
  private static int day(int month, int year) {
	if(month == 2 && isLeapYear(year)) return 29;
	else {
	  if(month == 2 && !isLeapYear(year)) return 28;
	  else {
		if(month%2 == 1 && month <8 || month%2 == 0 && month >8) return 31;
		else return 30;
	  }
	}
  }
  
  public static void main(String args[]) {
	String month, year, answer;
	Scanner keyboard = new Scanner(System.in);
	do
	{
	  while(true)
	  {
		System.out.print("Month: ");
		month = keyboard.nextLine();	
		System.out.print("Year: ");
		year = keyboard.nextLine();
		//Kiểm tra tháng nhập vào có phải số hay k?
		try {
		  Integer.parseInt(month);
		}
		catch(Exception e) {
		  month = convertMonth(month); //nếu không phải số thì gọi hàm convertMonth
		}
		//Hiện thông báo nếu người dùng nhập tháng không hợp lệ
		if(Integer.parseInt(month)<=0 || Integer.parseInt(month)>12 ) 
		  System.out.print("Vui lòng kiểm tra lại dữ liệu vừa nhập, đảm bảo không có khoảng trắng.\n\n");
		else break;
	  }
	  System.out.print("Số ngày trong tháng "+ month + "/" + year +": ");
	  System.out.print(day(Integer.parseInt(month),Integer.parseInt(year)));
	  System.out.println(" days.\n");
	  System.out.print("Bạn có muốn nhập tiếp không (y/n): ");
	  answer = keyboard.nextLine();
	}while(answer.equals("y") || answer.equals("Y"));	
  }
}
