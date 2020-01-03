package springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springtest.response.BaseResponse;
import springtest.response.Response;
import springtest.service.ApiService;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final String sharedKey = "SHARED_KEY";
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 1;
    private static final int AUTH_FAILURE = 102;

    private ApiService apiService;

    @Autowired public void setApiService(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/auth")
    public Response auth(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password) {
        return apiService.auth(login, password) ? new Response(SUCCESS_STATUS, CODE_SUCCESS) :
                                                  new Response(ERROR_STATUS, AUTH_FAILURE);
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
