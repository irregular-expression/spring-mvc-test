package springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springtest.data.User;
import springtest.response.Response;
import springtest.response.TokenResponse;
import springtest.service.ApiService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SecureApiController {

    private final String sharedKey = "SHARED_KEY";
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 1;
    private static final int AUTH_FAILURE = 102;

    private ApiService apiService;

    @Autowired public void setApiService(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/current")
    User getCurrent(@AuthenticationPrincipal final User user) {
        return user;
    }

    @GetMapping("/logout")
    boolean logout(@AuthenticationPrincipal final User user) {
        apiService.logout(user);
        return true;
    }

    @GetMapping("/test")
    public Response test() {
        return new Response("secure api is running", CODE_SUCCESS);
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
