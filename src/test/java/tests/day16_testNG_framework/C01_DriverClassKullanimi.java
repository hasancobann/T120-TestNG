package tests.day16_testNG_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverClassKullanimi {

    @Test(groups = {"smoke"})
    public void amazonTest(){
        // amazon anasayfaya git
        Driver.getDriver().get("https://amazon.com");

        // nutella için arama yapalım
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

       // sayfayı kapatın
        Driver.closeDriver();
    }

    @Test
    public void youtubeTest(){
        Driver.getDriver().get("https://youtube.com");
        Driver.closeDriver();
    }
}
