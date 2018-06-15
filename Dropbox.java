import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc/basic/drag");
		 WebElement From = driver.findElement(By.id("dragbox"));	
		    WebElement To=driver.findElement(By.id("dropbox"));
		    WebElement page = driver.findElement(By.className("page"));
	
		Actions builder = new Actions(driver);
		Actions action = builder.clickAndHold(From);
		builder.build();
		action.perform();

		
		Actions builder2 = new Actions(driver);
		Actions action2 = builder.moveToElement(To);
		builder.release(To);
		builder.build();
		action.perform();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Proceed"))).click();
	}
	}


