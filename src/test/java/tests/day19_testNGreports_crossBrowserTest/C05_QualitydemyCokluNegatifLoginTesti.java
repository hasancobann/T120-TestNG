package tests.day19_testNGreports_crossBrowserTest;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_QualitydemyCokluNegatifLoginTesti {

/*
    @DataProvider
    public static Object[][] gecersizGirisBilgileri() {

        String [][] gecersizKullaniciBilgileri={{"ahmer","12345"},{"mehmet","12548"},{"veli","78548"},{"ali","85486548"},{"hasan","45485"}};
        return gecersizKullaniciBilgileri;
    }

 */
    @DataProvider
    public static Object[][] gecersizGirisBilgileri() {

        String [][] gecersizKullaniciBilgileri=new String[10][2]; // [2]==> e mail ve password

        Faker faker=new Faker();

        for (int i = 0; i < gecersizKullaniciBilgileri.length; i++) {

            gecersizKullaniciBilgileri[i][0]=faker.internet().emailAddress();
            gecersizKullaniciBilgileri[i][1]=faker.internet().password();

        }
        return gecersizKullaniciBilgileri;
    }

    @Test(dataProvider = "gecersizGirisBilgileri")
    public void cokluNegatifTest(String username, String password){

        //qualitydemy anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //ilk login linkine tıklayın
        QualityDemyPage qualityDemyPage=new QualityDemyPage();
        qualityDemyPage.ilkLoginLinki.click();

        //verilen geçersiz kullanıcı adı ve şifreleri listesindeki 5 username ve password için giriş yapılamadığını test edin
        qualityDemyPage.emailKutusu.sendKeys(username);
        qualityDemyPage.passwordKutusu.sendKeys(password);
        qualityDemyPage.loginButonu.click();

        Assert.assertTrue(qualityDemyPage.emailKutusu.isDisplayed());

        //sayfayı kapatın
        Driver.closeDriver();

    }
}
