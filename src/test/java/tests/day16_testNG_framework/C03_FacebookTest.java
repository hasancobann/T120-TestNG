package tests.day16_testNG_framework;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C03_FacebookTest {
    @Test(groups = {"regression","smoke"})
    public void facebookTest() throws IOException {
      // 1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");
      // 2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

        ReusableMethods.bekle(1);
      // 3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin

        Faker faker=new Faker();
        FacebookPage facebookPage=new FacebookPage();

        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());
        facebookPage.loginButton.click();

      // 4- Basarili giris yapilamadigini test edin
       Assert.assertTrue(facebookPage.girisYapilamadiYaziElementi.isDisplayed());

       ReusableMethods.getScreenshot("shot");

        Driver.closeDriver();


    }
}
