package Arbs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class BookOperationsL1 {
	
	//bet.co.za starts here
	static String webData;
	static  String[] teams= {"Denver Nuggets","Charlotte Hornets","Detroit Pistons","Boston Celtics","Boston Celtics","Minnesota Timberwolves","Miami Heat",
			"Toronto Raptors","Los Angeles Clippers","Chicago Bulls","Brooklyn Nets","Indiana Pacers","Philadelphia 76ers","Memphis Grizzlies","Dallas Mavericks"
    		,"Milwaukee Bucks","Orlando Magic","Golden State Warriors","Phoenix Suns","Los Angeles Lakers","New York Knicks","Sacramento Kings",
    		"Oklahoma City Thunder","Utah Jazz","New Orleans Pelicans","Portland Trail Blazers","Houston Rockets","Sacramento Kings","Washington Wizards"};
	
		public static void CopyClassData(String webadress) throws InterruptedException, AWTException, UnsupportedFlavorException, IOException{	
			
			ExecutorService executor = Executors.newFixedThreadPool(4);

			Future<?> future = executor.submit(new Runnable() {
		        @Override
		        public void run() {
		        	System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
					WebDriver driver = new ChromeDriver(options);
					driver.manage().window().maximize();
					driver.get(webadress);
					Clipboard c=Toolkit.getDefaultToolkit().getSystemClipboard();
					try {
						Thread.sleep(7000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Actions action=new Actions(driver);
					driver.findElement(By.cssSelector("body")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
					action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
					try {
						webData = (String) c.getData(DataFlavor.stringFlavor);
					} catch (UnsupportedFlavorException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					driver.close();
					driver.quit();  
		        }
			});
					executor.shutdown();            //        <-- reject all further submissions

		    try {
		        future.get(100, TimeUnit.SECONDS);  //     <-- wait 8 seconds to finish
		    } catch (InterruptedException e) {    //     <-- possible error cases
		        System.out.println("job was interrupted");
		    } catch (ExecutionException e) {
		        System.out.println("caught exception: " + e.getCause());
		    } catch (TimeoutException e) {
		        future.cancel(true);              //     <-- interrupt the job
		    System.out.println("timeout");
		    }

		    // wait all unfinished tasks for 2 sec
		    if(!executor.awaitTermination(2, TimeUnit.SECONDS)){
		        // force them to quit by interrupting
		        executor.shutdownNow();
		    }
			
		}		
}
	


