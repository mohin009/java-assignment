import java.time.LocalDate;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private LocalDate dob;
    private String custType;
    private String gender;
    private String contactNo;
    private String emailId;
    private LocalDate registrationDate;
    private String country;
    private String zone;
    
    public Customer(List<Object> values) {
        this.id = (int) values.get(0);
        this.name = (String) values.get(1);
        this.dob = (LocalDate) values.get(2);
        this.custType = (String) values.get(3);
        this.gender = (String) values.get(4);
        this.contactNo = (String) values.get(5);
        this.emailId = (String) values.get(6);
        this.registrationDate = (LocalDate) values.get(7);
        this.country = (String) values.get(8);
        this.zone = (String) values.get(9);
    }

    // getters and setters
}


List<Object> values = Arrays.asList(1, "John Doe", LocalDate.of(1990, 5, 1), "Gold", "Male", "1234567890", "johndoe@example.com", LocalDate.now(), "USA", "EST");
Customer customer = new Customer(values);
