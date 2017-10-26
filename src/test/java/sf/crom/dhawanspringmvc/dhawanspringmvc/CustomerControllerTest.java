package sf.crom.dhawanspringmvc.dhawanspringmvc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sf.crom.dhawanspringmvc.dhawanspringmvc.controller.CustomerController;
import sf.crom.dhawanspringmvc.dhawanspringmvc.domain.Customer;
import sf.crom.dhawanspringmvc.dhawanspringmvc.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class CustomerControllerTest {
    MockMvc mockMvc;

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        //customerController = new CustomerController();
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

    }

    @Test
    public void testGetAllCustomers() throws Exception {

        List<Customer> customersobj = new ArrayList<>();
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        customersobj.add(c1);
        customersobj.add(c2);

        when(customerService.getAllCustomers()).thenReturn(customersobj);

        mockMvc.perform(get("/customers/"))
                .andExpect(status().isOk())
                .andExpect(view().name("customers"))
                .andExpect(MockMvcResultMatchers.model().attribute("customers",hasSize(2)));
    }

    @Test
    public void testAddNewCustomer() throws Exception {
        mockMvc.perform(get("/customer/new/"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer"))
                .andExpect(model().attribute("customerobj", instanceOf(Customer.class)));
    }

    /*@Test
    public void testAddNewCustomerUpdate() throws Exception{
        mockMvc.perform(post("/customer/updateCustomer/"))
                .andExpect(view().name("customers"));
    }*/
}
