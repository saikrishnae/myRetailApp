package myRetail.pojos;

public class PriceRequest {
	String id;
	Price current_price;

	public PriceRequest() {

	}

	public PriceRequest(String id, Price current_price) {
		super();
		this.id = id;
		this.current_price = current_price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Price getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(Price current_price) {
		this.current_price = current_price;
	}
}