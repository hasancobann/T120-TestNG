package tests.day17_testNGFramework_assertions;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C02_QualityDemyPozitifLoginTesti {
    @Test
    public void test01() throws IOException {

            //1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
            //2- login linkine basin
        QualityDemyPage qualityDemyPage=new QualityDemyPage();
        qualityDemyPage.ilkLoginLinki.click();

            //3- Kullanici email'i olarak valid email girin
        qualityDemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliEmail"));

            //4- Kullanici sifresi olarak valid sifre girin
        qualityDemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        ReusableMethods.bekle(2);

            //5- Login butonuna basarak login olun
        Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();
        ReusableMethods.bekle(2);
        qualityDemyPage.loginButonu.click();

            //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(qualityDemyPage.basariliGirisElementi.isDisplayed());
        ReusableMethods.getScreenshot("giris1");
        Driver.closeDriver();


        }

    }



