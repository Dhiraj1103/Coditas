package TasksWeek2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class EcommercePlayground {
	static WebDriver driver;
	static final String BASE = "https://ecommerce-playground.lambdatest.io/";
		public static void main(String[] args) throws Exception {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//	Task1.Dropdown();
	//	Task1WithoutSelect.DropdownWithoutSelect();
	//	Task2.RadioButtonsCheckboxes();
    //    Task3.Alerts();
		Task4.Frames();
		
		System.out.println("\n====== ALL TASKS COMPLETE ======");
		//driver.quit();
		
		
}
}
