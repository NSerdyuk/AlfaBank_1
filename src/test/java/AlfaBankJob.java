import Methods.AlfaBankMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Натали on 08.11.2017.
 */
public class AlfaBankJob {
    @Test
    public void main() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Натали/IdeaProjects/YandexMarket/.idea/drr/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(co);
        driver.get("https://www.google.ru/");
        //driver.get("https://yandex.ru/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Ввод "Альфа-Банк" в поисковой системе
        WebElement search = driver.findElement(By.xpath("//div/input[@id='lst-ib']"));
        search.sendKeys("Альфа-Банк");
        search.submit();

        Set<String> windowHandles = driver.getWindowHandles();

        //Переход на главную страницу сайта 'alfabank.ru/'
        WebElement alfaBank = driver.findElement(By.xpath("//div/h3/a[@href='https://alfabank.ru/']"));
        alfaBank.click();

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(windowHandles);
        driver.switchTo().window(newTab.get(1));


        WebElement jobAlfaBank = driver.findElement(By.xpath("//div/ul/li/a[@href='http://job.alfabank.ru/' and text()='Работайте у нас']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", jobAlfaBank);
        jobAlfaBank.click();

        //Переход в раздел «о работе в банке»
        WebElement aboutJob = driver.findElement(By.xpath("//span/a[contains(@href,'/about/')]"));
        aboutJob.click();


        WebElement title = driver.findElement(By.xpath("//div[contains(text(),'Альфа-Банк для сотрудников!')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", title);
        title.getText();
        String ttl = title.getText();


        WebElement text = driver.findElement(By.xpath("//div[@class ='info']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", text);
        text.getText();
        String txt = text.getText();

        // сам метод в классе AlfaBankMethods
        AlfaBankMethods alf = new AlfaBankMethods();
        alf.writeUsingFileWriter(ttl, txt);

        driver.quit();

    }

}
