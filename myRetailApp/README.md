## myRetail RESTful service

This application has three APIs implemented. All three apis can be accessed at same URL /products/{id}
Ex: http://localhost:8080/products/13860428

# 1. To get product details
This is a GET request and response would be in a json format which contains details like product id, product name, its price along with currency code
We get status '200 OK' when we search for a product that exists if not we get '404 Not Found' with message 'Data Not Found'

# 2. To add a price for a product
This is a POST call and body for it has to be in below json format which is similar to above GET response

{
    "id": "123",
    "current_price": {
        "value": 18.49,
        "currency_code": "AED"
    }
}

We get status as '201 Created' after a successful POST call

# 3. To update a price for a product
This is a PUT call and body for this is same as above POST call.
We get status as '204 No Content' when try to update price for a product which exists. If not we get
'404 Not Found' with message 'Data Not Found'

All three APIs can be tested in any REST client