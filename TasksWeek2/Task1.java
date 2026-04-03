package TasksWeek2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Task1 {

      public static void Dropdown() {
    	 System.out.println();
        System.out.println("=== Task 1:  Dropdown — Select Class (Show & Sort By)   ===");
     
      	WebDriver driver = EcommercePlayground.driver;
      	final String actualURL= EcommercePlayground.BASE;
      	driver.get(actualURL);
      	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      	//1
      	driver.findElement(By.xpath("//a[contains(@class,'icon-left both text-reset')]")).click();
      	driver.findElement(By.xpath("//span[contains(text(),' Cameras')]")).click();
      	
      	//2
      	final String title="Cameras";
      	String currentTitle=driver.getTitle();
      	if(title.equals(currentTitle)) {
    		System.out.printf("%-15s : %s%n", "Result", "Test case passed Title matched succesfully");
      	}
      	else {
    		System.err.println("Test case failed title mismatched");
      	}
      	System.out.println();
      	
      	//3
      	WebElement show = driver.findElement(By.className("custom-select"));
      	Select sel= new Select(show);
      	
      	
      	//4
      	List<WebElement> values = sel.getOptions();
      	int idx=1;
      	System.out.println("Values inside the show dropdown: ");
      	for (WebElement i : values) {
			System.out.println(idx+": "+i.getText());
			idx++;
		}
      	idx=0;
      	System.out.println();
      	
      	//5
      	final int totalCount=5;
      	int currentSize=values.size();
      	if(totalCount == currentSize) {
    		System.out.printf("%-15s : %s%n", "Result", "Test case passed Count 5 matched succesfully");
      	}
      	else {
    		System.err.println("Test case failed Count 5 mismatched");
      	}
      	
      	
      	//6
      	Actions act= new Actions(driver);
      	act.scrollToElement(driver.findElement(By.className("text-ellipsis-2"))).perform();
      	
      final	String selectValue="25";
 	     sel.selectByVisibleText("25");	
 	     
 	    WebElement show2 = driver.findElement(By.className("custom-select"));

      	Select sel2= new Select(show2);  // did this again due to the stale element exception
      	String currentSelected=sel2.getFirstSelectedOption().getText();
      	if(selectValue.equals(currentSelected)) {
    		System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value 25 matched succesfully");
      	}
      	else {
    		System.err.println("Test case failed Selected Value 25 mismatched");
      	}
      	
      	
      	//7
      final String selectValue2="50";
    	act.scrollToElement(driver.findElement(By.className("text-ellipsis-2"))).perform();
      sel2.selectByVisibleText("50");
      WebElement show3 = driver.findElement(By.className("custom-select"));
      Select sel3= new Select(show3);  // did this again due to the stale element exception
    	String currentSelected2=sel3.getFirstSelectedOption().getText();
    	if(selectValue2.equals(currentSelected2)) {
  		System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value 50 matched succesfully");
    	}
    	else {
  		System.err.println("Test case failed Selected Value 50 mismatched");
    	}	
    	
    	//8
    	final String selectValue3="15";
    	act.scrollToElement(driver.findElement(By.className("text-ellipsis-2"))).perform();
      sel3.selectByIndex(0);
      WebElement show4 = driver.findElement(By.className("custom-select"));
      Select sel4= new Select(show4);  // did this again due to the stale element exception
    	String currentSelected3=sel4.getFirstSelectedOption().getText();
    	if(selectValue3.equals(currentSelected3)) {
  		System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value 15 matched succesfully");
    	}
    	else {
  		System.err.println("Test case failed Selected Value 15 mismatched");
    	}	
    	
    //9
    	WebElement sort = driver.findElement(By.id("input-sort-212403"));
    	
    	Select selSort= new Select(sort);
    	System.out.println();
    	
    	//10
    	List<WebElement> sortList = selSort.getOptions();
    	System.out.println("Values in Sort list: ");
    	for (WebElement i : sortList) {
			System.out.println(idx+": "+i.getText());
			idx++;
		}
    	idx=0;
    	System.out.println();
    	act.scrollToElement(driver.findElement(By.className("text-ellipsis-2"))).perform();

    	//11
    	final String sortVal1="Name (A - Z)";
    	selSort.selectByVisibleText(sortVal1);
    	WebElement sort2 = driver.findElement(By.id("input-sort-212403"));
        Select selSort2= new Select(sort2);
        String sortCurrentVal1=selSort2.getFirstSelectedOption().getText();
    	if(sortVal1.equals(sortCurrentVal1)) {
  		System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value Name (A - Z) matched succesfully");
    	}
    	else {
  		System.err.println("Test case failed Selected Value Name (A - Z) mismatched");
    	}	
    	
    	//12
    	act.scrollToElement(driver.findElement(By.className("text-ellipsis-2"))).perform();
    	final String sortVal2="Price (Low > High)";
    	selSort2.selectByVisibleText(sortVal2);
    	WebElement sort3 = driver.findElement(By.id("input-sort-212403"));
        Select selSort3= new Select(sort3);
        String sortCurrentVal2=selSort3.getFirstSelectedOption().getText();
    	if(sortVal2.equals(sortCurrentVal2)) {
  		System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value Price (Low > High) matched succesfully");
    	}
    	else {
  		System.err.println("Test case failed Selected Value Price (Low > High) mismatched");
    	}	
    	System.out.println();
    	System.out.println(" '=== Task 1 Complete — Select class verified on Show and Sort By dropdowns ===");
    	
      }

}

//

































