package LoginCode;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookLogin 
{
	WebDriver driver=null;
	
	
	@Test(dataProvider="logincode")
	public void loginPage(String username, String password) throws InterruptedException
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		
		Thread.sleep(4000);
		
		driver.findElement(By.id("email")).sendKeys(username);
		
		driver.findElement(By.id("pass")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@id='u_0_r']")).click();
		
		System.out.println(driver.getTitle());
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider(name="logincode")
	public Object[][] passData() throws Throwable
	{
		ExcelLib lib=new ExcelLib("C:\\Users\\Magushai OOONNNNGGGG\\Desktop\\Practice.xlsx");
		int row = lib.getRow("Sheet1");
		Object[][] obj=new Object[row][2];
		for(int i=0; i<row; i++)
		{
			obj[i][0]=lib.getData("Sheet1", i, 0);
			obj[i][1]=lib.getData("Sheet1", i, 1);
			
		}
		return obj;
	}
	

}
