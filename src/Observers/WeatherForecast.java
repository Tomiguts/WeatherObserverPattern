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
public class WeatherForecast implements Observer, Display {
    private float currentPressure = 0.0f;
    private float lastPressure = 0.0f;
    private WeatherData weatherData;
    
    public WeatherForecast(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update() {
        lastPressure = currentPressure;
        float[] weather = weatherData.getWeather();
        currentPressure = weather[2]; 
        display();
    }
    
    @Override
    public void display() {
        System.out.println("\n[Weather Forecast Display]");
        System.out.println("Presión actual: " + currentPressure + " hPa");
        
        if (lastPressure == 0.0f) {
            System.out.println("Pronóstico: Recopilando datos iniciales...");
            return;
        }
        
        String forecast = "";
        if (currentPressure > lastPressure) {
            forecast = "Mejorando el clima";
        } else if (currentPressure < lastPressure) {
            forecast = "Cuidado, se aproxima mal tiempo";
        } else {
            forecast = "Más de lo mismo";
        }
        
        System.out.println("Tendencia de presión: " + 
            (currentPressure > lastPressure ? "Subiendo" : 
             currentPressure < lastPressure ? "Bajando" : "Estable"));
        System.out.println("Pronóstico: " + forecast);
        
        // Pronóstico adicional basado en presión absoluta
        if (currentPressure > 1020) {
            System.out.println("Condiciones: Cielo despejado probable");
        } else if (currentPressure < 1000) {
            System.out.println("Condiciones: Posibles tormentas");
        } else {
            System.out.println("Condiciones: Clima variable");
        }
    }
}
