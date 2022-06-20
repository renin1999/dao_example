/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.clogn.entities.Tiempo;
import java.util.List;

/**
 *
 * @author Josue Tello
 */
public interface ITiempoDAO {
   
    public List<Tiempo> list();    //prototipo metodo listar
    public Tiempo edit(int id);    //prototipo metodo editar
    public boolean save (Tiempo tiempo, int ope);   //prototipo metodo guardar
    public boolean delete(int id);      //protot
}
