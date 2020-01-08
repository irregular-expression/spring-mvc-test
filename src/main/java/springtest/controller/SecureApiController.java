package springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import springtest.data.Order;
import springtest.data.User;
import springtest.response.OrderListResponse;
import springtest.response.Response;
import springtest.response.TourListResponse;
import springtest.response.UserResponse;
import springtest.service.ApiService;

import java.math.BigInteger;

import static springtest.util.Constants.*;

@RestController
@RequestMapping("/api")
public class SecureApiController {

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

    @GetMapping("/tours")
    public TourListResponse tours() {
        return new TourListResponse(SUCCESS_STATUS, CODE_SUCCESS, apiService.getTours());
    }

    @GetMapping("/user/orders")
    public OrderListResponse userOrders(Authentication auth) {
        User user = (User) auth.getPrincipal();
        return new OrderListResponse(SUCCESS_STATUS, CODE_SUCCESS, apiService.getOrders(user.getId()));
    }

    @GetMapping("/user/tours")
    public TourListResponse toursWithOrders(Authentication auth) {
        User user = (User) auth.getPrincipal();
        return new TourListResponse(SUCCESS_STATUS, CODE_SUCCESS, apiService.getToursWithOrders(user.getId()));
    }

    @GetMapping("/user")
    public UserResponse user(Authentication auth) {
        User user = (User) auth.getPrincipal();
        return new UserResponse(SUCCESS_STATUS, CODE_SUCCESS, apiService.getUser(user.getId()));
    }

    @PostMapping("/user")
    public Response user(@RequestBody User user) {
        apiService.editUser(user);
        return new Response(SUCCESS_STATUS, CODE_SUCCESS);
    }

    @PostMapping("/user/order")
    public Response createOrder(@RequestParam("tourId") final BigInteger tourId, @RequestParam("userId") final BigInteger userId) {
        return apiService.createOrder(tourId, userId) ?
               new Response(SUCCESS_STATUS, CODE_SUCCESS) :
               new Response(ERROR_STATUS, CREATE_ORDER_FAILURE);
    }

    @PostMapping("/user/cancel")
    public Response cancelOrder(@RequestBody final Order order) {
        return apiService.cancelOrder(order) ?
                new Response(SUCCESS_STATUS, CODE_SUCCESS) :
                new Response(ERROR_STATUS, CANCEL_ORDER_FAILURE);
    }



}
