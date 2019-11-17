import java.util.Date;

public class Client extends Person {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    public Client(Integer id,
                  String name,
                  String phoneNumber,
                  Integer roomNumber,
                  Date checkIn,
                  Date checkOut) {
        super(id, name, phoneNumber);
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public String getInfo() {
        return super.getInfo() + ", " + roomNumber + ", " + checkIn.toString() + ", " + checkOut.toString();
    }

    @Override
    public Boolean isGreater(Object object) {
        if(object instanceof Client) {
            return ((Client) object).getCheckOut().getTime() - ((Client) object).getCheckIn().getTime() >
                    checkOut.getTime() - checkIn.getTime();
        }

        return false;
    }
}
