package springtest.response;

import springtest.data.Tour;

import java.util.List;

public class TourListResponse extends BaseResponse {
    private final List<Tour> tours;

    public TourListResponse(String status, Integer code, List<Tour> tours) {
        super(status, code);
        this.tours = tours;
    }

    public List<Tour> getTours() {
        return tours;
    }

}
