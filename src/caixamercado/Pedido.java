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
public class Pedido {
    private int id;
    private String tipoPagamento;
    private String cpf;
    
    
    private double total;

    public Pedido(int id, String tipoPagamento, String cpf, double total) {
        this.id = id;
        this.tipoPagamento = tipoPagamento;
        this.cpf = cpf;
        this.total = total;
    }  

    Pedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void cadastrar(){
        String sql = "INSERT INTO pedido(idpedido, tipo_pagamento, cpf, total) VALUES ("
                + "" + this.getId() + ","
                + "'" + this.getTipoPagamento() + "',"
                + "'" + this.getCpf() + "',"
                + "" + this.getTotal() + ")";
        Conexao.executar(sql);
    }
    
    public void editar(){
        String sql = "UPDATE pedido SET "
                + "tipo_pagamento = '" + this.getTipoPagamento() + "',"
                + "cpf = '" + this.getCpf() + "',"
                + "data = now(),"
                +"total = " + this.getTotal() + ""
                + "WHERE pedido.id = " + this.getId();
        Conexao.executar(sql);
    }
    
    public static void excluir(int id){
        String sql = "DELETE FROM pedido WHERE pedido.idpedido = " + id;
        Conexao.executar(sql);
    }
    
    public static ArrayList<Pedido> getPedidos(){
        ArrayList<Pedido> lista = new ArrayList();
        String sql = "SELECT idpedido, tipo_pagamento, cpf, total, data FROM pedido";
        ResultSet rs = Conexao.consultar(sql);
        if(rs != null){
            try{
                while(rs.next()){
                    int codigo = rs.getInt("idpedido");
                    String tipo_pagamento = rs.getString("tipo_pagamento");
                    String cpf = rs.getString("cpf");
                    double total = rs.getDouble("total");
                    Pedido p = new Pedido(codigo, tipo_pagamento, cpf, total);
                    lista.add(p);
                }
            }catch(Exception e){
                
            }
        }
        return lista;
    }
    
    
}
