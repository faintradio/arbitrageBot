package Arbs;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.stream.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;  
import javax.mail.*;  


public class ArbCalculator {
	public static void CompaireLists() throws InterruptedException, AWTException, UnsupportedFlavorException, IOException, Exception{
		 int i=0;
		
		List<Book>list1= Defabets.printInfo("https://www.dafabet.com/en/dfgoal/sports/227-basketball/22892-usa/218297-nba-playoffs","Handball");

		List<Book>list2 = Bet_Co_ZA.printInfo("Handicap", "https://www.bet.co.za/sports/basketball/nba/");
			
	//List<Book>list3=_1xbet.printInfo("NBA","https://1xbet.com/en/line/Basketball/13589-NBA//");
			
		List<Book>list4=Superbet.printInfo("https://www.supabets.co.za/Sport/OddsAsync.aspx?EventID=155348","MAIN MARKETS");
			
			
	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	List<List<Book>>masterListS=Arrays.asList(list1,list2,/*list3,*/list4);
	//List<List<Book>>masterListS=Arrays.asList(list3);
	List<Book> masterlist = 
			masterListS.stream()
			        .flatMap(List::stream)
			        .collect(Collectors.toList());
	
	
	
	String li =masterlist.toString() //converts list into string
		    .replace("[", "")  //remove the left bracket
		    .replace("]", "")  //remove the right bracket
		    .trim(); 
	
	//only list with teams and odds accepted
	String values[]= li.toUpperCase().split(",");
	List<String>listb=Arrays.asList(values);
	List<String>list= new ArrayList<>();
	for(String s:listb) {
		list.add(s.trim());
	}
	 List<String>filteredList= new ArrayList<>();
	 for(i=0;i<list.size();i++) {
		 if(list.get(i).contains(" ")) {
			 filteredList.add(list.get(i));
			 filteredList.add(list.get(i+1));	 
		 }
	 }
	 System.out.println(Arrays.toString(filteredList.toArray()));
	 System.out.println();
	
//	List<String>list= Arrays.asList(values).stream().map(String::trim).collect(Collectors.toList());
	
	List<Booklet>highestOdd= new ArrayList<>();  
	List <Booklet> listbook= new ArrayList<>();
	 for(i=0;i<filteredList.size();i++) {
		 if(filteredList.get(i).contains(" ")) {
			 listbook.add(new Booklet(list.get(i),Double.parseDouble(list.get(i+1))));
				 
		 }
	 }
	
	 Map<String, Double>highestOdd1= new LinkedHashMap<>();  
	 for(i=0;i<listbook.size()-1;i++) {
	
		if((listbook.get(i).getTeam()).contains(" ") && highestOdd1.containsKey(listbook.get(i).getTeam())){
			
			if(listbook.get(i).getOdds()>highestOdd1.get(listbook.get(i).getTeam())){
				 highestOdd1.replace(listbook.get(i).getTeam(),listbook.get(i).getOdds());
			}
			else {
				 continue;
			}
				 }
		else{
			highestOdd1.put(listbook.get(i).getTeam(), listbook.get(i).getOdds());
	 }
} 
	
	//Converts a map into an arrayList of type String
	 List<String> target = new ArrayList<> (); // desired list to be filled
	 List<String> targetTeam = new ArrayList<> (highestOdd1.keySet());//key values of map
	 List<Double> targetOdds = new ArrayList<> (highestOdd1.values());// value part of map
	 List<String> targetOdds2 = new ArrayList<>();// String version of targetOdds
	 for (Double x: targetOdds) {
		   targetOdds2.add(String.valueOf(x));
		}
	 for(i=0;i<targetTeam.size();i++) {
		target.add(targetTeam.get(i));
		target.add(targetOdds2.get(i));	
		 
	 }
	 
	 System.out.println("booklet");
	 System.out.println(target.toString());
	 System.out.println("=============================================");
	 // invokes a method that is able to print out book values with bookmakers included(just for visualization, not necessary)
	 System.out.println(masterlist);
	 List<String>y=printValues(masterlist);
	
	 //submits list values into an arb fomula and print values in the form of advice
	List<String>listX= new ArrayList<>();
	NumberFormat nf= NumberFormat.getInstance();
     nf.setMaximumFractionDigits(2);
		for(i=0;i<target.size()-7;i=i+4) {
			double whiteOddsperc =(100/Double.parseDouble(target.get(i+3)));
			double blackOddsperc=(100/Double.parseDouble(target.get(i+1)));
			boolean minReturns=(100-(blackOddsperc+whiteOddsperc))>1;
			double Returns=100-((blackOddsperc)+(whiteOddsperc));
			
			String s1=target.get(i).concat(target.get((i)+1));
			String s2=target.get((i)+2).concat(target.get((i)+3));
			
		if(minReturns==true){
		listX.add("Investing "+nf.format(whiteOddsperc)+"% in "+ target.get(i)+" "+target.get(i+1)+ " at "+y.get((y.indexOf(s1))+1)+
				" AND "+nf.format(blackOddsperc)+"% in "+ target.get(i+2)+" "+target.get(i+3)+" at "+y.get((y.indexOf(s2))+1)+" yields "+nf.format(Returns)+"% in profit");
		}
		else {
			continue;
		}
	}
         StringBuilder strbul=new StringBuilder();
         for(String str : listX)
         {
             strbul.append(str);
             strbul.append("\n");
         } 
         String adviceMessage= strbul.toString();
         System.out.println(adviceMessage);
         sendingEmail(adviceMessage);
}
	public static void sendingEmail(String adviceMessage) {
		 
		  final String user="201305783@student.uj.ac.za"; 
		  final String password="Ml595859585958!";  
		  String to = "mothupilekgau@gmail.com"; 
	    String from = "201305783@student.uj.ac.za"; 
	    
		   Properties props = new Properties();    
		   props.put("mail.smtp.auth", "true");  
		   props.put("mail.smtp.starttls.enable","true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		    
		      javax.mail.Session session = javax.mail.Session.getInstance(props,  
		    		    new javax.mail.Authenticator() {  
			      protected PasswordAuthentication getPasswordAuthentication() {  
			    return new PasswordAuthentication(user,password);  
			      }  
			    });  
		      MimeMessage message = new MimeMessage(session); 
		      try{  
		          
		         message.setFrom(new InternetAddress(from));  
		         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		         message.setSubject("Arbs from bot");  
		      
		         message.setText(adviceMessage);
		         javax.mail.Transport.send(message);
		     		 
		     		 System.out.println("mail sent successfully");
		      }catch (MessagingException mex) {
		    	  mex.printStackTrace();
		      
		      }  
		   } 
	
	public static List<String> printValues(List<Book> list) {
		List<String> listB=null;
		String var=null;
		 for (int k = 0; k < list.size()-1; k++) {
			 Book data = list.get(k);
			  var+=data.white+data.whiteOdds +","+data.bookmaker+","+data.black+data.blackOdds+","+data.bookmaker+",";
		 }
			 String[] var2= var.split(",");
			 listB= Arrays.asList(var2);
			 listB.replaceAll(String::toUpperCase);
			 System.out.println(listB.toString());
			 System.out.println();
			
		return listB ;
		
		
		 }
}



