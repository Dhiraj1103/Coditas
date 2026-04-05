package TasksWeek2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task4 {
	static WebDriver driver = EcommercePlayground.driver;

	public static void Frames() {
		
		System.out.println("=== Task 4:  Frames & iFrames   ===");

		final String actualURL = "https://the-internet.herokuapp.com/frames";
		driver.get(actualURL);
		
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		
		WebElement frame1 = driver.findElement(By.cssSelector("frame[name='frame-top']"));
		driver.switchTo().frame(frame1);
		
		WebElement frameLeft = driver.findElement(By.cssSelector("frame[name='frame-left']"));
		driver.switchTo().frame(frameLeft);
		String LeftFrameText = driver.findElement(By.cssSelector("body")).getText();
		System.out.printf("%-15s : %s%n", "LeftFrameText", LeftFrameText);
		
		driver.switchTo().parentFrame();
		WebElement frameRight = driver.findElement(By.cssSelector("frame[name='frame-right']"));
		driver.switchTo().frame(frameRight);
		String RightFrameText = driver.findElement(By.cssSelector("body")).getText();
		System.out.printf("%-15s : %s%n", "LeftFrameText", RightFrameText);
		
	
		driver.switchTo().parentFrame();
		WebElement frameMiddle = driver.findElement(By.cssSelector("frame[name='frame-middle']"));
		driver.switchTo().frame(frameMiddle);
		String MiddleFrameText = driver.findElement(By.cssSelector("body")).getText();
        final String MiddleFrame="MIDDLE";
        
		if (MiddleFrameText.equals(MiddleFrame)) {
			System.out.printf("%-15s : %s%n", "Result", "Test case passed Text matched successfully");
		} else {
			System.err.println("Test case failed Text did not matched successfully");
		}

		driver.get(actualURL);
		driver.findElement(By.xpath("//a[text()='iFrame']")).click();
		
		driver.findElement(By.cssSelector("div[class='tox-icon']")).click();

}
}




















