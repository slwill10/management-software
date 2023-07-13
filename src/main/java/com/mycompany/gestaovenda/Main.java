package com.mycompany.gestaovenda;

import com.mycompany.gestaovenda.modelo.conexao.Conexao;
import com.mycompany.gestaovenda.modelo.conexao.ConexaoMysql;
import com.mycompany.gestaovenda.modelo.dominio.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    
    public static void main(String[] args) throws SQLException {
        String sql = "SELECT * FROM categoria";
        
        Conexao conexao = new ConexaoMysql();
        
        Categoria categoria = new Categoria(2L, "Bebida java", "Inserção no netbeans");
        
        String inserirSql = "INSERT INTO categoria (id, nome, descricao) VALUES (?, ?, ?)";
        
        PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(inserirSql);
       
        preparedStatement.setLong(1, categoria.getId());
        preparedStatement.setString(2, categoria.getNome());
        preparedStatement.setString(3, categoria.getDescricao());
        
        int resultadoDoCadastro = preparedStatement.executeUpdate();
        
        System.out.println(resultadoDoCadastro);
        
        ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
        
        while (result.next()) {
            System.out.println(result.getString("nome"));
        }
        
    }
    
}
