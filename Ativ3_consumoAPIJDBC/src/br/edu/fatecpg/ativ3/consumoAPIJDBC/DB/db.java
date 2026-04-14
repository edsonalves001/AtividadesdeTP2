package br.edu.fatecpg.ativ3.consumoAPIJDBC.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;

public class db {
    public static Connection connection() throws SQLDataException {
        try{
            var jdbcUrl = "jdbc:postgresql://localhost:5432/AulasdeTP2";
            var user = "fatec";
            var password = "fatec";
            return DriverManager.getConnection(jdbcUrl,user,password);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
}

