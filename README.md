# Simple-Java-Weather-App

## Quick Start

### Dependencies

- Maven 3 (v3.3.9)
- Java 8 (v1.8.0_152)

### How to Run

1. Run the backend API

`mvn clean package exec:java`

This will run the backend on http://localhost:8080/simplejavaweather/ 

2. Open up the index.html in src/main/webapp on a modern browser that supports ECMAScript6.

3. Enter a location to receive the weather data for that area. (TODO)


## TODO

- [x] Setup of Jersey API
- [x] Enable CORS on backend API
- [x] Create index page with form to submit to the backend API
- [x] Install Guice dependency for dependency injection
- [x] Install marshaller dependency to/from JSON
- [x] Retrieve weather data from OpenWeatherMap.org
- [x] Get City ID from OpenWeatherMap.org
- [x] Get City Weather using City ID from OpenWeatherMap.org
- [x] Parse weather data from OpenWeatherMap.org to extract overall weather description
- [x] Parse weather data from OpenWeatherMap.org to extract temperature in Celsius
- [x] Parse weather data from OpenWeatherMap.org to extract sunrise times
- [x] Parse weather data from OpenWeatherMap.org to extract sunset times
- [x] Convert times to 12 hour format
- [x] Convert temperature to Fahrenheit
- [x] Return all data via API endpoint /weather
- [ ] Extract server port and app variables into environment vars or configuration files
