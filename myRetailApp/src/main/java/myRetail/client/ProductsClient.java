package myRetail.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import myRetail.exceptions.DataNotFoundException;

@Component
public class ProductsClient {

	@Autowired
	private RestTemplate restTemplate;

	public String invokeProductService(String url, String productId) throws DataNotFoundException {
		ResponseEntity<String> response = null;

		// url construction
		url = url + productId
				+ "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

		/* invoking external api */
		try {
			response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);			
		} catch (Exception e) {
			if (e.getMessage().equalsIgnoreCase("404 Not Found")) {
				throw new DataNotFoundException(404, "Data Not found");
			}
		}
		return response.getBody();
	}
}