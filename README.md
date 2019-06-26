# Simple-Java-Weather-App

## How to Use

1. Run the backend API

`mvn clean package exec:java`

This will run the backend on http://localhost:8080/simplejavaweather/ 

2. Open up the index.html in src/main/webapp on a modern browser that supports ECMAScript6.

3. Enter a location to receive the weather data for that area. (TODO)


## TODO

- [x] Setup of Jersey API
- [x] Enable CORS on backend API
- [x] Create index page with form to submit to the backend API
- [ ] Install Guice dependency for dependency injection
- [ ] Install marshaller dependency to/from JSON
- [ ] Retrieve weather data from OpenWeatherMap.org
- [ ] Get City ID from OpenWeatherMap.org
- [ ] Get City Weather using City ID from OpenWeatherMap.org
- [ ] Parse weather data from OpenWeatherMap.org to extract overall weather description
- [ ] Parse weather data from OpenWeatherMap.org to extract temperature in Celsius
- [ ] Parse weather data from OpenWeatherMap.org to extract sunrise times
- [ ] Parse weather data from OpenWeatherMap.org to extract sunset times
- [ ] Convert times to 12 hour format
- [ ] Convert temperature to Fahrenheit
- [ ] Return all data via API endpoint /weather
- [ ] Extract server port and app variables into environment vars or configuration files
