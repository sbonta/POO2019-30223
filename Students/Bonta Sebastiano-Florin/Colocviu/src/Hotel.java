import java.util.Date;

public class Hotel {
    private Employee[] employees;
    private Client[] clients;
    private Room[] rooms;
    private Integer numberOfEmployees;
    private Integer numberOfClients;
    private Integer numberOfRooms;

    public Hotel() {
        employees = new Employee[Constants.ARRAY_MAX_LENGTH];
        clients = new Client[Constants.ARRAY_MAX_LENGTH];
        rooms = new Room[Constants.ARRAY_MAX_LENGTH];
        numberOfEmployees = 0;
        numberOfClients = 0;
        numberOfRooms = 0;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public Client[] getClients() {
        return clients;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public Integer getNumberOfClients() {
        return numberOfClients;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void addEmployee(Integer id,
                            String name,
                            String phoneNumber,
                            Date hireDate,
                            Integer numberOfClients) {
        Employee employee = new Employee(id,
                name,
                phoneNumber,
                hireDate,
                numberOfClients);
        employees[numberOfEmployees] = employee;
        numberOfEmployees++;
    }

    public void addClient(Integer id,
                          String name,
                          String phoneNumber,
                          Integer roomNumber,
                          Date checkIn,
                          Date checkOut) {
        Client client = new Client(id,
                name,
                phoneNumber,
                roomNumber,
                checkIn,
                checkOut);
        clients[numberOfClients] = client;
        numberOfClients++;
    }

    public void addRoom(Integer id,
                        Integer capacity,
                        Double price,
                        Double priceSingle) {
        Room room = new Room(id,
                capacity,
                price,
                priceSingle);
        rooms[numberOfRooms] = room;
        numberOfRooms++;
    }

    public void showClients() {
        Utils.sort(clients, numberOfClients);
        for (int i = 0; i < numberOfClients; i++) {
            System.out.printf("%s\n", clients[i].getInfo());
        }
    }

    public void showEmployees() {
        Utils.sort(employees, numberOfEmployees);
        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.printf("%s\n", employees[i].getInfo());
        }
    }

    public void showRoomStatistics() {
        Integer numberOfEmptyRooms = 0;
        for(int i = 0 ; i < numberOfRooms ; i ++) {
            if(rooms[i].isEmpty()) {
                numberOfEmptyRooms ++;
            }
        }
        System.out.printf("Number of empty rooms is : %d\nNumber of non-empty rooms is : %d\n",
                numberOfEmptyRooms,
                numberOfRooms - numberOfEmptyRooms);
    }
}
