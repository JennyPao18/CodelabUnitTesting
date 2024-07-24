package org.adaschool.Weather.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class WeatherReportServiceTest {
    //Objeto Mock
    @Mock
    private RestTemplate restTemplateMock;

    //Instancia de la clase WeatherReportService
    WeatherReportService reporte = new WeatherReportService(restTemplateMock);

    //******************************************************

    //Test que evalúa qué pasa si se especifican todos los datos correctamente
    @Test
    public void testWithoutProblems(){
        reporte.getWeatherReport(16.2, 15.23);
        System.out.println("Reporte enviado correctamente");
    }

    //******************************************************

    //Test que evalúa qué pasa si no se especifica la latitud
    @Test
    public void testNoLatitude(){
        assertThrows(IllegalArgumentException.class, () -> {
            reporte.getWeatherReport(null, 15.23);
        });
    }

    //******************************************************

    //Test que evalúa qué pasa si no se especifica la longitud
    @Test
    public void testNoLongitude(){
        assertThrows(IllegalArgumentException.class, () -> {
            reporte.getWeatherReport(16.2, null);
        });
    }

    //******************************************************

    //Test que evalúa qué pasa si no se especifica ningun dato
    @Test
    public void testNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            reporte.getWeatherReport(null, null);
        });
    }
}
