package springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springtest.response.TokenResponse;
import springtest.service.ApiService;

import java.util.Optional;

import static springtest.util.Constants.*;

@RestController
@RequestMapping("/api/public")
public class PublicApiController {

    private ApiService apiService;

    @Autowired public void setApiService(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/register")
    public TokenResponse register(@RequestParam("email") final String email, @RequestParam("password") final String password) {
        apiService.register(email, password);
        return login(email, password);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestParam(value = "email") String login, @RequestParam(value = "password") String password) {
        Optional<String> token = apiService.login(login, password);
        return token
                .map(s -> new TokenResponse(SUCCESS_STATUS, CODE_SUCCESS, s))
                .orElseGet(() -> new TokenResponse(ERROR_STATUS, AUTH_FAILURE, null));
    }

}
