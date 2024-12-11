import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainClass {
    public static void main(String[] args) {
        String chromeDriverPath = "C:/Projects/TestWeb/drivers/chromedriver.exe";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://account.mail.ru/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assertions.assertEquals(driver.findElement(By.xpath("//input[@name='username']")), driver.switchTo().activeElement());
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("palkenson5");
        driver.findElement(By.xpath("//span[text()='Войти']")).click();
        driver.findElement(By.xpath("//a[text()='Не могу войти']")).click();
        driver.findElement(By.xpath("//a[text()='Использовать пароль для входа']")).click();

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("meDovik-9neverie-trepusha");

        driver.findElement(By.xpath("//span[@class='inner-0-2-81 innerTextWrapper-0-2-82' and text()='Войти']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//div[@aria-label='palkenson5@mail.ru']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement name = driver.findElement(By.xpath("//*[@aria-label='Артем Палкин']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String check_user = name.getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Assertions.assertEquals("ник для проверки", check_user);
        driver.findElement(By.xpath("//div[@class='ph-text svelte-3ikppe']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        boolean isDisplayed = driver.findElement(By.xpath("//a[contains(@class, 'resplash-btn_outlined-themed')]")).isDisplayed();
        if (isDisplayed) {
            System.out.println("Выход успешен. Элемент 'Создать почту' отображается.");
        } else {
            System.out.println("Выход не был успешным. Элемент 'Создать почту' не отображается.");
        }

        driver.close();
    }
}
