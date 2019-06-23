package myRetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import myRetail.exceptions.DataNotFoundException;
import myRetail.pojos.PriceRequest;
import myRetail.pojos.ProductApiResponse;
import myRetail.services.ProductService;

@RestController
public class ProductsController {

	@Autowired
	ProductService productService;

	/* api to get product details */
	@GetMapping(value = "/products/{id}")
	public ResponseEntity<?> getProductsById(@PathVariable(value = "id") String productId) {
		try {
			return new ResponseEntity<ProductApiResponse>(productService.getProductDetails(productId), HttpStatus.OK);
		} catch (DataNotFoundException e) {
			return new ResponseEntity<String>(e.getErrorMessage(), HttpStatus.NOT_FOUND);
		}
	}

	/* api to add price */
	@PostMapping(value = "/products/{id}", consumes = "application/json")
	public ResponseEntity<?> addPrice(@RequestBody PriceRequest input, @PathVariable(value = "id") String productId) {
		productService.addPrice(input);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/* api to update price */
	@PutMapping(value = "/products/{id}", consumes = "application/json")
	public ResponseEntity<?> updatePrice(@RequestBody PriceRequest input,
			@PathVariable(value = "id") String productId) {
		try {
			productService.updatePrice(input);
		} catch (DataNotFoundException e) {
			return new ResponseEntity<String>(e.getErrorMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}