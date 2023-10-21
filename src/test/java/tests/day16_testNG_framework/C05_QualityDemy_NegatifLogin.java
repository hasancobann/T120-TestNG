package tests.day16_testNG_framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;

public class C05_QualityDemy_NegatifLogin {

   // QualityDemyPage qualityDemyPage=new QualityDemyPage(); // tüm testlerde kullanabilmek adına burda oluşturduk.
    @Test
    public void gecersizPasswordTest(){

        Driver.getDriver().get("https://www.qualitydemy.com/");
        QualityDemyPage qualityDemyPage=new QualityDemyPage();

        //QualityDemyPage qualityDemyPage=new QualityDemyPage(); ancak bazen hata verebiliyor o sebeple testin içinde de oluşturabiliriz.
        qualityDemyPage.ilkLoginLinki.click();
        qualityDemyPage.emailKutusu.sendKeys("anevzatcelik@gmail.com");
        qualityDemyPage.passwordKutusu.sendKeys("123456");
        qualityDemyPage.loginButonu.click();

        Assert.assertTrue(qualityDemyPage.emailKutusu.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void gecersizEmailTesti(){
        Driver.getDriver().get("https://www.qualitydemy.com/");
        QualityDemyPage qualityDemyPage=new QualityDemyPage();

        qualityDemyPage.ilkLoginLinki.click();
        qualityDemyPage.emailKutusu.sendKeys("hcoban99@gmail.com");
        qualityDemyPage.passwordKutusu.sendKeys("Nevzat152032");
        qualityDemyPage.loginButonu.click();

        Assert.assertTrue(qualityDemyPage.emailKutusu.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void gecersizEmailPasswordTesti(){
        Driver.getDriver().get("https://www.qualitydemy.com/");
        QualityDemyPage qualityDemyPage=new QualityDemyPage();

        qualityDemyPage.ilkLoginLinki.click();
        qualityDemyPage.emailKutusu.sendKeys("hcoban99@gmail.com");
        qualityDemyPage.passwordKutusu.sendKeys("Nevzat182032");
        qualityDemyPage.loginButonu.click();

        Assert.assertTrue(qualityDemyPage.emailKutusu.isDisplayed());
        Driver.closeDriver();

    }
}
