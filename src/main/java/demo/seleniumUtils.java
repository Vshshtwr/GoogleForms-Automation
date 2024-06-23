package demo;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;






public class seleniumUtils {
    private WebDriverWait wait;
    private WebDriver driver;
    
    public seleniumUtils(WebDriver driver){
        this.driver = driver;
    }
    public void insertValues(By locator, String Text){

        WebElement textBox = driver.findElement(locator);
        textBox.clear();
        textBox.sendKeys(Text);


    }

    public void radioButton(By locator){
        WebElement radio = driver.findElement(locator);
        if(!radio.isSelected()){
            radio.click();
        }
    }

    public void selectCheckBox(By locator){
        WebElement checkBox = driver.findElement(locator);
        if(!checkBox.isSelected()){
            checkBox.click();
        }
    }

    public void selectdropdown(By locator, By optionlocator) throws InterruptedException{
       WebElement dropdown = driver.findElement(locator);
       dropdown.click();
       Thread.sleep(2000);
       WebElement optionElement = driver.findElement(optionlocator);
       optionElement.click();
    }
    
    public void date(By dateFieldLocator){
        LocalDate currentdate = LocalDate.now();
        LocalDate updatedDate = currentdate.minusDays(7);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = updatedDate.format(formatter);

        WebElement dateField = driver.findElement(dateFieldLocator);
        //dateField.click();
        dateField.clear();
        dateField.sendKeys(formattedDate); 
        dateField.sendKeys(Keys.TAB);

        System.out.println(formattedDate);


    }

    public void currentTime(By locator){

        LocalTime currentTime = LocalTime.now();

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH");
        String formattedTime = currentTime.format(timeFormatter);
        System.out.println(formattedTime);

        DateTimeFormatter timeFormatterSec = DateTimeFormatter.ofPattern("mm");
        String formattedTimeSec = currentTime.format(timeFormatterSec);
        System.out.println(formattedTimeSec);




        WebElement timeField = driver.findElement(locator);
        timeField.click();
        timeField.sendKeys(formattedTime);
        timeField.sendKeys(Keys.TAB);

        WebElement timeFieldSec = driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[4]"));
        timeFieldSec.sendKeys(formattedTimeSec);

    }
}
