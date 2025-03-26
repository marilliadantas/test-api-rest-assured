package requests;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsuariosRequest {
    private final String PATH_USUARIOS = "https://serverest.dev/usuarios";

    @Step("Listar usuários - GET")
    public Response listarUsuarios() {
        return given()
                .header("Accept", "application/json")
                .when()
                .get(PATH_USUARIOS)
                .then()
                .extract().response();
        }
    }