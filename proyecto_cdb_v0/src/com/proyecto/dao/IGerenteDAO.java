/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.clogn.entities.Gerente;
import java.util.List;

/**
 *
 * @author Josue Tello
 */
public interface IGerenteDAO {
 
    
    
    public List<Gerente> list();    //prototipo metodo listar
    public Gerente edit(int id);    //prototipo metodo editar
    public boolean save (Gerente gerente,int ope);   //prototipo metodo guardar
    public boolean delete(int id);      //protot
}
