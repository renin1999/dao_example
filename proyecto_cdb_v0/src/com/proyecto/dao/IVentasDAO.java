/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.clogn.entities.Ventas;
import java.util.List;

/**
 *
 * @author Josue Tello
 */
public interface IVentasDAO {
      public abstract List<Ventas> list();    //prototipo metodo listar desde pgsql
    public abstract Ventas edit(String id);    //prototipo metodo editar desde pgsql
    public abstract boolean save (Ventas ventas , int ope);   //prototipo metodo guardar en pgsql
    public abstract boolean delete(String id);  

}
