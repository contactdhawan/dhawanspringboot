package sf.crom.dhawanspringmvc.dhawanspringmvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sf.crom.dhawanspringmvc.dhawanspringmvc.controller.IndexController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DhawanspringmvcApplicationTests {

	MockMvc mockmvc;
	IndexController indexController;

	@Before
	public void setup(){
		indexController = new IndexController();
		mockmvc = MockMvcBuilders.standaloneSetup(indexController).build();
	}

	@Test
	public void contextLoads() throws Exception {
		mockmvc.perform(get("/")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.view().name("index"));
	}

}
