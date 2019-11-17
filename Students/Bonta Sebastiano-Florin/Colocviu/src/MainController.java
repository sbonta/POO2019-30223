import java.sql.Date;

public class MainController {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        //Employees

        hotel.addEmployee(1, "Bonta1", "0767826335", Date.valueOf("2019-12-12"), 1);
        hotel.addEmployee(2, "Bonta2", "0767826335", Date.valueOf("2019-12-12"), 4);
        hotel.addEmployee(3, "Bonta3", "0767826335", Date.valueOf("2019-12-12"), 7);
        hotel.addEmployee(4, "Bonta4", "0767826335", Date.valueOf("2019-12-12"), 5);
        hotel.addEmployee(5, "Bonta5", "0767826335", Date.valueOf("2019-12-12"), 22);
        hotel.addEmployee(6, "Bonta6", "0767826335", Date.valueOf("2019-12-12"), 3);

        hotel.showEmployees();

        //Clients

        hotel.addClient(1, "Sebastiano1", "0769367980", 121, Date.valueOf("2019-11-11"), Date.valueOf("2019-12-12"));
        hotel.addClient(2, "Sebastiano2", "0769367980", 131, Date.valueOf("2019-01-11"), Date.valueOf("2019-02-12"));
        hotel.addClient(3, "Sebastiano3", "0769367980", 141, Date.valueOf("2019-01-11"), Date.valueOf("2019-05-12"));
        hotel.addClient(4, "Sebastiano4", "0769367980", 151, Date.valueOf("2019-07-11"), Date.valueOf("2019-09-12"));
        hotel.addClient(5, "Sebastiano5", "0769367980", 161, Date.valueOf("2019-03-11"), Date.valueOf("2019-04-12"));
        hotel.addClient(6, "Sebastiano6", "0769367980", 171, Date.valueOf("2019-01-11"), Date.valueOf("2019-09-12"));

        hotel.showClients();


        //Rooms

        hotel.addRoom(1, 4, 67.70, 85.90);
        hotel.addRoom(2, 2, 77.70, 45.90);
        hotel.addRoom(3, 3, 87.70, 55.90);
        hotel.addRoom(4, 1, 97.70, 65.90);
        hotel.addRoom(5, 2, 17.70, 95.90);
        hotel.addRoom(6, 3, 27.70, 65.90);
        hotel.addRoom(7, 3, 37.70, 25.90);

        hotel.showRoomStatistics();

    }
}
