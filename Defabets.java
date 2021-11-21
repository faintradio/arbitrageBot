package Arbs;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Defabets extends BookOperationsL2 {
	
	public static List<Book> printInfo(String webAdress, String key) throws InterruptedException, AWTException, UnsupportedFlavorException, IOException {	 
	
		List<String> listorig=ContainsPairings(key, webAdress);
		listorig.replaceAll(String::toUpperCase);
	
			List<Book>list2 = new ArrayList<>();
			int i=0;
			for( i=0;i<listorig.size();i++) {
boolean test1=(listorig.get(i).contains(":"));
			boolean test2=(listorig.get(i).length())==5;
				if(test1==true&& test2==true) {
					list2.add(new Book(listorig.get(i+(1)),Double.parseDouble(listorig.get(i+(7))),listorig.get(i+(2)),Double.parseDouble(listorig.get(i+(8))),"dafabet.com"));
				}
			}
			 printValues(list2);
			return list2;
	}
	public static void printValues(List<Book> list) {
		 for (int k = 0; k < list.size(); k++) {
			 Book data = list.get(k);
			 System.out.println(data.white+": "+data.whiteOdds +" "+data.black+": "+data.blackOdds+": "+data.Bookmaker);
		 }
	}

}

