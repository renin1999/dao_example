package com.proyecto.caccdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
 public static final int SQLSERVER = 1;
    public static final int PGSQL = 2;
    public static final int MONGO = 3;

    public static String[] configSQLSERVER = {"inventario", "", ""};  //configrar copnexion: nombre bd, usr, clave
    public static String[] configPGSQL = {"inventario", "", ""};      //configrar copnexion: nombre bd, usr, clave
    public static String[] configMONGO = {"inventario", "", ""};      //configrar copnexion: nombre bd, usr, clave
  //  public static int SQLSERVER;
    
    //metodo que devuelve un objeto tipo coneectionDb (la primera clase)
    public static ConnectionDb open(int tipoBd){   //parametro indica si se conecta con MyQsl o PgSql
        switch(tipoBd){         //pasra determinar tipo de base de datos a laque se debe conectar
            case Connector.SQLSERVER:      //abrir bd mysql
                return new ConexionSql(configSQLSERVER);  //no hace falta break porque esta return
            //case FactoryConnectionDb.PGSQL:     //abrir bd postgresql
              //  return new PgSqlConnectionFactory(configPGSQL);
            //case FactoryConnectionDb.MONGO:     //abrir bd postgresql
              //  return new MongoConnectionFactory(configMONGO);
            default:        //si no se indica a q bd se conecta, devuelve nulo
                return null;
        }
    }

}
