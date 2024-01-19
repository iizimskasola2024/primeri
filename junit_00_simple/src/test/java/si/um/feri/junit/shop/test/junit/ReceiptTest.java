package si.um.feri.junit.shop.test.junit;

import org.junit.jupiter.api.Test;
import si.um.feri.junit.shop.Buyer;
import si.um.feri.junit.shop.Item;
import si.um.feri.junit.shop.Receipt;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class ReceiptTest {

    private static final Logger log = Logger.getLogger(ReceiptTest.class.getName());

	@Test
	public void testRac() {
		log.info("ReceiptTest.testRac();");
        Buyer k = new Buyer("And1", "Andrej");

        Item a = new Item();
        a.setPrice(5);
        a.setName("Artikel1");
        a.setCode("Art1");

        Receipt r = new Receipt(k, a, 0);

        assertEquals(r.getItem().getPrice(),5.0,0.001);
        assertEquals(r.getBuyer().getName(),"Andrej");
        assertEquals(k.getPurchases().size(),1);
        assertEquals(k.getPurchases().get(0),r);
	}

}
