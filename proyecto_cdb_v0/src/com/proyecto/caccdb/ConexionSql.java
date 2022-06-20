/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.caccdb;

/**
 *
 * @author Josue Tello
 */

import java.sql.Connection;
import java.sql.DriverManager;
public final class ConexionSql extends ConnectionDb {

    
     public ConexionSql(String[] params) {  //recibve un array de string parametros
        this.params = params;    //el atributo params de superclase recibe el parametro del constructor
        this.open();        //llama al metodo que se implementa abajo
    }
    @Override
    public Connection open() {   //implementacion del metodo abstracto que abre bd
          String urlDatos = 
               "jdbc:sqlserver://localhost:1433; databaseName=dtventas; user=sa; password=root; "
             + "encrypt=true; trustServerCertificate=true ";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection
        (urlDatos);  //subindice 0: nombre bd. paremtro 1: usr; parametro 2: clave.. llega en constructor
        } catch (Exception e){
            e.printStackTrace();
        }
        return this.connection;     //devuelve la conexion q es atributo declarada en superclase
    }
}
