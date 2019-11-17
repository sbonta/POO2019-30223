public class Room {
    private Integer id;
    private Integer capacity;
    private Double price;
    private Double priceSingle;
    private Boolean singleMode;
    private Client[] clients;
    private Integer clientNumber;

    public Room(Integer id, Integer capacity, Double price, Double priceSingle) {
        this.id = id;
        this.capacity = capacity;
        this.price = price;
        this.priceSingle = priceSingle;
        singleMode = false;
        clients = new Client[Constants.ARRAY_MAX_LENGTH];
        clientNumber = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceSingle() {
        return priceSingle;
    }

    public void setPriceSingle(Double priceSingle) {
        this.priceSingle = priceSingle;
    }

    public Boolean getSingleMode() {
        return singleMode;
    }

    public void setSingleMode(Boolean singleMode) {
        this.singleMode = singleMode;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    public Double getTotalPrice(Integer numberOfDays) {
        if (singleMode) {
            return priceSingle * numberOfDays;
        } else {
            return price * numberOfDays;
        }
    }

    public Double getTotalPrice(Integer numberOfDays, Double discount) {
        if (singleMode) {
            return priceSingle * numberOfDays * (1 - discount);
        } else {
            return price * numberOfDays * (1 - discount);
        }
    }

    public Boolean isFull() {
        if ((1 == clientNumber) && singleMode) {
            return true;
        }

        if (clientNumber.equals(capacity)) {
            return true;
        }

        return false;
    }

    public Boolean isEmpty() {
        return 0 == clientNumber;
    }

    public void cleanRoom() {
        clients = new Client[Constants.ARRAY_MAX_LENGTH];
        clientNumber = 0;
    }

    public void addClient(Client client, Boolean singleMode) {
        clients[clientNumber] = client;
        this.singleMode = singleMode;
    }

    public void deleteClient(Integer clientId) {
        for (int i = 0; i < clientNumber; i++) {
            if(clients[i].getId().equals(clientId)) {
                for(int j = i ; j < clientNumber - 1; j ++) {
                    clients[j] = clients[j + 1];
                }
                return;
            }
        }
    }
}
