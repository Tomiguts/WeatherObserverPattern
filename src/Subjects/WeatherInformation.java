/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Subjects;

import Observers.CurrentConditions;
import Observers.WeatherForecast;
import Observers.WeatherPressure;
import Observers.WeatherStatistics;

/**
 *
 * @author Estudiantes
 * 
 * muchas de las tareas repetitivas como los textos y su estructura fueron hechos con ayuda de la IA
 * esto para ahorrar tiempo y poder visualizar de mejor forma el patron observer
 * 
 */
public class WeatherInformation {
    public static void main(String[] args) {
        System.out.println("=== DEMO PATRÓN OBSERVER BASADO EN UML ===\n");
        
        // Crear el Subject (WeatherData)
        WeatherData weatherData = new WeatherData();
        
        // Crear los diferentes displays como se muestra en el UML
        CurrentConditions currentConditions = new CurrentConditions(weatherData);
        WeatherStatistics weatherStatistics = new WeatherStatistics(weatherData);
        WeatherForecast weatherForecast = new WeatherForecast(weatherData);
        WeatherPressure weatherPressure = new WeatherPressure(weatherData);
        
        System.out.println("--- TODOS LOS DISPLAYS REGISTRADOS ---");
        System.out.println("Total de observers: 4");
        
        // Simular cambios en los datos meteorológicos
        System.out.println("\n" + "=".repeat(50));
        weatherData.setWeather(25.5f, 68.0f, 1013.2f);
        
        System.out.println("\n" + "=".repeat(50));
        weatherData.setWeather(22.1f, 72.5f, 1008.7f);
        
        System.out.println("\n" + "=".repeat(50));
        weatherData.setWeather(28.8f, 61.2f, 1018.9f);
        
        // Demostrar remoción de observer
        System.out.println("\n--- REMOVIENDO WEATHER PRESSURE DISPLAY ---");
        weatherData.removeObserver(weatherPressure);
        
        System.out.println("\n" + "=".repeat(50));
        weatherData.setWeather(19.3f, 85.7f, 995.4f);
        
        // Demostrar funcionalidad adicional
        System.out.println("\n--- REINICIANDO ESTADÍSTICAS ---");
        weatherStatistics.resetStatistics();
        
        System.out.println("\n" + "=".repeat(50));
        weatherData.setWeather(24.0f, 70.0f, 1015.0f);
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
        
        // Mostrar resumen de la arquitectura
        printArchitectureSummary();
    }
    
    /**
     * Imprime un resumen de la arquitectura implementada
     */
    private static void printArchitectureSummary() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("RESUMEN DE LA ARQUITECTURA IMPLEMENTADA");
        System.out.println("=".repeat(60));
        System.out.println("? INTERFACES:");
        System.out.println("  • Subject - Define operaciones para manejar observers");
        System.out.println("  • Observer - Define método update()");
        System.out.println("  • Display - Define método display()");
        System.out.println();
        System.out.println("?️ CLASES PRINCIPALES:");
        System.out.println("  • WeatherData - Subject concreto (almacena datos)");
        System.out.println("  • CurrentConditions - Muestra condiciones actuales");
        System.out.println("  • WeatherStatistics - Calcula estadísticas");
        System.out.println("  • WeatherForecast - Genera pronósticos");
        System.out.println("  • WeatherPressure - Especializado en presión");
        System.out.println("  • WeatherHeatIndex - Calcula índice de calor (NUEVO)");
        System.out.println();
        System.out.println("? HEAT INDEX (ÍNDICE DE CALOR):");
        System.out.println("  • Combina temperatura y humedad");
        System.out.println("  • Usa fórmula completa de Rothfusz");
        System.out.println("  • Proporciona niveles de riesgo");
        System.out.println("  • Incluye recomendaciones de seguridad");
        System.out.println("=".repeat(60));
    }
    
}
