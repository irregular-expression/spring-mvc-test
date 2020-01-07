package springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springtest.response.Response;
import springtest.response.TokenResponse;
import springtest.service.ApiService;

import java.util.Optional;

@RestController
@RequestMapping("/api/public")
public class PublicApiController {

    private final String sharedKey = "SHARED_KEY";
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 1;
    private static final int AUTH_FAILURE = 102;

    private ApiService apiService;

    @Autowired public void setApiService(ApiService apiService) {
        this.apiService = apiService;
    }


    @PostMapping("/register")
    TokenResponse register(@RequestParam("email") final String email, @RequestParam("password") final String password) {
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

    @GetMapping("/test")
    public Response test() {
        return new Response("api is running", CODE_SUCCESS);
    }


    /*
    @PostMapping("/pay")
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {

        final BaseResponse springtest.response;

        if (sharedKey.equalsIgnoreCase(key)) {
            int userId = request.getUserId();
            String itemId = request.getItemId();
            double discount = request.getDiscount();
            // Process the request
            // ....
            // Return success springtest.response to the client.
            springtest.response = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            springtest.response = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        return springtest.response;
    }
    */
}
