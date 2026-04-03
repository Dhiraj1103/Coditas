package TasksWeek2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task2 {
    public static void RadioButtonsCheckboxes() throws InterruptedException {
  	 System.out.println();
      System.out.println("=== Task 1:  Dropdown — Select Class (Show & Sort By)   ===");
   
    	WebDriver driver = EcommercePlayground.driver;
    	final String actualURL= EcommercePlayground.BASE;
    	driver.get(actualURL);
    	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    
    	//1
    	WebElement myAccount = driver.findElement(By.xpath("(//span[contains(text(),' My account')])[2]"));
        Actions act= new Actions(driver);
        act.moveToElement(myAccount).perform();
        act.keyDown(Keys.F8).perform();
        driver.findElement(By.xpath("(//span[contains(text(),' Register')])")).click();

        
        //2
        List<WebElement> radioButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".custom-control.custom-radio.custom-control-inline")));
        WebElement scrollRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'© LambdaTest - Powered by OpenCart')]")));
        act.scrollToElement(scrollRegister).perform();
        int countRadioButton=radioButtons.size();
		System.out.printf("%-15s : %s%n", "Count of radio Buttons: ",countRadioButton);
		
		
		//3
//		the <label> is sitting on top of the <input>
//		👉 So Selenium tries to click input ❌ but label intercepts it
        WebElement yesLabel = driver.findElement(By.xpath("//label[@for='input-newsletter-yes']"));
		WebElement yesRadioButton = driver.findElement(By.id("input-newsletter-yes"));
		
		//4
		yesLabel.click();
		
		if(yesRadioButton.isSelected()) {
    		System.out.printf("%-15s : %s%n", "Result", "Test case passed Yes button is selected");
      	}
      	else {
    		System.err.println("Test case failed Yes button is not selected");
      	}
	
		//5

        WebElement noLabel = driver.findElement(By.xpath("//label[@for='input-newsletter-no']"));
//        	isSelected() works only on selectable elements, mainly:
// 			<input type="radio">
//        	<input type="checkbox">
//        	<option> inside dropdown
		WebElement noRadioButton = driver.findElement(By.id("input-newsletter-no"));  
		
		//6
		noLabel.click();
	
		if(noRadioButton.isSelected()) {
    		System.out.printf("%-15s : %s%n", "Result", "Test case passed No button is selected");
      	}
      	else {
    		System.err.println("Test case failed No button is not selected");
    	
      	}
		
		//7
		
		if(!yesRadioButton.isSelected()) {
    		System.out.printf("%-15s : %s%n", "Result", "Test case passed Yes button is Deselected");
      	}
      	else {
    		System.err.println("Test case failed Yes button is not Deselected");
      	}

		//8
		
		WebElement checkBox = driver.findElement(By.id("input-agree"));
		
		if(!checkBox.isSelected()) {
    		System.out.printf("%-15s : %s%n", "Result", "Test case passed ChcekBox is not selected");
      	}
      	else {
    		System.err.println("Test case failed ChcekBox is selected");
      	}
		
		//9
		WebElement clickCheckBox = driver.findElement(By.xpath("//label[@for='input-agree']"));
		clickCheckBox.click();
		if(checkBox.isSelected()) {
    		System.out.printf("%-15s : %s%n", "Result", "Test case passed ChcekBox is selected");
      	}
      	else {
    		System.err.println("Test case failed ChcekBox is not selected");
      	}
		
		//10
		clickCheckBox.click();
		if(!checkBox.isSelected()) {
    		System.out.printf("%-15s : %s%n", "Result", "Test case passed ChcekBox is Deselected");
      	}
      	else {
    		System.err.println("Test case failed ChcekBox is not Deselected");
      	}
		
    	System.out.println("=== Task 2 Complete — Radio buttons and checkboxes verified ===");

        
    }

}
//





















