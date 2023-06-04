package tests.day15_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C01_PagesFirstTest {

    @Test
    public void amazonTest(){

        // amazon ana sayfaya gidelim
        Driver.getDriver().get("https://www.amazon.com");

        // Nutella icin arama yapalim
        // Arama cubugunun locate'i page sayfasinda
        // POM'de pages sayfasindaki lacate'lere erismek icin
        // pages sayfalarindan bir obje olusturulur.

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaCubugu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin Nutella icerdigini test edelim
        String actual = amazonPage.aramaSonucYazisi.getText();
        String expected = "Nutella";
        Assert.assertTrue(actual.contains(expected));

        // sayfayi kapatalim
        Driver.closeDriver();
    }
}
