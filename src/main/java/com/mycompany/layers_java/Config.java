 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.layers_java;

/**
 *
 * @author Progra
 */
public final class Config 
{
    /**
     * Metodo que arma y retorna la cadena de conexion.
     * @return String con la cadena de conexion a utilizar.
     */
    public static String getConnectionString()
    {
        return "jdbc:sqlserver://localhost:1433;databaseName=EXAMPLE_JAVA;user=javaUser;password=java";
    }
    
}
