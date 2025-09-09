/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subjects;

import Observers.*;

/**
 *
 * @author Estudiantes
 */
public interface Subject {
    
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();

}
