package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.Recipe;
import src.exceptions.RecipeException;


public class RecipeTest {

    //Read in recipe price
    String priceString = "2";

    //Read in amt coffee
    String coffeeString = "2";

    //Read in amt milk
    String milkString = "1";

    //Read in amt sugar
    String sugarString = "3";

    //Read in amt chocolate
    String chocolateString = "0";

    @Before
    public void setUp() {

        Recipe newRecipe = new Recipe();
        try {
            newRecipe.setPrice(priceString);
            newRecipe.setAmtCoffee(coffeeString);
            newRecipe.setAmtMilk(milkString);
            newRecipe.setAmtSugar(sugarString);
            newRecipe.setAmtChocolate(chocolateString);

        } catch (RecipeException e) {
            System.out.println(e.getMessage());
        } finally {
            //
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAmtChocolate() {
    }

    @Test
    public void setAmtChocolate() {
    }

    @Test
    public void getAmtCoffee() {
    }

    @Test
    public void setAmtCoffee() {
    }

    @Test
    public void getAmtMilk() {
    }

    @Test
    public void setAmtMilk() {
    }

    @Test
    public void getAmtSugar() {
    }

    @Test
    public void setAmtSugar() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void getPrice() {
    }

    @Test
    public void setPrice() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void testHashCode() {
    }

    @Test
    public void testEquals() {
    }
}