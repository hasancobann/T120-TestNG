package tests.day16_testNG_framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;

public class C04_QualitydemyPozitifLogin {

    @Test
    public void pozitifLoginTesti(){
        // 1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");
        // 2- login linkine basin
        QualityDemyPage qualityDemyPage=new QualityDemyPage();
        qualityDemyPage.ilkLoginLinki.click();

        // 3- Kullanici email’i olarak valid email girin
        qualityDemyPage.emailKutusu.sendKeys("anevzatcelik@gmail.com");
        // 4- Kullanici sifresi olarak valid sifre girin
        qualityDemyPage.passwordKutusu.sendKeys("Nevzat152032");
        // 5- Login butonuna basarak login olun
        qualityDemyPage.loginButonu.click();
        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(qualityDemyPage.basariliGirisElementi.isDisplayed());
        Driver.closeDriver();

    }
}
