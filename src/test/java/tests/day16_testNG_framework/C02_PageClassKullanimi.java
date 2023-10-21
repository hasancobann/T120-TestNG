package tests.day16_testNG_framework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {

    @Test
    public void nutellaTest(){

        // amazona git
        Driver.getDriver().get("https://amazon.com");

        // nutella için aram yap
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // arama sonucunun nutella içerdiğini test et
        String expectedIcerik="Nutella";
        String actualSonucYazisi=amazonPage.sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        // driverı kapat.
        Driver.closeDriver();

    }

}
