/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixamercado;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author gianb
 */
public class Produto {
    private int codigo;
    private String nome;
    private double preco;

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    Produto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public void cadastrar(){
        String sql = "INSERT INTO produto (idproduto, nome, preco) VALUES ("
                + "'" + this.getCodigo() + "',"
                + "'" + this.getNome()+ "',"
                + "" + this.getPreco() + ")";
        Conexao.executar(sql);
    }
    
    public void editar(){
        String sql = "UPDATE produto SET"
                + " nome = '" + this.getNome() + "',"
                + "preco = " +this.getPreco() + ""
                + "WHERE idproduto = " +this.getCodigo();
        System.out.println(sql);
        Conexao.executar(sql);
    }
    
    public static void excluir(int idproduto){
        String sql = "DELETE FROM produto WHERE idproduto = " + idproduto;
        Conexao.executar(sql);
    }
    
    public static ArrayList<Produto> getProduto(){
        ArrayList<Produto> lista = new ArrayList();
        String sql = "SELECT idproduto,nome, preco FROM produto ORDER BY nome";
        ResultSet rs = Conexao.consultar(sql);
        if(rs != null){
            try{
                while(rs.next()){
                    int codigo = rs.getInt("idproduto");
                    String nome = rs.getString("nome");
                    double preco = rs.getDouble("preco");
                    Produto prod = new Produto(codigo, nome, preco);
                    lista.add(prod);
                }
            } catch(Exception e){
                
            }
        }
        return lista;
    }
    
    
}
