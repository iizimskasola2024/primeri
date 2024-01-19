package si.um.feri.junit.shop.test.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import si.um.feri.junit.shop.Buyer;

public class BuyerTest {
	
	@Test
	public void testBuyer() {
		Buyer k = new Buyer("And1", "Andrej");

		assertEquals(k.getName(),"Andrej");
		assertEquals(k.getCode(),"And1");
		assertEquals(k.getPurchases().size(),0);
	}

}
