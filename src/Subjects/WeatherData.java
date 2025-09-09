/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subjects;

import java.util.ArrayList;
import java.util.List;
import Observers.*;
import Observers.Observer;

/**
 *
 * @author Estudiantes
 */
public class WeatherData implements Subject{
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    private float R;
    private float HI;
    
    public WeatherData() {
        observers = new ArrayList<>();
    }
    
    @Override
    public void registerObserver(Observer observer){
        observers.add(observer);
        System.out.println("observer registrado. total: " + observers.size());
    }
    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
        System.out.println("observer removido. total: " + observers.size());
    }
    @Override
    public void notifyObserver(){
        for (Observer observer : observers){
            observer.update();
        }
    }
    
    public float[] getWeather(){
        return new float[]{temperature, humidity,pressure};
    }
    
    public void setWeather(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        
        System.out.println("\n=== NUEVOS DATOS METEOROLÓGICOS ===");
        System.out.println("Temperatura: " + temperature + "°C");
        System.out.println("Humedad: " + humidity + "%");
        System.out.println("Presión: " + pressure + " hPa");
        System.out.println("===================================");
        
        notifyObserver();
    }
    
     public float getTemperature() {
        return temperature;
    }
    
    public float getHumidity() {
        return humidity;
    }
    
    public float getPressure() {
        return pressure;
    }
}
