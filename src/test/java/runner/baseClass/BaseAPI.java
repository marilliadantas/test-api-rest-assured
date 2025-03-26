package runner.baseClass;

import io.restassured.RestAssured;

public class BaseAPI {
    public static void baseUrl(String url) {
        RestAssured.baseURI = url;
    }
}