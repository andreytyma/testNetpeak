package netpeak;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

public class SignUp {

    @Test
    public void signUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver238.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://netpeak.ua/");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        String title = driver.getTitle();
        Assert.assertEquals("Раскрутка сайта, продвижение сайтов: Netpeak Украина — performance-маркетинг для бизнеса", title);

        driver.get("https://career.netpeak.ua/");

        driver.get("https://career.netpeak.ua/hiring/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form")));
//        driver.findElement(By.id("upload")).click();
//        в новом окне, не получается добавить картинку ((

        driver.findElement(By.id("inputName")).sendKeys("Kvaz");
        driver.findElement(By.id("inputLastname")).sendKeys("Padla");

        Random random = new Random();
        int n = random.nextInt(100) +1;
        String email = "kvaz" + n + "@gmail.com";
        driver.findElement(By.id("inputEmail")).sendKeys(email);

        driver.findElement(By.id("submit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"warning-fields help-block\"]")));

        driver.get("https://school.netpeak.group/");
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("teachers-block")));

        driver.quit();
    }
}
