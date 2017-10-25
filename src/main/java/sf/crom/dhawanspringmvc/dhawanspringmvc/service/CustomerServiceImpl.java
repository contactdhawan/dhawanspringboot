package sf.crom.dhawanspringmvc.dhawanspringmvc.service;

import org.springframework.stereotype.Service;
import sf.crom.dhawanspringmvc.dhawanspringmvc.domain.Customer;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    HashMap<Integer, Customer> customers;

    CustomerServiceImpl() {
        init();
    }

    public void init() {
        customers = new HashMap<>();
        Customer c1 = new Customer();
        c1.setId(1);
        c1.setAddress1("717 Arcadia Dr");
        c1.setAddress2("APT #2");
        c1.setCity("Bloomington");
        c1.setEmail("contactdhawan@gmail.com");
        c1.setFirstName("Neeraj");
        c1.setLastName("Dhawan");
        c1.setPhoneNumber("8032691522");
        c1.setState("IL");
        c1.setCity("Bloomington");
        c1.setZipcode(61704);

        Customer c2 = new Customer();
        c2.setId(2);
        c2.setAddress1("717 Arcadia Dr");
        c2.setAddress2("APT #2");
        c2.setCity("Bloomington");
        c2.setEmail("contactdhawan@gmail.com");
        c2.setFirstName("Anirudh");
        c2.setLastName("Dhawan");
        c2.setPhoneNumber("8032691522");
        c2.setState("IL");
        c2.setCity("Bloomington");
        c2.setZipcode(61704);



        customers.put(1, c1);
        customers.put(2, c2);
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void addUpdateCustomer(Customer customer) {
        if (customer != null) {
            if (customer.getId() == null || customer.getId().equals("")) {
                customer.setId(getNextId());
            }
            customers.put(customer.getId(), customer);
            System.out.println("customer.getId()" + customer.getId());
            System.out.println("customers.size() " + customers.size());

        } else {
            throw new RuntimeException("Customer cannot be null");
        }
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customers.remove(id);
    }

    public int getNextId() {
        return Collections.max(customers.keySet()) + 1;
    }
}
