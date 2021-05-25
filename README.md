# product-catalogue-search-service
It was asked in the Publicis Sapient Technical coding Round. 2 Hours were given and needed to code on their site(quizme) with Camera and Audio On. I write only 3 APIs during the test. Here, I am providing the complete product catalogue search service. 

## DB - H2
```
data.sql has Inserts which will populate Product table on Server Start up.

```
### API-endpoints
```
POST - http://localhost:8080/products/catalogue/create @ResponseBody(#ref Product)
GET - http://localhost:8080/products/catalogue/{productId}
GET - http://localhost:8080/products/catalogue?type={type}
PUT - http://localhost:8080/products/catalogue  @ResponseBody(#ref Product)
DELETE - http://localhost:8080/products/catalogue/{productId}
```

### Product.json
```
{
    "id": 1,
    "productname": "iPhone",
    "type": "Electronics",
    "price": 100000,
    "quantity": 100
}
```

```
I have added Swagger 3: http://localhost:8080/swagger-ui/
You can use Swagger UI to get the API details.
```
