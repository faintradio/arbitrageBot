package Arbs;
	import java.awt.AWTException;
	import java.awt.datatransfer.UnsupportedFlavorException;import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
	import java.util.List;
	import java.util.ListIterator;
	import java.util.stream.Collectors;
	import java.util.stream.Stream;
	
	public class Superbet extends BookOperationsL2{

		public static void printInfo(String webAdress, String key) throws InterruptedException, AWTException, UnsupportedFlavorException, IOException {	 
			 
		//String [] lines = .split("\\r?\\n");
		List<String> listorig=ContainsPairings(key, webAdress);
		listorig.replaceAll(String::toUpperCase);
		/* ListIterator<String> liweb = listorig.listIterator();
		  while(liweb.hasNext()) {
		     
		  }*/
		  
		  String[] teams= {"Denver Nuggets","Charlotte Hornets","Detroit Pistons","Boston Celtics","Boston Celtics","Minnesota Timberwolves","Miami Heat",
					"Toronto Raptors","Los Angeles Clippers","Chicago Bulls","Brooklyn Nets","Indiana Pacers","Philadelphia 76ers","Memphis Grizzlies","Dallas Mavericks"
		    		,"Milwaukee Bucks","Orlando Magic","Golden State Warriors","Phoenix Suns","Los Angeles Lakers","New York Knicks","Sacramento Kings",
		    		"Oklahoma City Thunder","Portland Trail Blazers","Atlanta Hawks","Brooklyn Nets","Utah Jazz","New Orleans Pelicans","Portland Trail Blazers","Houston Rockets","Sacramento Kings","Washington Wizards"};
		  List<String> listTeams=Arrays.asList(teams);
		  listTeams.replaceAll(String::toUpperCase);
		  int i=0;
			List<Book>book = new ArrayList<>();
		  for(i=0;i<listorig.size()-5;i++) {
			  boolean b=listorig.get(i).contains("FT")&&Integer.parseInt(listorig.get(i).substring(0,1))>=0 &&!listorig.get(i).contains("~");
			  if(b==true) {
				  
						 book.add(new Book(listorig.get(i).substring(5,listorig.get(i).indexOf("  ")),
								 Float.parseFloat(listorig.get(i+(1))),
						  listorig.get(i).substring(listorig.get(i).lastIndexOf("  ")+2,listorig.get(i).lastIndexOf("+")-1),
						  Float.parseFloat(listorig.get(i+(5))),
						  "https://www.supabets.co.za/Sport/OddsAsync.aspx?EventID=155348"));	  
			  }
		  }
		  printValues(book);
		  
		}
		public static void printValues(List<Book> list) {
			 for (int k = 0; k < list.size(); k++) {
				 Book data = list.get(k);
				 System.out.println(data.white+": "+data.whiteOdds +" "+data.black+": "+data.blackOdds+": "+data.Bookmaker);
			 }
		}
	}
		  
