package app.service;

import app.service.entities.CustomerEntity;
import app.service.entities.Customers;
import app.tools.NameFormat;

import java.time.LocalDate;
import java.util.List;

public class CustomerService {

    private static List<CustomerEntity> customers = Customers.getList();

    public List<CustomerEntity> getCustomers () {
        return customers;
    }

    public void addCustomer(String firstName, String lastName, String email, String address, LocalDate dob) {
        CustomerEntity customer = new CustomerEntity(//
                NameFormat.firstLetterCapital(firstName),//
                NameFormat.firstLetterCapital(lastName),//
                email.toLowerCase(),//
                NameFormat.firstLetterCapital(address),//
                dob);
        customers.add(customer);
    }
}
