package Bus_Application;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bus implements Serializable {
    private String busNo;
    private Date fromDate;
    private Date toDate;
    private String from;
    private String to;
    private String arrivalTime;
    private String departTime;
    private int capacity = 52;
    private String busType;
    private String busDriver;
    private boolean[] seats;

    public Bus(String busNo, String fromDate, String toDate, String from, String to, String arrivalTime, String departTime, String busType, String busDriver) {
        this.busNo = busNo;
        try {
            this.fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
            this.toDate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.from = from;
        this.to = to;
        this.arrivalTime = arrivalTime;
        this.departTime = departTime;
        this.busType = busType;
        this.busDriver = busDriver;
        this.seats = new boolean[capacity];
        for (int i = 0; i < capacity; i++) {
            seats[i] = true;
        }
    }

    public String getBusNo() {
        return busNo;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartTime() {
        return departTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getBusType() {
        return busType;
    }

    public String getBusDriver() {
        return busDriver;
    }

    public void setCapacity(int val) {
        capacity = val;
    }

    public boolean bookSeat(int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= capacity) {
            if (seats[seatNumber - 1]) {
                seats[seatNumber - 1] = false;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void displaySeatLayout() {
        System.out.println("Seat Layout:");
        for (int i = 0; i < capacity; i++) {
            if (seats[i]) {
                System.out.print("* ");
            } else {
                System.out.print("# ");
            }
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
    	
        System.out.println();
    }
}
