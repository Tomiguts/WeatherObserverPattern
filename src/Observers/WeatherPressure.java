/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observers;

import Subjects.WeatherData;

/**
 *
 * @author Estudiantes
 */
public class WeatherPressure implements Observer, Display {
    private float pressure;
    private WeatherData weatherData;
    
    
    public WeatherPressure(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update() {
        float[] weather = weatherData.getWeather();
        this.pressure = weather[2]; // Presión es el índice 2
        display();
    }
    
    @Override
    public void display() {
        System.out.println("\n[Weather Pressure Display]");
        System.out.println("Presión atmosférica: " + pressure + " hPa");
        
        String classification = "";
        String alert = "";
        
        if (pressure > 1025) {
            classification = "Alta";
            alert = "Condiciones muy estables";
        } else if (pressure > 1013) {
            classification = "Normal-Alta";
            alert = "Condiciones estables";
        } else if (pressure > 1000) {
            classification = "Normal";
            alert = "Condiciones típicas";
        } else if (pressure > 980) {
            classification = "Baja";
            alert = "Posible inestabilidad";
        } else {
            classification = "Muy Baja";
            alert = "¡ALERTA! Condiciones severas";
        }
        
        System.out.println("Clasificación: Presión " + classification);
        System.out.println("Indicación: " + alert);
        
        double pressureInHg = pressure * 0.02953;
        System.out.println("Equivalencia: " + String.format("%.2f", pressureInHg) + " inHg");
    }
}
