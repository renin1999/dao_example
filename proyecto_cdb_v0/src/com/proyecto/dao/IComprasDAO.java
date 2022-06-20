/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.clogn.entities.ComprasArticulo;
import java.util.List;

/**
 *
 * @author Josue Tello
 */
public interface IComprasDAO {
     public abstract List<ComprasArticulo> list();    //prototipo metodo listar desde pgsql
    public abstract ComprasArticulo edit(String cod);    //prototipo metodo editar desde pgsql
    public abstract boolean save (ComprasArticulo compra,int ope);   //prototipo metodo guardar en pgsql
    public abstract boolean delete(String cod); 
   
}
