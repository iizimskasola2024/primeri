package si.um.feri.junit.shop.test.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import si.um.feri.junit.shop.Item;
import si.um.feri.junit.shop.Buyer;
import si.um.feri.junit.shop.Shop;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {

	private static final Logger log = Logger.getLogger(ShopTest.class.getName());
	
	@BeforeEach
	public void setUp() {
		p=new Shop();
    	p.addItem(new Item("0","Bicycle",100), 3);
    	p.addItem(new Item("1","Bread",1.5), 10);
    	p.addItem(new Item("2","Table",52), 2);
    	
    	p.addBuyer(new Buyer("0","Luka"));
    	p.addBuyer(new Buyer("1","Bostjan"));
    	p.addBuyer(new Buyer("2","Marjan"));
    	p.addBuyer(new Buyer("3","Marko"));
	}

	private Shop p;
	
	@Test
	public void testShp() {
		log.info("ShopTest.testShp();");

    	assertEquals(p.itemsAvailable("0"),3);
    	assertEquals(p.itemsAvailable("1"),10);
    	assertEquals(p.itemsAvailable("2"),2);
    	assertEquals(p.itemsAvailable("20"),0);
    	
    	p.buy("0", "0", 10);
    	
    	assertFalse(p.findBuyer("0").getPurchases().get(0).getFullPrice()<100);
    	assertEquals(p.itemsAvailable("0"),2);
	}

}
