package requests;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import payloads.LoginPayload;

import static io.restassured.RestAssured.given;

public class LoginRequest {
    private final String PATH_LOGIN = "https://serverest.dev/login";

    @Step("Realizar login - POST")
    public Response logar(String email, String password) {
        return given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .body(LoginPayload.toJson(email, password))
                .post(PATH_LOGIN);
    }
}
