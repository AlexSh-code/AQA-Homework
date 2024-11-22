import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTests {

    @Test
    public void getRequestTest() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.JSON)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
        .when()
                .get("/get")
        .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));

    }

    @Test
    public void postRawTextTest() {
        String rawText = "Raw text";
        given()
                .baseUri("https://postman-echo.com")
                .header("Content-type", "text/plain")
                .body(rawText)
        .when()
                .post("/post")
        .then()
                .statusCode(200)
                .body("data", equalTo(rawText))
                .log().body();
    }

    @Test
    public void postFormDataTest() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/x-www-form-urlencoded")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
        .when()
                .post("/post")
        .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .log().body();
    }

    @Test
    public void putRequestTest() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body("{\"foo1\":\"bar1\",\"foo2\":\"bar2\"}")
        .when()
                .put("/put")
        .then()
                .statusCode(200)
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .log().body();
    }

    @Test
    public void patchRequestTest() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body("{\"foo1\":\"bar1\",\"foo2\":\"bar2\"}")
        .when()
                .patch("/patch")
        .then()
                .statusCode(200)
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .log().body();  //
    }

    @Test
    public void deleteRequestTest() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
        .when()
                .delete("/delete")
        .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .log().body();
    }

}
