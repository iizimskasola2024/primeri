package si.um.feri.junit.shop.test.junit;

import org.junit.jupiter.api.*;
import si.um.feri.junit.shop.Item;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

	private static final Logger log = Logger.getLogger(ItemTest.class.getName());
	
	@BeforeAll
	public static void beforeAll() {
		log.info("@BeforeClass");
	}

	@BeforeEach
	public void beforeEach() {
		log.info("@Before");
	}
	
	@Test
	public void testItem() throws Exception {
		log.info("ItemTest.testItem();");
		Item a = new Item();
		a.setPrice(5);
		a.setName("Artikel1");
		a.setCode("Art1");
		assertEquals(a.getPrice(),5.0,0.001);
		assertEquals(a.getName(),"Artikel1");
		assertEquals(a.getCode(),"Art1");

		Item aa=null;
		assertThrows(NullPointerException.class,()->aa.getPrice(),"a is null" );
	}

	@Test
	public void testIncPrice() {
		log.info("ItemTest.testIncPrice();");
		Item a = new Item();
		a.setPrice(5);
		a.increasePrice(10);

		assertEquals(a.getPrice(),5.5,0.00001);
	}

	@AfterEach
	public void afterEach() {
		log.info("@AfterEach");
	}

	@AfterAll
	public static void afterAll() {
		log.info("@AfterAll");
	}

}
