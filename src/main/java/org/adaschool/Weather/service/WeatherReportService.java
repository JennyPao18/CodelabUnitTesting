package org.adaschool.Weather.service;

import org.adaschool.Weather.data.WeatherApiResponse;
import org.adaschool.Weather.data.WeatherReport;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherReportService {

    //API KEY obtenida del sitio OpenWeatherMap
    private static final String API_KEY = "f25d7273f9d6601a1a834e83bcb29ba5";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";

    //Constructor vacío
    public WeatherReportService(RestTemplate restTemplateMock) {
    }

    //Método getWeatherReport
    public WeatherReport getWeatherReport(Double latitude, Double longitude) {
        //Si no se especifican todos los datos...
        if(latitude == null || longitude == null){
            //Mostrar mensaje
            System.out.println("Debe especificar todos los datos que se solicitan");
            //Lanzar excepcion
            throw new IllegalArgumentException("Debe especificar todos los datos que se solicitan");
        }
        //Si se especifican los datos correctamente...
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + "?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY;
        WeatherApiResponse response = restTemplate.getForObject(url, WeatherApiResponse.class);

        WeatherReport report = new WeatherReport();
        WeatherApiResponse.Main main = response.getMain();
        report.setTemperature(main.getTemperature());
        report.setHumidity(main.getHumidity());

        //Retornar report
        return report;
    }
}