package myRetail.pojos;

public class ProductApiResponse {
	String id;
	String name;
	Price current_price;

	public ProductApiResponse() {
		super();
	}

	public ProductApiResponse(String id, String name, Price current_price) {
		super();
		this.id = id;
		this.name = name;
		this.current_price = current_price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Price getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(Price current_price) {
		this.current_price = current_price;
	}
}
