/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observers;

import Subjects.WeatherData;

/**
 *
 * @author Estudiantes
 * 
 * 
 * muchas tareas repetitivas de este codigo en concreto se crearon con ayuda de la IA para ahorrar tiempo
 * 
 * 
 */
public class WeatherHeatIndex implements Observer, Display {
    private float temperature; 
    private float humidity;    
    private WeatherData weatherData;
    
    
    private static final double C1 = -8.78469475556;
    private static final double C2 = 1.61139411;
    private static final double C3 = 2.33854883889;
    private static final double C4 = -0.14611605;
    private static final double C5 = -0.012308094;
    private static final double C6 = -0.0164248277778;
    private static final double C7 = 2.211732e-3;
    private static final double C8 = 7.2546e-4;
    private static final double C9 = -3.582e-6;
    

    public WeatherHeatIndex(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update() {
        float[] weather = weatherData.getWeather();
        this.temperature = weather[0]; 
        this.humidity = weather[1];    
        display();
    }
    
    @Override
    public void display() {
        System.out.println("\n[Weather Heat Index Display]");
        System.out.println("Temperatura: " + temperature + "°C (" + celsiusToFahrenheit(temperature) + "°F)");
        System.out.println("Humedad relativa: " + humidity + "%");
        
        
        double heatIndexF = calculateHeatIndex(temperature, humidity);
        double heatIndexC = fahrenheitToCelsius(heatIndexF);
        
        System.out.println("Índice de Calor: " + String.format("%.1f", heatIndexC) + "°C (" + 
                          String.format("%.1f", heatIndexF) + "°F)");
        
        
        String riskLevel = getRiskLevel(heatIndexF);
        System.out.println("Nivel de Riesgo: " + riskLevel);
        
        
        displayRecommendations(heatIndexF);
    }
    

    private double calculateHeatIndex(double tempC, double humidity) {
        
        double tempF = celsiusToFahrenheit(tempC);
        
        
        if (tempF < 80.0) {
            return tempF;
        }
        
        
        if (humidity < 13.0 && tempF >= 80.0 && tempF <= 112.0) {
            double adjustment = ((13.0 - humidity) / 4.0) * Math.sqrt((17.0 - Math.abs(tempF - 95.0)) / 17.0);
            return tempF - adjustment;
        }
        
        
        double T = tempF;
        double R = humidity;
        
        double heatIndex = C1 + 
                          (C2 * T) + 
                          (C3 * R) + 
                          (C4 * T * R) + 
                          (C5 * T * T) + 
                          (C6 * R * R) + 
                          (C7 * T * T * R) + 
                          (C8 * T * R * R) + 
                          (C9 * T * T * R * R);
        
        
        if (humidity > 85.0 && tempF >= 80.0 && tempF <= 87.0) {
            double adjustment = ((humidity - 85.0) / 10.0) * ((87.0 - tempF) / 5.0);
            heatIndex += adjustment;
        }
        
        return heatIndex;
    }
    

    private String getRiskLevel(double heatIndexF) {
        if (heatIndexF < 80) {
            return "BAJO - Condiciones normales";
        } else if (heatIndexF < 90) {
            return "PRECAUCIÓN - Posible fatiga con exposición prolongada";
        } else if (heatIndexF < 105) {
            return "CUIDADO EXTREMO - Posible insolación y calambres";
        } else if (heatIndexF < 130) {
            return "PELIGRO - Insolación y calambres muy probables";
        } else {
            return "PELIGRO EXTREMO - Insolación inminente";
        }
    }
    

    private void displayRecommendations(double heatIndexF) {
        System.out.println("Recomendaciones:");
        
        if (heatIndexF < 80) {
            System.out.println("• Actividad normal al aire libre");
        } else if (heatIndexF < 90) {
            System.out.println("• Manténgase hidratado");
            System.out.println("• Tome descansos en actividades prolongadas");
        } else if (heatIndexF < 105) {
            System.out.println("• Evite actividad física intensa");
            System.out.println("• Beba abundantes líquidos");
            System.out.println("• Busque sombra frecuentemente");
        } else if (heatIndexF < 130) {
            System.out.println("• ¡EVITE el ejercicio al aire libre!");
            System.out.println("• Permanezca en lugares con aire acondicionado");
            System.out.println("• Hidratación constante");
        } else {
            System.out.println("• ¡EMERGENCIA! Evite cualquier actividad exterior");
            System.out.println("• Busque refugio inmediatamente");
            System.out.println("• Monitoree signos de insolación");
        }
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }
    
    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
}
