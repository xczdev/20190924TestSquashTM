package autom.SquashTM;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Test1 {
	WebDriver driver;
	
	/*
	 * // Web Elements
	 * 
	 * @FindBy(how = How.XPATH, using="//input[@id='username']") private WebElement
	 * input_username;
	 * 
	 * @FindBy(how = How.XPATH, using="//input[@id='password']") private WebElement
	 * input_pwd;
	 * 
	 * @FindBy(how = How.XPATH, using="//input[@value='Se connecter']")
	 * //div[contains(class(),'banner_banner')]//span[contains(text(),'Continuer')]
	 * private WebElement bouton_se_connecter;
	 */

	
	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Installation\\drivers\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Installation\\drivers\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Installation\\drivers\\IEDriverServer.exe");
		
		driver =new FirefoxDriver();
		//driver =new ChromeDriver();
		//driver =new InternetExplorerDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://192.168.102.135:9090/squash/login");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@value='Se connecter']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@id='test-case-link']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='tree']/ul[1]/li[1]/a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='tree-create-button']/span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='ui-id-9']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='add-test-case-name']")).clear();
		driver.findElement(By.xpath("//input[@id='add-test-case-name']")).sendKeys("New CT3");
		
		driver.findElement(By.xpath("//input[@value='Ajouter' and @style]")).click();
		Thread.sleep(2000);
	
		assertTrue("Le nouveau CT n'est pas present", driver.findElement(By.xpath("//div[@id='tree']//a[contains(text(), 'New CT3')]")).isDisplayed());

	}
		
	
	  @After 
	  public void teardown() { 
		  driver.close(); 
		  }
	
}
