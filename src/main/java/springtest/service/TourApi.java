package springtest.service;

import springtest.data.Tour;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface TourApi {
    List<Tour> getAllTours();
    void addTour(Tour tour);
    void deleteTour(Tour tour);
    void editTour(Tour tour);
    Tour getTourById(BigInteger id);

}
