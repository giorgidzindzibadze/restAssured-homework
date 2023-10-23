import Data.Provider;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class restTest {
    @Test(dataProvider = "data", dataProviderClass = Provider.class)
    public void bookTest(String actualAuthor, String author, String isbn) {

        RestAssured
                .given()
                .when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books")
                .then()
                .assertThat()
                .body(actualAuthor, equalTo(author));
    }

    @Test(dataProvider = "data", dataProviderClass = Provider.class)
    public void isbnTest(String actualAuthor, String author, String isbn){
        String response = RestAssured.
                given()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books").asString();
        JsonPath jsonPath = new JsonPath(response);

        String actualIsbn = jsonPath.getString(isbn);

        RestAssured
                .given()
                .when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Book?ISBN=" + actualIsbn)
                .then()
                .assertThat()
                .body("author", equalTo(author));

    }
}
