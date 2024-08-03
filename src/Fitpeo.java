import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Fitpeo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webDriver.chrome.driver", "C:\\Users\\Ritika Das\\Downloads\\selenium softweres and jars\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver cdriver=new ChromeDriver();
		cdriver.manage().window().maximize();
		
		// 1.Navigate to the FitPeo Homepage
		cdriver.get("https://www.fitpeo.com/");
		
		
		// 2.Navigate to the Revenue Calculator Page
		cdriver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
		Thread.sleep(1500);
		
		
		// 3.Scroll Down to the Slider section
		 Actions actions = new Actions(cdriver);
		 actions.scrollByAmount(0,450).build().perform();
		 Thread.sleep(1500);
		 
		 
		 // 4.Adjust the Slider
		 WebElement Slider = cdriver.findElement(By.xpath("//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-sy3s50']"));
			WebElement textField = cdriver.findElement(By.xpath("//body/div/div/div/div[2]/div/div/div/div/input"));
			actions.clickAndHold(Slider).build().perform();
			String textFieldValue = textField.getAttribute("value");
			int targetValue = 820;
			while(Integer.parseInt(textFieldValue) != targetValue-1)
			{
				textFieldValue = textField.getAttribute("value");
				actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
			}
			if(Integer.parseInt(textFieldValue)==targetValue-1) {
				System.out.println("Bottom text field value updated to 820");
			}

			
			// 5.Update the Text Field
			textField.click();
			int Lenght = textField.getAttribute("value").length(); 
			for(int i = 1 ; i <= Lenght ; i++) {
				actions.sendKeys(Keys.BACK_SPACE).build().perform();
			}
			textField.sendKeys("560");
			
			
			// 6.Validate Slider Value
			WebElement SliderValue = cdriver.findElement(By.xpath("//body/div/div/div/div[2]/div/div/span/span[3]/input"));
			if(Integer.parseInt(SliderValue.getAttribute("value"))==560) {
				System.out.println("Slider's position is updated to 560");
			}
			Thread.sleep(2500);
			
			
			// 7.Select CPT Codes
			WebElement cptCheckBox99091 = cdriver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
			actions.scrollToElement(cptCheckBox99091).build().perform();
			cdriver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
			cdriver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
			cptCheckBox99091.click();
			WebElement cptCheckBox99474 = cdriver.findElement(By.xpath("(//input[@type='checkbox'])[8]"));
			actions.scrollToElement(cptCheckBox99474).build().perform();
			cptCheckBox99474.click();
			Thread.sleep(2500);
			
			
			// 8.Validate Total Recurring Reimbursement
			actions.scrollToElement(textField).build().perform();
			textField.click();
			for(int i = 1 ; i <= Lenght ; i++) {
				actions.sendKeys(Keys.BACK_SPACE).build().perform();
			}
			textField.sendKeys("820");
			
			
			// 9.Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month: shows the value $110700
			actions.scrollToElement(cptCheckBox99474).build().perform();
			WebElement total = cdriver.findElement(By.xpath("//body/div/div/header/div/p[4]/p"));
			String totalReccuring = total.getText();
			String totalRecurringReimbursement = "" ;
			for(int i = 1 ; i <= totalReccuring.length()-1 ; i++) {
				totalRecurringReimbursement = totalRecurringReimbursement + totalReccuring.charAt(i);
			}
			if(Integer.parseInt(totalRecurringReimbursement)==110700) {
				System.out.println("Total:$"+totalRecurringReimbursement);
			}
	}
}