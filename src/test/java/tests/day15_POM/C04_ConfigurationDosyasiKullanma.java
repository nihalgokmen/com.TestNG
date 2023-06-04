package tests.day15_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_ConfigurationDosyasiKullanma<FileInputStream> {

    /*
        POM'de hedef test class'inda
        manuel olarak hic bir Test Data'si GIRMEMEKTIR

        Test datalari :
        1- Kullanacagimiz WebDriver : Driver class'indan dinamik olarak kullaniyoruz
        2- Locate : Locate'leri pages sayfalarindan dinamik olarak kullaniyoruz
        3- kullanilan Url, aranan kelime, expected icerik, dogru kullanici adi,
           yanlis kullanici adi, yanlis sifre... gibi datalar
     */

    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaCubugu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime") + Keys.ENTER);

        String expected = ConfigReader.getProperty("amazonExpectedIcerik");
        String actual = amazonPage.aramaSonucYazisi.getText();

        Assert.assertTrue(actual.contains(expected));

        Driver.closeDriver();

    }


}
