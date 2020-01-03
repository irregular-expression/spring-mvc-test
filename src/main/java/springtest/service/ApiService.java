package springtest.service;

public interface ApiService extends OrderApi, TourApi, UserApi {
    boolean auth(String login, String password);
}
