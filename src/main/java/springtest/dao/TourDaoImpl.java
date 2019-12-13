package springtest.dao;

import org.springframework.stereotype.Repository;
import springtest.data.Tour;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public class TourDaoImpl implements TourDao {
    @Override
    public List<Tour> allTours() {
        return null;
    }

    @Override
    public List<Tour> allToursByName(String name) {
        return null;
    }

    @Override
    public List<Tour> allToursByLocation(String location) {
        return null;
    }

    @Override
    public List<Tour> allToursByDescription(String description) {
        return null;
    }

    @Override
    public List<Tour> allToursInTimePeriod(Date start, Date end) {
        return null;
    }

    @Override
    public void add(Tour tour) {

    }

    @Override
    public void delete(Tour tour) {

    }

    @Override
    public void edit(Tour tour) {

    }

    @Override
    public Tour getById(BigInteger id) {
        return null;
    }
}
