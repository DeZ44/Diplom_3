package data;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserRest {

    @Step("Создаем нового пользователя по RESTу")
    public Response createUser(UserData user){
        return given().header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("/api/auth/register");
    }

    @Step("Удаляем зарегистрированного пользователя по RESTу")
    public void deleteUser(String accessToken) {
        given()
                .header("Content-type", "application/json")
                .and()
                .header("Authorization", accessToken)
                .when()
                .delete("/api/auth/user")
                .then()
                .statusCode(202);
    }
}
