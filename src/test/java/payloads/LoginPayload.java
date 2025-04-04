package payloads;

import com.google.gson.Gson;
import payloads.model.LoginModel;

public class LoginPayload {
    public static String toJson(String email, String password){
        LoginModel login = new LoginModel(email, password);
        return new Gson().toJson(login);
    }
}
