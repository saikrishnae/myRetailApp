package myRetail.services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import myRetail.client.ProductsClient;
import myRetail.exceptions.DataNotFoundException;
import myRetail.pojos.Price;
import myRetail.pojos.PriceRequest;
import myRetail.pojos.ProductApiResponse;
import myRetail.pojos.SamplePriceData;

@Service
public class ProductService {

	@Autowired
	ProductsClient productsClient;

	@Value("${productNameUrl}")
	private String productNameUrl;

	/* method to get product details for given productId */
	public ProductApiResponse getProductDetails(String productId) throws DataNotFoundException {
		String title = null;
		JSONParser parser = new JSONParser();

		/* method to get details from external API */
		String response = productsClient.invokeProductService(productNameUrl, productId);
		if (response != null) {
			try {
				/* retrieving title from response */
				JSONObject responseObject = (JSONObject) parser.parse(response);
				JSONObject productObject = (JSONObject) responseObject.get("product");
				JSONObject itemObject = (JSONObject) productObject.get("item");
				JSONObject productDescObject = (JSONObject) itemObject.get("product_description");
				title = (String) productDescObject.get("title");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		/* mocking price API to get price details for given product id */
		Price price = SamplePriceData.getPriceData().get(productId);

		/* framing response */
		ProductApiResponse productApiResponse = new ProductApiResponse();
		productApiResponse.setId(productId);
		productApiResponse.setName(title);
		productApiResponse.setCurrent_price(price);

		return productApiResponse;
	}

	/* method to add price */
	public void addPrice(PriceRequest input) {
		SamplePriceData.upsertPriceData(input.getId(), input.getCurrent_price());
	}

	/* method to update price */
	public void updatePrice(PriceRequest input) throws DataNotFoundException {

		/* update price only if that productId already exists else return 404 */
		if (SamplePriceData.getPriceData().get(input.getId()) != null)
			SamplePriceData.upsertPriceData(input.getId(), input.getCurrent_price());
		else
			throw new DataNotFoundException(404, "Data Not found");
	}
}