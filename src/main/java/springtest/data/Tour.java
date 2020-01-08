package springtest.data;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

public class Tour {
    private BigInteger id;
    private String name;
    private String description;
    private String location;
    private Date startDate;
    private Date endDate;
    private int countLimit;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCountLimit() {
        return countLimit;
    }

    public void setCountLimit(int countLimit) {
        this.countLimit = countLimit;
    }

    public boolean isStarted() {
        Calendar calendar = Calendar.getInstance();
        return startDate.before(calendar.getTime());
    }

    public boolean isEnded() {
        Calendar calendar = Calendar.getInstance();
        return endDate.before(calendar.getTime());
    }
}
