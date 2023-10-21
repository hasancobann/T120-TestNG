package tests.day15_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.annotation.Target;

public class C01_Priority {

    int a=20;
    int b=10;

    @Test(priority = 5)
    public void carpmaTesti(){
        //Sayılarının çarpımının 100'den büyük olduğunu test edin
        Assert.assertTrue(a*b>100);
    }

    @Test(groups = {"smoke","e2e1","regression"})
    public void toplamaTesti(){

        // sayıların toplamının pozitif bir sayı olduğunu test edin
        Assert.assertTrue(a+b>0);
    }

    @Test(priority = -55)
    public void cikarmaTesti(){

        // a ile b'nin farkının mutlak değerinin 100 den küçük olduğunu test edin

        Assert.assertTrue((a-b)>-100&&a-b<100);
    }

    /*
    TesNG hiçbir müdahale olmaz ise testleri isim sırasına göre çalıştırır.
    Testlerin çalışma sıralamasını istediğimiz şekilde düzenleyebiliriz.
    Testlere vereceğimiz priority değerlerine göre küçükten büyüğe doğru çalıştırır.
    Priority atanmaz ise testNG default olarak 0 alır.
    Aynı priority değerine sahip birden fazla test metodu var ise bunlar kendi içerisinde isim sırasına göre çalışır.
     */
}
