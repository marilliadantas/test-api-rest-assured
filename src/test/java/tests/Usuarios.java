package tests;

import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;
import requests.UsuariosRequest;
import runner.baseClass.BaseAPI;

import static org.hamcrest.Matchers.greaterThan;

public class Usuarios extends BaseAPI {

    private final UsuariosRequest usuariosRequest = new UsuariosRequest();

    @Test
    @Description("Listar todos os usuários")
    public void listarUsuarios() {
        Response response = usuariosRequest.listarUsuarios();
        response.then()
                .statusCode(HttpStatus.SC_OK)
                .body("usuarios.size()", greaterThan(0))
                .log().body();
    }
}
