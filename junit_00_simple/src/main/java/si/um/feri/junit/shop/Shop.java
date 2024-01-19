package si.um.feri.junit.shop;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Shop {

	private Map<Item, Integer> itemsAvailable= new Hashtable<>();

	private List<Buyer> buyers=new ArrayList<>();

	private List<Item> items=new ArrayList<>();

	public void addBuyer(Buyer k) {
		buyers.add(k);
	}

	public void addItem(Item a, int units) {
		items.add(a);
		itemsAvailable.put(a, units);
	}

	public void buy(String buyerCode, String itemCode, double discount) {
		Buyer kp = findBuyer(buyerCode);
		Item ar = findItem(itemCode);
		if ((kp == null) || (ar == null)) return;
		new Receipt(kp, ar, discount);
		Integer n = itemsAvailable.get(ar);
		itemsAvailable.put(ar, Integer.valueOf(n.intValue() - 1));
	}

	public Buyer findBuyer(String code) {
		for (Buyer k : buyers)
			if (k.getCode().equals(code)) return k;
		return null;
	}

	public Item findItem(String code) {
		for (Item k : items)
			if (k.getCode().equals(code)) return k;
		return null;
	}

	public int itemsAvailable(String itemCode) {
		Item ar = findItem(itemCode);
		if (ar == null) return 0;
		return itemsAvailable.get(ar).intValue();
	}

}
