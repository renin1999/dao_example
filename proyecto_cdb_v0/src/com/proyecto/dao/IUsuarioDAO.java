/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.clogn.entities.Usuario;
import java.util.List;

/**
 *
 * @author Josue Tello
 */
public interface IUsuarioDAO {
      public abstract List<Usuario> list();    //prototipo metodo listar desde pgsql
    public abstract Usuario edit(String cod);    //prototipo metodo editar desde pgsql
    public abstract boolean save (Usuario usuario , int ope);   //prototipo metodo guardar en pgsql
    public abstract boolean delete(String id);  

    
}
