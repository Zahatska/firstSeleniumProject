import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class privat24AddMoneyToMobile {

    @Test
    public void checkAddMoneyToMobile(){

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        By countryBtn = By.xpath("//button[@data-qa-node='phone-code']");
        By countryDropDownInput = By.xpath("//input[@placeholder='Пошук']");
        By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
        By sum = By.xpath("//input[@data-qa-node='amount']");
        By cardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By expDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By firstNamed = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        By lastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        By submitBtn = By.xpath("//button[@data-qa-node='submit']");


//заполнение формы
        driver.get("https://next.privat24.ua/mobile");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(countryBtn).click();
        driver.findElement(countryDropDownInput).sendKeys("+380");
        driver.findElement(countryBtn).click();
        driver.findElement(phoneNumber).sendKeys("661313111");
        driver.findElement(sum).sendKeys("170");
        driver.findElement(cardNumber).sendKeys("4567739561253907");
        driver.findElement(expDate).sendKeys("0924");
        driver.findElement(cvv).sendKeys("528");
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
        driver.findElement(firstNamed).sendKeys("Ruth");
        driver.findElement(lastName).sendKeys("Montaivo");
        driver.findElement(submitBtn).click();



//проверка
        By actualPhoneNumber = By.xpath("//*[@data-qa-node='details']");
        By actualCardNumber = By.xpath("//*[@data-qa-node='card']");
        By actualSum = By.xpath("(//*[@data-qa-node='amount'])[2]");

        Assert.assertEquals("Поповнення телефону. На номер +380661313111", driver.findElement(actualPhoneNumber).getText());
        Assert.assertEquals("4567 **** **** 3907", driver.findElement(actualCardNumber).getText());
        Assert.assertEquals("170 UAH", driver.findElement(actualSum).getText());


        driver.close();



    }

}
