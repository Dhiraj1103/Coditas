package TasksWeek2;

import java.util.List;

import org.openqa.selenium.By; // Used for locating elements
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1WithoutSelect {

	public static void DropdownWithoutSelect() throws InterruptedException {
		System.out.println();
		System.out.println("=== Task 1:  Dropdown —Without Select Class (Show & Sort By)   ===");

		WebDriver driver = EcommercePlayground.driver;

		final String actualURL = EcommercePlayground.BASE;
		driver.get(actualURL);

		

		// 1
		driver.findElement(By.xpath("//a[contains(@class,'icon-left both text-reset')]")).click();
		// Locator: Menu link using partial class match

		driver.findElement(By.xpath("//span[contains(text(),' Cameras')]")).click();
		// Locator: "Cameras" option using visible text

		// 2
		final String title = "Cameras";
		String currentTitle = driver.getTitle();

		if (title.equals(currentTitle)) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Title matched succesfully");
		} else {
			System.err.println("Test case failed title mismatched");
		}

		System.out.println();

		int idx = 1;
		System.out.println("Values inside the show dropdown: ");

		List<WebElement> values = driver.findElements(By.cssSelector("#input-limit-212402 option"));
		// Locator: Fetch all dropdown options using CSS selector (id + option tag)

		for (WebElement i : values) {
			System.out.println(i.getText());
			idx++;
		}

		idx = 0;
		System.out.println();

		final int totalCount = 5;
		int currentSize = values.size();

		if (totalCount == currentSize) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Count 5 matched succesfully");
		} else {
			System.err.println("Test case failed Count 5 mismatched");
		}

		driver.findElement(By.xpath("//option[text()='25']")).click();
		// Locator: Select option "25" using visible text

		// 🔴 Possible Stale Element Scenario:
		// After clicking dropdown option, page may reload/update DOM
		// So always re-fetch element instead of storing old reference

		String select25 = driver.findElement(By.xpath("//option[text()='25']")).getAttribute("selected");
		// Locator reused to avoid stale element

		String attribute = "true";

		if (select25.equals(attribute)) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value 25 matched succesfully");
		} else {
			System.err.println("Test case failed Selected Value 25 mismatched");
		}

		driver.findElement(By.xpath("//option[text()='50']")).click();
		// Locator: Select option "50"

		String select50 = driver.findElement(By.xpath("//select[@id='input-limit-212402']/option[text()='50']")).getAttribute("selected");
		// Locator: Using parent select + option for better accuracy

		// 🔴 Stale Element Handling:
		// Re-locating element again after DOM refresh

		if (select50.equals(attribute)) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value 50  matched succesfully");
		} else {
			System.err.println("Test case failed Selected Value 50 mismatched");
		}

		driver.findElement(By.xpath("//option[text()='15']")).click();
		// Locator: Select option "15"

		String select15 = driver.findElement(By.xpath("//option[text()='15']")).getAttribute("selected");
		// Locator reused

		// 🔴 Stale Element Handling (same reason)

		if (select15.equals(attribute)) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value 15  matched succesfully");
		} else {
			System.err.println("Test case failed Selected Value 15 mismatched");
		}

		driver.findElement(By.xpath("//option[text()='Name (A - Z)']")).click();
		// Locator: Sort dropdown option "Name (A - Z)"

		String selectName = driver.findElement(By.xpath("//option[text()='Name (A - Z)']")).getAttribute("selected");
		// Locator reused

		if (selectName.equals(attribute)) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value Name (A - Z) matched succesfully");
		} else {
			System.err.println("Test case failed Selected Value Name (A - Z) mismatched");
		}

		driver.findElement(By.xpath("//option[text()='Price (Low > High)']")).click();
		// Locator: Sort dropdown option "Price (Low > High)"

		String selectPrice = driver.findElement(By.xpath("//option[text()='Price (Low > High)']")).getAttribute("selected");
		// Locator reused

		if (selectPrice.equals(attribute)) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Selected Value Price (Low > High) matched succesfully");
		} else {
			System.err.println("Test case failed Selected Value Price (Low > High) mismatched");
		}

		System.out.println("=== Task 1 Complete — Verified without Select class on Show and Sort By dropdowns ===");

	}
}
















