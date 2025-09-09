/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observers;

import Subjects.WeatherData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiantes
 */
public class WeatherStatistics implements Observer, Display {
    private List<Float> temperatureHistory;
    private WeatherData weatherData;
    
    public WeatherStatistics(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.temperatureHistory = new ArrayList<>();
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update() {
        float[] weather = weatherData.getWeather();
        temperatureHistory.add(weather[0]);
        display();
    }
    
    @Override
    public void display() {
        if (temperatureHistory.isEmpty()) {
            System.out.println("\n[Weather Statistics Display]");
            System.out.println("No hay datos para mostrar estadísticas");
            return;
        }
        
        float sum = 0;
        float min = temperatureHistory.get(0);
        float max = temperatureHistory.get(0);
        
        for (float temp : temperatureHistory) {
            sum += temp;
            if (temp < min) min = temp;
            if (temp > max) max = temp;
        }
        
        float average = sum / temperatureHistory.size();
        
        System.out.println("\n[Weather Statistics Display]");
        System.out.println("Estadísticas de Temperatura:");
        System.out.println("Promedio: " + String.format("%.2f", average) + "°C");
        System.out.println("Mínima: " + min + "°C");
        System.out.println("Máxima: " + max + "°C");
        System.out.println("Total de lecturas: " + temperatureHistory.size());
    }
    public void resetStatistics() {
        temperatureHistory.clear();
        System.out.println("Estadísticas reiniciadas");
    }
}
