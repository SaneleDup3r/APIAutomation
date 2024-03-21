package org.example;

import static  io.restassured.RestAssured.*;
import org.hamcrest.core.IsNull;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


public class APITest {

    //Search By ingredient API's
    @Test
    void SearchByExistingIngredientName(){
        given().get("https://www.thecocktaildb.com/api/json/v1/1/search.php?i=vodka").
                then().statusCode(200).
                log().all();
    }

    @Test
    void SearchByNonExistentIngredientName(){
        given().get("https://www.thecocktaildb.com/api/json/v1/1/search.php?i=derivco").
                then().statusCode(404).
                log().all();
    }

    @Test
    void SearchBySendingAnEmptyInput(){
        given().get("https://www.thecocktaildb.com/api/json/v1/1/search.php?i=").
                then().statusCode(400).
                log().all();
    }

    @Test
    void SearchForNonAlcoholic(){
        given().get("https://www.thecocktaildb.com/api/json/v1/1/search.php?i=celery").
                then().statusCode(200).
                body("ingredients.strAlcohol",hasItem("No")).
                log().all();
    }

    @Test
    void SearchForAlcoholic(){
        given().get("https://www.thecocktaildb.com/api/json/v1/1/search.php?i=Amaretto").
                then().statusCode(200).
                body("ingredients.strAlcohol",hasItem("Yes")).
                body("ingredients.strABV",hasItem("28")).
                log().all();
    }

    //Search By Cocktail Name API's
    @Test
    void SearchByCocktailName(){
        given().get("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=french negroni").
                then().statusCode(200).
                log().all();
    }

    @Test
    void SearchByNonExistentCocktailName(){
        given().get("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=sanele").
                then().statusCode(404).
                assertThat().body("drinks", IsNull.nullValue()).
                log().all();
    }

    @Test
    void SearchByCocktailNameCaseSensitive(){
        given().get("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=FRENCH NEGRONI").
                then().statusCode(200).
                log().all();
    }
}
