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
public class HeadPhones {
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

            //Выбор элемента "Наушники и Bluetooth-гарнитуры"
            WebElement searchHeadPhones = driverc.findElement(By.xpath("//div/../a[contains(text(), 'Наушники и Bluetooth-гарнитуры')]"));
            searchHeadPhones.click();


            //Ввод суммы
            WebElement searchPrice1 = driverc.findElement(By.xpath("//div/span/span/input[contains(@name,'glf-pricefrom-var')]"));
            searchPrice1.sendKeys("17000");
            Thread.sleep(3000);

            WebElement searchPrice2 = driverc.findElement(By.xpath("//div/span/span/input[contains(@name,'glf-priceto-var')]"));
            searchPrice2.sendKeys("25000");
            Thread.sleep(3000);


            //Проставить Чек-бокс "Beats"
            WebElement searchBeats = driverc.findElement(By.xpath("//div/a/span/label[contains(text(),'Beats')]"));
            ((JavascriptExecutor) driverc).executeScript("arguments[0].scrollIntoView();", searchBeats);
            searchBeats.click();
            Thread.sleep(3000);


            //Подтвердить
            WebElement searchApply = driverc.findElement(By.xpath("//div/button[contains(@class,'button button_action_n-filter-apply')]"));
            ((JavascriptExecutor) driverc).executeScript("arguments[0].scrollIntoView();", searchApply);
            searchApply.click();

            // Выбор первой позиции
            WebElement searchFirstPositionOfBeats1 = driverc.findElement(By.xpath("//div/a[contains(@class,'link n-link_theme_blue')]"));
            ((JavascriptExecutor) driverc).executeScript("arguments[0].scrollIntoView();", searchFirstPositionOfBeats1);
            searchFirstPositionOfBeats1.getText();
            String flg1 = searchFirstPositionOfBeats1.getText();
            searchFirstPositionOfBeats1.click();


            // Выбрать второй позиции
            WebElement searchSecondPositionOfBeats1 = driverc.findElement(By.xpath("//div/h1[contains(@class,'title title_size_28 title_bold_yes')]"));
            searchSecondPositionOfBeats1.getText();
            String flg2 = searchSecondPositionOfBeats1.getText();

            // Сравнить значения
            Assert.assertTrue(flg1.equals(flg2));



        }catch (InterruptedException c){
            c.printStackTrace();
        }

    }
}
