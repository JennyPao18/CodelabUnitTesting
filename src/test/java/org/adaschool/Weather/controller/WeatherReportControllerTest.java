package org.adaschool.Weather.controller;

import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class WeatherReportControllerTest {
    //Objeto Mock
    @Mock
    private WeatherReportService weatherReportServiceMock;

    //******************************************************

    //Test que evalúa qué pasa si se especifican todos los datos correctamente
    @Test
    public void testWithoutProblems(){
        WeatherReportController reporte = new WeatherReportController(weatherReportServiceMock);
        reporte.getWeatherReport(16.2, 15.23);
        System.out.println("Reporte enviado correctamente");
    }

    //******************************************************

    //Test que evalúa qué pasa si no se especifica la latitud
    @Test
    public void testNoLatitude(){
        WeatherReportController reporte = new WeatherReportController(weatherReportServiceMock);
        reporte.getWeatherReport(null, 15.23);
        verify(weatherReportServiceMock, times(0)).getWeatherReport(anyDouble(), anyDouble());
    }

    //******************************************************

    //Test que evalúa qué pasa si no se especifica la longitud
    @Test
    public void testNoLongitude(){
        WeatherReportController reporte = new WeatherReportController(weatherReportServiceMock);
        reporte.getWeatherReport(16.2, null);
        verify(weatherReportServiceMock, times(0)).getWeatherReport(anyDouble(), anyDouble());
    }

    //******************************************************

    //Test que evalúa qué pasa si no se especifica ningun dato
    @Test
    public void testNull(){
        WeatherReportController reporte = new WeatherReportController(weatherReportServiceMock);
        reporte.getWeatherReport(null, null);
        verify(weatherReportServiceMock, times(0)).getWeatherReport(anyDouble(), anyDouble());
    }
}
