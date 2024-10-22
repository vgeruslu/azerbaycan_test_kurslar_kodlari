package cucumber_steps;
import bizimKod.Əlaqə;
import bizimKod.ƏlaqəNəzarətçisi;

import io.cucumber.java.az.Ohalda;
import io.cucumber.java.az.Tutaqki;
import io.cucumber.java.az.Və;
import io.cucumber.java.az.Əgər;

import static org.junit.jupiter.api.Assertions.*;

public class AddımTərifləri {
    @Tutaqki("İstifadəçinin indiyə qədər {int} qeydiyyatdan keçmiş kontaktı var")
    public void i̇stifadəçininIndiyəQədərQeydiyyatdanKeçmişKontaktıVar(int neçəDənəVar) {
        ƏlaqəNəzarətçisi.istifadəçininƏlaqələri.clear();
        for (int i = 0; i < neçəDənəVar; i++)
            ƏlaqəNəzarətçisi.əlaqəƏlavəEt("random"+(i+1));
    }

    @Əgər("İstifadəçi {string} adlı yeni kontakt əlavə etsə")
    public void i̇stifadəçiAdlıYeniKontaktƏlavəEdir(String kontaktAdı) {
        //Əlaqə yeniƏlaqə = new Əlaqə(kontaktAdı);
        ƏlaqəNəzarətçisi.əlaqəƏlavəEt(kontaktAdı);
    }

    @Ohalda("Əlaqə siyahısında {string} adlı kontakt var")
    public void əlaqəSiyahısındaAdlıKontaktVar(String kontaktAdı) {
        assertTrue(ƏlaqəNəzarətçisi.istifadəçininƏlaqələri.contains(kontaktAdı));
    }

    @Və("Əlaqə siyahısında {int} dənə qeyd var")
    public void əlaqəSiyahısındaQeydVar(int qeydDənə) {
        assertEquals(qeydDənə, ƏlaqəNəzarətçisi.istifadəçininƏlaqələri.size());

    }

    @Əgər("İstifadəçi {string} adlı kontakti silir")
    public void i̇stifadəçiAdlıKontaktiSilir(String silinəcəkƏlaqəİsmi) {
        ƏlaqəNəzarətçisi.əlaqəSil(silinəcəkƏlaqəİsmi);
    }

    @Ohalda("Əlaqə siyahısında {string} adlı kontakt yox")
    public void əlaqəSiyahısındaAdlıKontaktYox(String kontaktAdı) {
        assertFalse(ƏlaqəNəzarətçisi.istifadəçininƏlaqələri.contains(kontaktAdı));
    }

    /*
    @Given("I have <opening balance> beer cans")
    public void iHaveOpeningBalanceBeerCans() {
        
    }

    @And("I have drunk <processed> beer cans")
    public void iHaveDrunkProcessedBeerCans() {
        
    }

    @When("I go to my fridge")
    public void iGoToMyFridge() {
        
    }

    @Then("I should have <in stock> beer cans")
    public void iShouldHaveInStockBeerCans() {
    }*/
}
