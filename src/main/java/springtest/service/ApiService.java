package springtest.service;

import springtest.data.Order;
import springtest.data.Tour;
import springtest.data.User;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/*
    Описание основного функционала api по ТЗ:

    1) Клиент может авторизоваться в системе
    и делать базовые операции:
    2) просмотр туров,
    3) просмотр заказов,
    4) просмотр своего профиля и его редактирование.
    Клиент может:
    5) забронировать тур на определённые даты, при этом сам тур имеет максимальное количество мест, которое учитывается.
    Клиент может:
    6) просматривать забронированные туры и, например,
    7) делать отмену ранее забронированных туров (учитываем, что нельзя отменить забронированный тур после того как он прошёл).

    Дополнительно реализовать, если будет время:

    8) Возможность регистрации для пользователей (+ хранение паролей в зашифрованном виде).
    Функционал для работы сотрудников агентства:
    9) возможность редактирования туров,
    10) их добавление,
    11) возможность просматривать, подтверждать или отклонять бронирования клиентов.
*/

public interface ApiService {

    //интерфейс авторизации в системе
    Optional<String> login(String username, String password);
    User findByToken(String token);
    void register(String email, String password);
    void logout(User user);

    //получение списка всех доступных туров для просмотра
    List<Tour> getTours();

    //получение списка всех своих заказов
    List<Order> getOrders(BigInteger userId);

    //получение информации о текущем пользователе
    User getUser(BigInteger userId);

    //редактирование профиля пользователя
    void editUser(User user);

    //забронировать тур, если есть свободные места
    boolean createOrder(BigInteger tourId, BigInteger userId);

    //получить список забронированных туров
    List<Tour> getToursWithOrders(BigInteger userId);

    //отменить бронь, если тур ещё не начался
    boolean cancelOrder(Order order);

}