# Shoppingcart

List of Microservices :

- ## productcatalogservice("/shoppingcart/products")
  1. POST -> Adds a product to the repository
  2. GET -> Get list of prosucts from the catalog
  3. GET("/{id}") -> Get product by ID.
  
- ## cartservice("/shoppingcart/cart")
  1. POST -> Add a product(by id from productcatalogservice) to in memory hashmap.
  2. GET -> Get list of all product from the cart
  3. GET("/{id}") -> Get specific product based on id(key in hashmap).
  4. DELETE -> Empties cart by removing all the products from cart.
  5. DELETE("/{id}") -> Removes specific product from the cart.
  
# Port Mapping for Application
 1) ProductCatalogService  8080
 2) CartService  8081
 3) PaymentService 8082
 4) ShippingService 8083
 5) CheckoutService 8084

