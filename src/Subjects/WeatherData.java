/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subjects;

import Observers.ObserverInterface;
import java.util.ArrayList;
import java.util.List;
import Observers.*;

/**
 *
 * @author Estudiantes
 */
public class WeatherData implements Subject{
    private List<ObserverInterface> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    private float R;
    private float HI;
    
    public WeatherData() {
        observers = new ArrayList<>();
    }
    
    @Override
    public void registerObserver(ObserverInterface observer){
        observer.add(observer);
        system.out.println("observer registrado. total: " + observers.size());
    }
    @Override
    public void removeObserver(ObserverInterface observer){
        observer.remove(observer);
        system.out.println("observer removido. total: " + observers.size());
    }
    @Override
    public void notifyObserver(){
        for (ObserverInterface observer : observers){
            observers.update();
        }
    }
    
    public float[] getWeather(){
        return new float[]{temperature, humidity,pressure};
    }
    
    public void setWeather(){
    }
}
