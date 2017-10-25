package sf.crom.dhawanspringmvc.dhawanspringmvc.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sf.crom.dhawanspringmvc.dhawanspringmvc.domain.Customer;

import java.util.List;



public interface CustomerService {
    public List<Customer> getAllCustomers();

    public void addUpdateCustomer(Customer customer);

    public Customer getCustomerById(Integer id);

    public void deleteCustomerById(Integer id);
}
