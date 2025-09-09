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
public class CurrentConditions implements Observer, Display {
    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;
    
    public CurrentConditions(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update() {
        float[] weather = weatherData.getWeather();
        this.temperature = weather[0];
        this.humidity = weather[1];
        this.pressure = weather[2];
        display();
    }
    
    @Override
    public void display() {
        System.out.println("\n[Current Conditions Display]");
        System.out.println("Temperatura actual: " + temperature + "°C");
        System.out.println("Humedad actual: " + humidity + "%");
        System.out.println("Presión actual: " + pressure + " hPa");
        
        // Agregar evaluación del clima
        String condition = "";
        if (temperature > 25) {
            condition = "Caluroso";
        } else if (temperature < 15) {
            condition = "Frío";
        } else {
            condition = "Templado";
        }
        System.out.println("Condición: " + condition);
    }
}
