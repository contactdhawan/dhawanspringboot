package sf.crom.dhawanspringmvc.dhawanspringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sf.crom.dhawanspringmvc.dhawanspringmvc.domain.Customer;
import sf.crom.dhawanspringmvc.dhawanspringmvc.service.CustomerService;

@Controller
public class CustomerController {

    public CustomerService getCustomerService() {
        return customerService;
    }

    @Autowired
    CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @RequestMapping("/customer/new")
    public String addNewCustomer(Model model) {
        model.addAttribute("customerobj", new Customer());
        return "customer";
    }

    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public String addNewCustomer(Customer customerobj, Model model) {
        customerService.addUpdateCustomer(customerobj);
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @RequestMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customerobj", customerService.getCustomerById(id));
        return "customer";
    }

    @RequestMapping("/customer/delete/{id}")
    public String deleteCustomer(Model model, @PathVariable Integer id) {
        customerService.deleteCustomerById(id);
        model.addAttribute("customer", customerService.getAllCustomers());
        return "redirect:/customers";
    }

}
