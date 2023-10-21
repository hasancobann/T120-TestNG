package tests.day19_testNGreports_crossBrowserTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluNegatifLoginTesti extends TestBaseRapor {

    @Test
    public void gecersizPasswordTest(){
        extentTest=extentReports.createTest("Geçersiz PasswordTesti","Kullanıcı geçersiz password ile giriş yapmamalı");

        Driver.getDriver().get("https://www.qualitydemy.com/");
        extentTest.info("Kullanıcı Qualitydemy anasayfya gider");
        QualityDemyPage qualityDemyPage=new QualityDemyPage();

        //QualityDemyPage qualityDemyPage=new QualityDemyPage(); ancak bazen hata verebiliyor o sebeple testin içinde de oluşturabiliriz.
        qualityDemyPage.ilkLoginLinki.click();
        extentTest.info("İlk sayfadaki login butonuna tıklar");
        qualityDemyPage.emailKutusu.sendKeys("anevzatcelik@gmail.com");
        extentTest.info("Username olarak geçerli username girer.");

        qualityDemyPage.passwordKutusu.sendKeys("123456");
        extentTest.info("Passwoprd olarak geçersiz password yazar.");
        qualityDemyPage.loginButonu.click();
        extentTest.info("Login butonuna basar.");

        Assert.assertTrue(qualityDemyPage.emailKutusu.isDisplayed());
        extentTest.pass("Kulalnıcı giriş yapılamadığını test eder.");
        Driver.closeDriver();
        extentTest.info("Sayfayı kapatır.");
    }

    @Test
    public void gecersizEmailTesti(){
        extentTest=extentReports.createTest("Geçersiz Email Testi","Kullanıcı geçersiz email ile giriş yapmamalı");
        Driver.getDriver().get("https://www.qualitydemy.com/");
        extentTest.info("Kullanıcı Qualitydemy anasayfya gider");
        QualityDemyPage qualityDemyPage=new QualityDemyPage();

        qualityDemyPage.ilkLoginLinki.click();
        extentTest.info("İlk sayfadaki login butonuna tıklar");
        qualityDemyPage.emailKutusu.sendKeys("hcoban99@gmail.com");
        extentTest.info("Username olarak geçersiz username girer.");
        qualityDemyPage.passwordKutusu.sendKeys("Nevzat152032");
        extentTest.info("Passwoprd olarak geçerli password yazar.");
        qualityDemyPage.loginButonu.click();
        extentTest.info("Login butonuna basar.");

        Assert.assertTrue(qualityDemyPage.emailKutusu.isDisplayed());
        extentTest.pass("Kulalnıcı giriş yapılamadığını test eder.");
        Driver.closeDriver();
        extentTest.info("Sayfayı kapatır.");
    }
    @Test
    public void gecersizEmailPasswordTesti(){
        extentTest=extentReports.createTest("Geçersiz Password ve Email Testi","Kullanıcı geçersiz email ve password ile giriş yapmamalı");
        Driver.getDriver().get("https://www.qualitydemy.com/");
        extentTest.info("Kullanıcı Qualitydemy anasayfya gider");
        QualityDemyPage qualityDemyPage=new QualityDemyPage();

        qualityDemyPage.ilkLoginLinki.click();
        extentTest.info("İlk sayfadaki login butonuna tıklar");
        qualityDemyPage.emailKutusu.sendKeys("hcoban99@gmail.com");
        extentTest.info("Username olarak geçersiz username girer.");
        qualityDemyPage.passwordKutusu.sendKeys("Nevzat182032");
        extentTest.info("Passwoprd olarak geçersiz password yazar.");
        qualityDemyPage.loginButonu.click();
        extentTest.info("Login butonuna basar.");

        Assert.assertTrue(qualityDemyPage.emailKutusu.isDisplayed());
        extentTest.pass("Kulalnıcı giriş yapılamadığını test eder.");
        Driver.closeDriver();
        extentTest.info("Sayfayı kapatır.");

    }
}
