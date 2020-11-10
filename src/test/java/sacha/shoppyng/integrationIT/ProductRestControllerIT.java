package sacha.shoppyng.integrationIT;

import sacha.shoppyng.cart.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Product Integration Test
 */
@ActiveProfiles("productTest")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductRestControllerIT {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	/**
	 * First test : Add product
	 * @throws Exception
	 */
	@WithMockUser(username = "userTest")
	@Test
	public void firstShouldAddProduct() throws Exception {

		String jsonProduct = getJsonProduct();

		mockMvc.perform(post("/api/product").content(jsonProduct).contentType(APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andReturn();
	}

	/**
	 * Seconf Test : remove product
	 * @throws Exception
	 */
	@WithMockUser(username = "userTest")
	@Test
	public void secondShouldRemoveProduct() throws Exception {
		String jsonProduct = getJsonProduct();
		mockMvc.perform(delete("/api/product").content(jsonProduct).contentType(APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andReturn();
	}

	/**
	 * Third test : Clear user Cart
	 * @throws Exception
	 */
	@WithMockUser(username = "userTest")
	@Test
	public void thirdShouldClearCart() throws Exception {
		mockMvc.perform(delete("/api/product/removeAll").contentType(APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andReturn();
	}

	// TODO ajouter d'autres test
	// TODO Vérifier le retour

	/**
	 * Convert Product object to Json
	 * @return
	 * @throws JsonProcessingException
	 */
	private String getJsonProduct() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Product product = new Product(1L,"product1",10F);
		return mapper.writeValueAsString(product);
	}
}
