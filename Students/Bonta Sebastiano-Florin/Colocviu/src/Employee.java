import java.util.Date;

public class Employee extends Person {
    private Date hireDate;
    private Integer numberOfClients;
    public Employee(Integer id,
                    String name,
                    String phoneNumber,
                    Date hireDate,
                    Integer numberOfClients) {
        super(id, name, phoneNumber);
        this.hireDate = hireDate;
        this.numberOfClients = numberOfClients;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(Integer numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public String getInfo() {
        return super.getInfo() + ", " + hireDate.toString() + ", " +  numberOfClients;
    }

    @Override
    public Boolean isGreater(Object object) {
        if(object instanceof Employee) {
            return ((Employee) object).getNumberOfClients() > numberOfClients;
        }
        return false;
    }


}
