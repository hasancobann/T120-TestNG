package tests.day19_testNGreports_crossBrowserTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_AmazonCokluArama {
    @Test
    public void amazonTopluArama(){
        //Amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Verilen listedeki her bir ürün arama yaptırın ve her ürün için bulunan sonuç sayısının 1000'den fazla olduğunu test edin
        String[] aranacakUrunler={"Nutella","Java","Armut","Elma","Erik","Malatya"};
        AmazonPage amazonPage=new AmazonPage();
        String aramaSonucu;
        String[] aramaSonucKelimeleri;
        String aramaSonucSayisiStr;
        int aramaSonucSayisiInt = 0;

        for (int i = 0; i < aranacakUrunler.length; i++) {
            amazonPage.aramaKutusu.clear();
            amazonPage.aramaKutusu.sendKeys(aranacakUrunler[i]+ Keys.ENTER);
            aramaSonucu=amazonPage.sonucYaziElementi.getText();
            aramaSonucKelimeleri=aramaSonucu.split(" ");
            
            if (aramaSonucKelimeleri.equals("over")){
                aramaSonucSayisiStr=aramaSonucKelimeleri[3];
            }else {
                aramaSonucSayisiStr=aramaSonucKelimeleri[2];
            }
            aramaSonucSayisiStr=aramaSonucSayisiStr.replaceAll("\\D","");
            aramaSonucSayisiInt=Integer.parseInt(aramaSonucSayisiStr);
            
        }

        Assert.assertTrue(aramaSonucSayisiInt>100);


        //

    }
}
