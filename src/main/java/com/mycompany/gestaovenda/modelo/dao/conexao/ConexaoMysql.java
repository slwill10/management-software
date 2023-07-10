/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestaovenda.modelo.dao.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pc01
 */
public class ConexaoMysql implements Conexao{
    
    private final String USUARIO = "root";
    private final String SENHA = "root";
    private final String URL = "jdbc:mysql://localhost:3306/gestao_venda?serverTimezone=America/Sao_Paulo";
    private Connection conectar;

    @Override
    public Connection obterConexao() throws SQLException {
        if(conectar == null){
            conectar = DriverManager.getConnection(URL, USUARIO, SENHA);
        }
        return conectar;
    }
    
}
