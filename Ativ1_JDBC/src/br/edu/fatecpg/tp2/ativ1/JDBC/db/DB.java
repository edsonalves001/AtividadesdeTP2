package br.edu.fatecpg.tp2.ativ1.JDBC.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;

public class DB {
    public static Connection connection() throws SQLDataException {
        try{
            var jdbcUrl = "jdbc:postgresql://localhost:5432/AulasdeTP2";
            var user = "postgres";
            var password = "78203861";
            return DriverManager.getConnection(jdbcUrl,user,password);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
}