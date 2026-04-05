package TasksWeek2;

import org.openqa.selenium.Alert; // Used to handle browser alerts
import org.openqa.selenium.By; // Used for locating elements
import org.openqa.selenium.WebDriver;

public class Task3 {

	static WebDriver driver = EcommercePlayground.driver;

	public static void Alerts() {

		System.out.println("=== Task 3:  Alerts — Simple, Confirm, Prompt   ===");

		final String actualURL = "https://the-internet.herokuapp.com/javascript_alerts";
		driver.get(actualURL);

		final String title = "The Internet";
		String currentTitle = driver.getTitle();

		if (title.equals(currentTitle)) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Title matched succesfully");
		} else {
			System.err.println("Test case failed title mismatched");
		}

		final String success = "You successfully clicked an alert";

		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		// Locator: Button for Simple Alert using CSS attribute selector

		alertSwitch(); 
		// Switch driver context to alert

		String alert1Text = alertSwitch().getText(); 
		// Getting text from alert popup

		System.out.printf("%-15s : %s%n", "Alert 1 Text", alert1Text);

		alertSwitch().accept(); 
		// Accepting simple alert (click OK)

		String alert1 = confirmationMessage();

		if (success.equals(alert1)) {
			System.out.printf("%-15s : %s%n", "Result-1", "Test case passed succesfully clicked");
		} else {
			System.err.println("Test case failed didn't clicked");
		}

		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		// Locator: Button for Confirm Alert

		alertSwitch();

		String alert2Text = alertSwitch().getText(); 
		// Get confirm alert text

		System.out.printf("%-15s : %s%n", "Alert 2 Text", alert2Text);

		alertSwitch().dismiss(); 
		// Dismiss confirm alert (click Cancel)

		String cancel = "You clicked: Cancel";

		String alert2 = confirmationMessage();

		if (cancel.equals(alert2)) {
			System.out.printf("%-15s : %s%n", "Result-2", "Test case passed succesfully clicked");
		} else {
			System.err.println("Test case failed didn't clicked");
		}

		String text = "LambdaTest SDET";

		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		// Locator: Button for Prompt Alert

		alertSwitch();

		// 🟢 Alert Handling:
		// Prompt alert allows input using sendKeys()

		alertSwitch().sendKeys(text); 
		// Enter text inside prompt alert

		alertSwitch().accept(); 
		// Accept prompt alert

		String alert3 = confirmationMessage();

		if (alert3.contains(text)) {
			System.out.printf("%-15s : %s%n", "Result-3", "Test case passed succesfully clicked");
		} else {
			System.err.println("Test case failed didn't clicked");
		}

		System.out.println("=== Task 3 Complete — All 3 alert types handled ===");
	}

	public static Alert alertSwitch() {
		return driver.switchTo().alert();
		// Switch driver focus to alert popup
	}

	public static String confirmationMessage() {
		return driver.findElement(By.id("result")).getText();
		// Locator: Fetch result message using ID "result"
	}
}
