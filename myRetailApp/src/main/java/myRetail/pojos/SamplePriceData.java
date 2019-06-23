package myRetail.pojos;

import java.util.HashMap;

public class SamplePriceData {
	static HashMap<String, Price> data = new HashMap<>();

	static {
		data.put("13860428", new Price(13.49, "USD"));
		data.put("15117729", new Price(121.78, "INR"));
		data.put("16483589", new Price(100.00, "EUR"));
		data.put("16696652", new Price(15.23, "SGD"));
		data.put("16752456", new Price(1345.96, "INR"));
		data.put("15643793", new Price(5.69, "AED"));
	}

	public static HashMap<String, Price> getPriceData() {
		return data;
	}

	public static void upsertPriceData(String productId, Price price) {
		data.put(productId, price);		
	}

}
