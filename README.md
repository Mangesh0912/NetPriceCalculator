Steps to Run the Project:

1.) Checkout the code from Git https://github.com/Mangesh0912/NetPriceCalculator
2.) Make sure if Maven is installed on your system and run the following maven command to spin up the embedded server in spring boot:
   ./mvnw spring-boot:run
3.) Sample Request/ Response using curl or Postman:
      Request -> curl -X GET "http://localhost:8080/calculator/netprice?grossPrice=2000&countryIso=DE"
      Response ->{"netPrice":1620.0}

      Request -> curl -X GET "http://localhost:8080/calculator/netprice?grossPrice=2000&countryIso=EG"  
      Response -> {"timestamp":"2023-01-29T12:49:38.381+00:00","status":404,"error":"Not Found","message":"Country ISO Not Found","path":"/calculator/netprice"}
