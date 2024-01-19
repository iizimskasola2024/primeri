package si.um.feri.junit.shop;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
	
	public Buyer(String k, String i) {
		purchases = new ArrayList<>();
		code = k;
		name = i;
	}

	private List<Receipt> purchases;

	private String name;

	private String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Receipt> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Receipt> purchases) {
		this.purchases = purchases;
	}

}
