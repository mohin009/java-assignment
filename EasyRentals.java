package Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {
    private int id;
    private String name;
    private LocalDate dob;
    private String custType; // p-> Privileged, R-> Regular
    private String gender;
    private String contactNo;
    private String emailId;
    private LocalDate registrationDate;
    private String country;
    private String zone;

    public Customer(int id, String name, LocalDate dob, String custType, String gender, String contactNo, String emailId, LocalDate registrationDate, String country, String zone) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.custType = custType;
        this.gender = gender;
        this.contactNo = contactNo;
        this.emailId = emailId;
        this.registrationDate = registrationDate;
        this.country = country;
        this.zone = zone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCustType() {
    	return custType.equals("P") ? "ER Privileged" : "ER Regular";
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailId() {
    	return emailId != null ? emailId : "Email ID not provided";
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getFormattedRegistrationDate() {
        if (zone.equals("USA")) {
            return registrationDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        } else if (zone.equals("Europe")) {
            return registrationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } else {
            return registrationDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", custType='" + custType + '\'' +
                ", gender='" + gender + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", emailId='" + emailId + '\'' +
                ", registrationDate=" + getFormattedRegistrationDate() +
                ", country='" + country + '\'' +
                ", zone='" + zone + '\'' +
                '}';
    }

//Point-1 print customer data
    public static void printAllCustomers(List<Customer> customers) {
        customers.stream()
                .sorted(Comparator.comparing(Customer::getDob)).forEach(System.out::println);
	}

//Point-2 Discount
	public static void printDiscountedCustomers(List<Customer> customers) {
		customers.stream()
				.filter(c -> c.getRegistrationDate().isBefore(LocalDate.now().minusYears(5)))
				.forEach(c -> {
					double discount = 0.1 * calculateRent(c);
					System.out.printf("%s gets a discount of %.2f%n", c.getName(), discount);
				});
	}


//Point-3(1)
	public static void printRegularCustomersFromChinaAboveAge(List<Customer> customers, int age) {
		customers.stream()
				.filter(c -> c.getCustType().equals("R"))
				.filter(c -> c.getCountry().equals("China"))
				.filter(c -> c.getDob().isBefore(LocalDate.now().minusYears(age)))
				.forEach(System.out::println);
	}

//Point-3(2)
	public static long countCustomersAboveAge(List<Customer> customers, int age) {
		return customers.stream()
				.filter(c -> c.getDob().isBefore(LocalDate.now().minusYears(age)))
				.count();
	}

//Point-3(3)
	public static void printPrivilegedCustomersFromUSA(List<Customer> customers) {
		customers.stream()
				.filter(c -> c.getCustType().equals("P"))
				.filter(c -> c.getCountry().equals("USA"))
				.forEach(System.out::println);
	}

//Pint-4 ER 
	public static void addCustomer(List<Customer> customers, Customer customer) {
		customers.add(customer);
		if (customer.getCustType().equals("P")) {
			customer.setEmailId("ER" + customer.getEmailId());
		}
	}

	private static int calculateRent(Customer customer) {
		// some calculation based on customer data
		return 100;
	}

}
