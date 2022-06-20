/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.clogn.entities.Administrador;
import java.util.List;

/**
 *
 * @author Josue Tello
 */
public interface IAdministradorDAO {
       public abstract List<Administrador> list();    //prototipo metodo listar desde pgsql
    public abstract Administrador edit(int id);    //prototipo metodo editar desde pgsql
    public abstract boolean save (Administrador administrador, int ope);   //prototipo metodo guardar en pgsql
    public abstract boolean delete(int id);  

}
