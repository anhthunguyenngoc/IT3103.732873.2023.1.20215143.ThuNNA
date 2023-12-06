//Nguyễn Ngọc Anh Thư -20215143
package hust.soict.dsai.garbage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

  public static void main(String[] args) {
	String filename = "D:/20215143.ThuNNA/OOP/IT3103.732873.2023.1.20215143.ThuNNA/OtherProjects/src/hust/soict/dsai/garbage/test.txt";
	byte[] inputBytes = { 0 };
	long startTime, endTime;

	try {
		inputBytes = Files.readAllBytes(Paths.get(filename));
	} catch (IOException e) {
		e.printStackTrace();
	}
	startTime = System.currentTimeMillis();
	String outputString = "";
	for (byte b : inputBytes) {
	  outputString += (char)b;
	}
	endTime = System.currentTimeMillis();
	System.out.println(endTime - startTime);
  }
}
