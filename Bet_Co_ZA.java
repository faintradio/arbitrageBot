package Arbs;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bet_Co_ZA extends BookOperationsL2 {
	public static String indexAti;
	
	public static List<Book> printInfo(String key, String webAdress) throws InterruptedException, AWTException, UnsupportedFlavorException, IOException{
		
		 List<String> list1=Arrays.asList(teams);
		 List<String> list2=ContainsPairings(key, webAdress);
		 List<String>list3 = new ArrayList<>();
		 List<Book>list4 = new ArrayList<>();
		
		
				int i = 0;
				for(i=0;i<list2.size()-13;i++) {
				if(presentInBoth(list1, list2, list3, list2.get(i))==true) {
				list4.add(new Book(list2.get(i),Float.parseFloat(list2.get(i+(11))),list2.get(i+(1)),Float.parseFloat(list2.get(i+(13))),"Bet_co_za"));
				list3.add(list2.get(i+1));
					}
				
		 }
				printValues(list4);
				return list4;
		
	}	 

public static boolean presentInBoth(List<String> list1,List<String> list2,List<String>list3,String present) {
	
	return list1.contains(present)&&list2.contains(present)&&!list3.contains(present);
	
	}
public static void printValues(List<Book> list) {
	 for (int k = 0; k < list.size(); k++) {
		 Book data = list.get(k);
		 System.out.println(data.white+": "+data.whiteOdds +" "+data.black+": "+data.blackOdds+": "+data.Bookmaker);
	 }
}

}
		

