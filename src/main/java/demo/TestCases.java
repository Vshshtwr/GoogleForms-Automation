package demo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.internal.Utils;


public class TestCases {
    ChromeDriver driver;
    seleniumUtils utils;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        utils = new seleniumUtils(driver); 
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
       // driver.close();
       // driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        Thread.sleep(2000);


        utils.insertValues(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]"), "Vishesh Tiwari");

         Thread.sleep(2000);

        long epoch = System.currentTimeMillis()/1000;

        utils.insertValues(By.xpath("//textarea[@aria-label='Your answer']"), "I want to be the best QA Engineer!" + epoch);

        // WebElement fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]")));
        // fullName.sendKeys("Vishesh Tiwari");

        // WebElement textArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@aria-label='Your answer']")));
        // textArea.sendKeys("I want to be the best QA Engineer!" + epoch);

        utils.radioButton(By.xpath("(//div[@class='AB7Lab Id5V1'])[1]"));

        utils.selectCheckBox(By.xpath("//span[text()='Java']"));
        utils.selectCheckBox(By.xpath("//span[text()='Selenium']"));
        utils.selectCheckBox(By.xpath("//span[text()='TestNG']"));

        utils.selectdropdown(By.xpath("//span[text()='Choose']"), By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div[3]"));

        Thread.sleep(2000);
 
        utils.date(By.xpath("(//input[@class='whsOnd zHQkBf'])[2]"));


         Thread.sleep(2000);

         utils.currentTime(By.xpath("(//input[@jsname='YPqjbf'])[3]"));

         Thread.sleep(2000);

         driver.get("https://www.amazon.com/");
         Thread.sleep(2000);

         Alert alert = driver.switchTo().alert();
         alert.dismiss();

         WebElement submitButton = driver.findElement(By.xpath("//span[text()='Submit']"));
         submitButton.click();

         WebElement Message = driver.findElement(By.xpath("//div[@class='vHW8K']"));
         String printmsg = Message.getText();
         System.out.println(printmsg);

        System.out.println("end Test case: testCase01");
    }


}
