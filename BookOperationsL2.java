package Arbs;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class BookOperationsL2 extends BookOperationsL1{
	public static List<String> ContainsPairings(String key, String webAdress) throws InterruptedException, AWTException, UnsupportedFlavorException, IOException {
		String[] lines=null;
		CopyClassData(webAdress); 
		if( webData.contains(key)) {
		lines = webData.split("\\r?\\n");
		}
	 
	   else {
	    	CopyClassData(webAdress);  
	}
		List<String> list=Arrays.asList(lines);
		 ListIterator<String> li = list.listIterator();
		  while(li.hasNext()) {
		      String i = (String) li.next();
		      if(i.equalsIgnoreCase("CHA Hornets")) {
		        li.set("Charlotte Hornets");
		      }
		      if(i.equalsIgnoreCase("DEN Nuggets")) {
			        li.set("Denver Nuggets");
		      }
		      if(i.equalsIgnoreCase("DET Pistons")) {
			        li.set("Detroit Pistons");
		      }
		      if(i.equalsIgnoreCase("BOS Celtics")) {
			        li.set("Boston Celtics");
		      }
		      if(i.equalsIgnoreCase("MIN Timberwolves")) {
			        li.set("Minnesota Timberwolves");
		      }
		      if(i.equalsIgnoreCase("MIA Heat")) {
			        li.set("Miami Heat");
		      }
		      if(i.equalsIgnoreCase("TOR Raptors")) {
			        li.set("Toronto Raptors");
		      }
		      if(i.equalsIgnoreCase("LA Clippers")) {
			        li.set("Los Angeles Clippers");
		      }
		      if(i.equalsIgnoreCase("CHI Bulls")) {
			        li.set("Chicago Bulls");
		      }
		      if(i.equalsIgnoreCase("BKN Nets")) {
			        li.set("Brooklyn Nets");
		      }
		      if(i.equalsIgnoreCase("IND Pacers")) {
			        li.set("Indiana Pacers");
		      }
		      if(i.equalsIgnoreCase("PHI 76ers")) {
			        li.set("Philadelphia 76ers");
		      }
		      if(i.equalsIgnoreCase("MEM Grizzlies")) {
			        li.set("Memphis Grizzlies");
		      }
		      if(i.equalsIgnoreCase("DAL Mavericks")) {
			        li.set("Dallas Mavericks");
		      }
		      if(i.equalsIgnoreCase("MIL Bucks")) {
			        li.set("Milwaukee Bucks");
		      } 
		      if(i.equalsIgnoreCase("ORL Magic")) {
			        li.set("Orlando Magic");
		      } 
		      if(i.equalsIgnoreCase("GS Warriors")) {
			        li.set("Golden State Warriors");
		      } 
		      if(i.equalsIgnoreCase("PHO Suns")) {
			        li.set("Phoenix Suns");
		      } 
		      if(i.equalsIgnoreCase("LA Lakers")) {
			        li.set("Los Angeles Lakers");
		      }
		      if(i.equalsIgnoreCase("NY Knicks")) {
			        li.set("New York Knicks");
		      }
		      if(i.equalsIgnoreCase("SAC Kings")) {
			        li.set("Sacramento Kings");
		      }
		      if(i.equalsIgnoreCase("OKC Thunder")) {
			        li.set("Oklahoma City Thunder");
		      }
		      if(i.equalsIgnoreCase("UTA Jazz")) {
			        li.set("Utah Jazz");
		      }
		      if(i.equalsIgnoreCase("NO Pelicans")) {
			        li.set("New Orleans Pelicans");
		      }
		      if(i.equalsIgnoreCase("POT Blazers")) {
			        li.set("Portland Trail Blazers");
		      }
		      if(i.equalsIgnoreCase("HO Rockets")) {
			        li.set("Houston Rockets");
		      }
		      if(i.equalsIgnoreCase("SAC Kings")) {
			        li.set("Sacramento Kings");
		      }
		      if(i.equalsIgnoreCase("WASH Wizards")) {
			        li.set("Washington Wizards");
		      }
		      
		  }
		return list;	
}
}


