package TasksWeek2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class Task1WithoutSelect {

	 public static void DropdownWithoutSelect() throws InterruptedException {
    	 System.out.println();
        System.out.println("=== Task 1:  Dropdown —Without Select Class (Show & Sort By)   ===");
     
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
      	
      	int idx=1;
      	System.out.println("Values inside the show dropdown: ");
      	List<WebElement> values = driver.findElements(By.cssSelector("#input-limit-212402 option"));
      	for (WebElement i : values) {
			System.out.println(i.getText());
			idx++;
		}
      	idx=0;
      	System.out.println();
      	final int totalCount=5;
      	int currentSize=values.size();
      	if(totalCount == currentSize) {
    		System.out.printf("%-15s : %s%n", "Result", "Test case passed Count 5 matched succesfully");
      	}
      	else {
    		System.err.println("Test case failed Count 5 mismatched");
      	}
      	
      	
      	
      	driver.findElement(By.xpath("//option[text()='25']")).click(); 
      	final String value25="25";
      	WebElement select25 = driver.findElement(By.xpath("//option[text()='25']"));
      	boolean currentSelect1=select25.isSelected();
      	if(currentSelect1) {
    		System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value 25 matched succesfully");
      	}
      	else {
    		System.err.println("Test case failed Selected Value 25 mismatched");
      	}
      	

      	

      	driver.findElement(By.xpath("//option[text()='50']")).click();
     	final String value50="50";
      	WebElement select50 = driver.findElement(By.xpath("//select[@id='input-limit-212402']/option[text()='50']"));
      	Thread.sleep(20000);
      	String str = select50.getDomAttribute("selected");
      	System.out.println(str);
      	
//      	driver.findElement(by.)
//      	boolean currentSelect2=select50.isSelected();
//      	if(currentSelect2) {
//    		System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value 50  matched succesfully");
//      	}
//      	else {
//    		System.err.println("Test case failed Selected Value 50 mismatched");
//      	}
      	
      	
      	
      	driver.findElement(By.xpath("//option[text()='15']")).click();
     	final String value15="15";
      	WebElement select15 = driver.findElement(By.xpath("//option[text()='15']"));
      	boolean currentSelect3=select25.isSelected();

      	if(currentSelect3) {
    		System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value 15  matched succesfully");
      	}
      	else {
    		System.err.println("Test case failed Selected Value 15 mismatched");
      	}
      	
}
}