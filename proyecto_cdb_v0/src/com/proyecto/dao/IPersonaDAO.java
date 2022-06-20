/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.dao;

/**
 *
 * @author Josue Tello
 */


import com.proyecto.clogn.entities.Persona;
import java.util.List;
public interface IPersonaDAO {
      public abstract List<Persona> list();    //prototipo metodo listar desde pgsql
    public abstract Persona edit(String id);    //prototipo metodo editar desde pgsql
    public abstract boolean save (Persona persona,int ope);   //prototipo metodo guardar en pgsql
    public abstract boolean delete(String id);  

    
}
