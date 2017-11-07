import org.junit.Assert;
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
public class PhoneSamsung {
    @Test
    public void main() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Натали/IdeaProjects/YandexMarket/.idea/drr/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("start-maximized");
        WebDriver driverc = new ChromeDriver();
        driverc.get("https://market.yandex.ru/");
        driverc.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driverc.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        try {

            //Главная страница
            WebElement searchRegion = driverc.findElement(By.xpath("//div[contains(@class,'n-region-notification')]"));
            WebElement yesButton = driverc.findElement(By.xpath("//div/span[contains(@class,'button2')]"));
            yesButton.click();

            //Выбор элемента "Электроника"
            WebElement searchElectronyk = driverc.findElement(By.xpath("//div/../a[contains(text(), 'Электроника')]"));
            searchElectronyk.click();

            //Выбор элемента "Мобильные телефоны"
            WebElement searchPhone = driverc.findElement(By.xpath("//div/../a[contains(text(), 'Мобильные телефоны')]"));
            searchPhone.click();


            //Ввод суммы
            WebElement searchPrice = driverc.findElement(By.xpath("//div/span/span/input[contains(@class,'input__control')]"));
            searchPrice.sendKeys("40000");

            //Проставить Чек-бокс "Смартфон_Самсунг"
            WebElement searchSamsung = driverc.findElement(By.xpath("//div/a/span/label[contains(text(),'Samsung')]"));
            ((JavascriptExecutor) driverc).executeScript("arguments[0].scrollIntoView();", searchSamsung);
            searchSamsung.click();

            //Подтвердить
            WebElement searchApply = driverc.findElement(By.xpath("//div/button[contains(@class,'button button_action_n-filter-apply')]"));
            ((JavascriptExecutor) driverc).executeScript("arguments[0].scrollIntoView();", searchApply);
            searchApply.click();

            // Выбор первого смартфона
            Thread.sleep(2000);
            WebElement searchFirstPositionOfPhone1 = driverc.findElement(By.xpath("//div/a[contains(@class,'link n-link_theme_blue')]"));
            ((JavascriptExecutor) driverc).executeScript("arguments[0].scrollIntoView();", searchFirstPositionOfPhone1);
            searchFirstPositionOfPhone1.getText();
            String flg1 = searchFirstPositionOfPhone1.getText();
            searchFirstPositionOfPhone1.click();


            // Выбрать "Самсунг"
            WebElement phoneSamsung = driverc.findElement(By.xpath("//div/h1[contains(@class,'title title_size_28 title_bold_yes')]"));
            phoneSamsung.getText();
            String flg2 = phoneSamsung.getText();

            // Сравнить значения
            Assert.assertTrue(flg1.equals(flg2));

        }

        catch (InterruptedException c){
            c.printStackTrace();
        }

    }

}
