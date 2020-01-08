package springtest.data;

import java.math.BigInteger;
import java.util.Date;

public class Order {
    private BigInteger id;
    private BigInteger userId;
    private BigInteger tourId;
    private boolean confirmed;
    private Date timeKey;

    public Order() {}

    public Order(BigInteger userId, BigInteger tourId) {
        this.userId = userId;
        this.tourId = tourId;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public BigInteger getTourId() {
        return tourId;
    }

    public void setTourId(BigInteger tourId) {
        this.tourId = tourId;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Date getTimeKey() {
        return timeKey;
    }

    public void setTimeKey(Date timeKey) {
        this.timeKey = timeKey;
    }
}
