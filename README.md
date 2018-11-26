# tomee-mp-rest-client-starter-project
## Run the test that contains the MicroProfile Rest Client Demo

        mvn clean test
        
Output:
        
        Results :
        
        Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
        
        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------

        
## Run only the movie microservice
        
        mvn clean install tomee:run
  
Test the microservice using curl:

        curl -v  http://localhost:8080/tomee-mp-rest-client-starter-project/api/catalog
        
Output
     
        *   Trying ::1...
        * TCP_NODELAY set
        * Connected to localhost (::1) port 8080 (#0)
        > GET /tomee-mp-rest-client-starter-project/api/catalog HTTP/1.1
        > Host: localhost:8080
        > User-Agent: curl/7.54.0
        > Accept: */*
        > 
        < HTTP/1.1 200 
        < Date: Mon, 26 Nov 2018 22:44:12 GMT
        < Content-Type: application/json
        < Content-Length: 2
        < Server: Apache TomEE
        < 
        * Connection #0 to host localhost left intact
        ok        