package myRetail.pojos;

public class Price {
	Double value;
	String currency_code;

	public Price() {
		super();
	}

	public Price(Double value, String currency_code) {
		super();
		this.value = value;
		this.currency_code = currency_code;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}
}