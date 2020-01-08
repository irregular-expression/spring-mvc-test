package springtest.response;

import springtest.data.User;

public class UserResponse extends BaseResponse {
    private final User user;

    public UserResponse(String status, Integer code, User user) {
        super(status, code);
        this.user = user;
    }

    public User getUser() {
        return user;
    }


}
