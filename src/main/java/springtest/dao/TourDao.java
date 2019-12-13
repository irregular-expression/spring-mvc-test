package springtest.dao;

import springtest.data.Tour;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface TourDao {
    List<Tour> allTours();
    List<Tour> allToursByName(String name);
    List<Tour> allToursByLocation(String location);
    List<Tour> allToursByDescription(String description);
    List<Tour> allToursInTimePeriod(Date start, Date end);
    void add(Tour tour);
    void delete(Tour tour);
    void edit(Tour tour);
    Tour getById(BigInteger id);

}
