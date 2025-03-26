package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.Test;
import requests.LoginRequest;
import runner.baseClass.BaseAPI;

import static org.hamcrest.CoreMatchers.equalTo;

@Slf4j
@Feature("Login")
public class Login extends BaseAPI {

    private final LoginRequest loginRequest = new LoginRequest();

    @Test
    @Description("Login com credenciais válidas")
    public void loginSucesso() {
        Response response = loginRequest.logar("silo@qa.com.br", "teste");
        response.then()
                .statusCode(HttpStatus.SC_OK)
                .body("message", equalTo("Login realizado com sucesso"))
                .log().body();
    }

    @Test
    @Description("Login com credenciais inválidas")
    public void loginInvalido() {
        Response response = loginRequest.logar("teste@teste.com", "teste");
        response.then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .body("message", equalTo("Email e/ou senha inválidos"))
                .log().body();
    }
}