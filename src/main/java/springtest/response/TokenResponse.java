package springtest.response;

public class TokenResponse extends BaseResponse {
    private final String token;

    public TokenResponse(String status, Integer code, String token) {
        super(status, code);
        this.token = token;
    }

    public String getToken() {
        return token;
    }


}
