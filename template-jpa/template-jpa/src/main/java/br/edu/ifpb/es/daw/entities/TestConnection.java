package br.edu.ifpb.es.daw.entities;

// Estava errando em adicionar dois package e faltando import de classes.

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/daw";
        String user = "daw";
        String password = "daw";

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/daw", "daw", "daw");

            if (conn != null) {
                System.out.println("Banco de Dados Conectado!");
            } else {
                System.out.println("Conexão Falhou!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
