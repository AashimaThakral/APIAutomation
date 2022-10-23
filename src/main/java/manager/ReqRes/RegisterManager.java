package manager.ReqRes;

import pojo.request.reqRes.RegisterRequest;
import utilities.CommonApi;

public class RegisterManager {

    RegisterRequest registerReq = new RegisterRequest();
    CommonApi apiRequest = new CommonApi();
    
    public void requestBody(String email, String password) {
        registerReq.setEmail(email);
        registerReq.setPassword(password);
    }

    public void registerRequest() {
    }

    public void validateRegisterRequest() {

    }
    
}
