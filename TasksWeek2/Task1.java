package TasksWeek2;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By; // Used to locate elements (locators)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task1 {

	static WebDriver driver = EcommercePlayground.driver;

	public static void Dropdown() {
		System.out.println();
		System.out.println("=== Task 1:  Dropdown — Select Class (Show & Sort By)   ===");

		final String actualURL = EcommercePlayground.BASE;
		driver.get(actualURL);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// 1
		driver.findElement(By.xpath("//a[contains(@class,'icon-left both text-reset')]")).click(); 
		// Locator: Finds menu link using partial class match

		driver.findElement(By.xpath("//span[contains(text(),' Cameras')]")).click(); 
		// Locator: Finds "Cameras" option using visible text

		// 2
		final String title = "Cameras";
		String currentTitle = driver.getTitle();

		if (title.equals(currentTitle)) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Title matched succesfully");
		} else {
			System.err.println("Test case failed title mismatched");
		}

		System.out.println();

		// 4
		List<WebElement> values = SelectClass().getOptions(); 
		// Using Select class to fetch dropdown options

		int idx = 1;
		System.out.println("Values inside the show dropdown: ");

		for (WebElement i : values) {
			System.out.println(idx + ": " + i.getText());
			idx++;
		}

		idx = 0;
		System.out.println();

		// 5
		final int totalCount = 5;
		int currentSize = values.size();

		if (totalCount == currentSize) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Count 5 matched succesfully");
		} else {
			System.err.println("Test case failed Count 5 mismatched");
		}

		// 6
		Actions act = new Actions(driver);

		act.scrollToElement(driver.findElement(By.className("text-ellipsis-2"))).perform(); 
		// Locator: Scroll to product element using class name

		final String selectValue = "25";

		SelectClass().selectByVisibleText("25");

		// 🔴 Stale Element Exception handling:
		// After selecting value, DOM refreshes -> old WebElement becomes stale
		// So we re-fetch element using SelectClass() again

		String currentSelected = SelectClass().getFirstSelectedOption().getText();

		if (selectValue.equals(currentSelected)) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value 25 matched succesfully");
		} else {
			System.err.println("Test case failed Selected Value 25 mismatched");
		}

		// 7
		final String selectValue2 = "50";

		act.scrollToElement(driver.findElement(By.className("text-ellipsis-2"))).perform(); 
		// Locator reused to ensure visibility before interaction

		SelectClass().selectByVisibleText("50");

		// 🔴 Stale Element Exception handling (same reason as above)

		String currentSelected2 = SelectClass().getFirstSelectedOption().getText();

		if (selectValue2.equals(currentSelected2)) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value 50 matched succesfully");
		} else {
			System.err.println("Test case failed Selected Value 50 mismatched");
		}

		// 8
		final String selectValue3 = "15";

		act.scrollToElement(driver.findElement(By.className("text-ellipsis-2"))).perform(); 
		// Locator used again for scrolling

		SelectClass().selectByIndex(0);

		// 🔴 Stale Element Exception handling (DOM refreshed again)

		String currentSelected3 = SelectClass().getFirstSelectedOption().getText();

		if (selectValue3.equals(currentSelected3)) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value 15 matched succesfully");
		} else {
			System.err.println("Test case failed Selected Value 15 mismatched");
		}

		System.out.println();

		// 10
		List<WebElement> sortList = SelectClass2().getOptions(); 
		// Fetch options from Sort By dropdown

		System.out.println("Values in Sort list: ");

		for (WebElement i : sortList) {
			System.out.println(idx + ": " + i.getText());
			idx++;
		}

		idx = 0;
		System.out.println();

		act.scrollToElement(driver.findElement(By.className("text-ellipsis-2"))).perform(); 
		// Scroll again before interacting

		// 11
		final String sortVal1 = "Name (A - Z)";

		SelectClass2().selectByVisibleText(sortVal1);

		// No stale issue here (but still safe practice to re-fetch)

		String sortCurrentVal1 = SelectClass2().getFirstSelectedOption().getText();

		if (sortVal1.equals(sortCurrentVal1)) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value Name (A - Z) matched succesfully");
		} else {
			System.err.println("Test case failed Selected Value Name (A - Z) mismatched");
		}

		// 12
		act.scrollToElement(driver.findElement(By.className("text-ellipsis-2"))).perform(); 
		// Scroll before selecting next option

		final String sortVal2 = "Price (Low > High)";

		SelectClass2().selectByVisibleText(sortVal2);

		String sortCurrentVal2 = SelectClass2().getFirstSelectedOption().getText();

		if (sortVal2.equals(sortCurrentVal2)) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value Price (Low > High) matched succesfully");
		} else {
			System.err.println("Test case failed Selected Value Price (Low > High) mismatched");
		}

		System.out.println();
		System.out.println(" '=== Task 1 Complete — Select class verified on Show and Sort By dropdowns ===");
	}

	public static WebElement LocatorShow() {
		return driver.findElement(By.className("custom-select")); 
		// Locator: Finds "Show" dropdown using class name
	}

	public static Select SelectClass() {
		Select sel = new Select(LocatorShow());
		return sel; 
		// Wrap WebElement into Select class for dropdown handling
	}

	public static WebElement LocatorSortBy() {
		return driver.findElement(By.id("input-sort-212403")); 
		// Locator: Finds "Sort By" dropdown using ID
	}

	public static Select SelectClass2() {
		Select sel = new Select(LocatorSortBy());
		return sel; 
		// Wrap Sort dropdown into Select class
	}
}
