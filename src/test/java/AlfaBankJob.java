import Methods.AlfaBankMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

        //Переход на главную страницу сайта 'alfabank.ru/'
        WebElement alfaBank = driver.findElement(By.xpath("//div/h3/a[@href='https://alfabank.ru/']"));
        alfaBank.click();

        /*try {
            Thread.sleep(7000);*/

        /* На элементе 'jobAlfaBank' тест падает, не находит его на главной странице.
        Испробовала массу вариантов поиска по xpath, css. В консоле браузера элемент успешно находится.
        Если выполнить тест без поисковой системы, а сразу подгружать главную страницу, переход в раздел "Работайте у нас" -выполняется.
        Пробовала добавить sleep/wait.until(ExpectedCondition), чтобы страница успела загрузиться - тоже не помогло.

        Если вас не затруднит, могли бы вы в ответном письме выслать мне правильный вариант поиска этого элемента на главной странице 'https://alfabank.ru/'.
        Спасибо.
         */

        WebElement jobAlfaBank = driver.findElement(By.xpath("//body/div/div/div/div/div/div/ul/li/a[@href='http://job.alfabank.ru/' and text()='Работайте у нас']"));
        //body[@id='home_page']/div/div[6]/div/div/div/div[3]/ul/li[3]/a
        // body/div/div/div/div/div/div/ul/li/a[@href='http://job.alfabank.ru/'
        //WebElement jobAlfaBank = driver.findElement(By.cssSelector(".footer__nav-column>ul>li>a"));
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

    }

    /*catch (InterruptedException c){
            c.printStackTrace();*/
}
