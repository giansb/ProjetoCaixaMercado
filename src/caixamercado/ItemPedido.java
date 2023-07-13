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
public class ItemPedido {
    private int id;
    private int idPedido;
    private int idProduto;
    private int qntd;
    private String produto_nome;
    private double precoTotal;
    private int id_produto_has_pedido;
    

    public ItemPedido(int id,int id_produto_has_pedido, int idPedido, int idProduto, int qntd, String produto_nome, double precoTotal) {
        this.id = id;
        this.id_produto_has_pedido = id_produto_has_pedido;
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.qntd = qntd;
        this.produto_nome = produto_nome;
        this.precoTotal = precoTotal;
    }

    public String getProduto_nome() {
        return produto_nome;
    }

    public void setProduto_nome(String produto_nome) {
        this.produto_nome = produto_nome;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getId_produto_has_pedido() {
        return id_produto_has_pedido;
    }

    public void setId_produto_has_pedido(int id_produto_has_pedido) {
        this.id_produto_has_pedido = id_produto_has_pedido;
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }
    
    
    public void cadastrar(){
        String sql = "INSERT into produto_has_pedido(id_produto_has_pedido, qtd, precototal, produto_idproduto, pedido_idpedido) values( "
                + "" + this.getId_produto_has_pedido() + ","
                + "" + this.getQntd() + ","
                + "" + this.getPrecoTotal() + ","
                + "" + this.getIdProduto() + ","
                + "" + this.getIdPedido() + ")";
        System.out.println(sql);
        Conexao.executar(sql);
        
    } 
    
    
    public void editar(){
        String sql = "UPDATE produto_has_pedido SET "
                + "produto_idproduto = " + this.getIdProduto() +","
                + "pedido_idpedido = " + this.getIdPedido() + ","
                + "qtd = " +this.getQntd()+","
                + "precototal = " + this.getPrecoTotal() + ""
                + " WHERE id_produto_has_pedido = " + this.getId();
        
        Conexao.executar(sql);
    } 
      
    public static void excluir(int id){
        String sql = "DELETE FROM produto_has_pedido WHERE id_produto_has_pedido = " + id;
        Conexao.executar(sql);
    }
    
    public static ArrayList<ItemPedido> getItensPedido(){
        ArrayList<ItemPedido> lista = new ArrayList();
        String sql = "SELECT produto_has_pedido.id_produto_has_Pedido, produto.nome, produto.idproduto, produto_has_pedido.qtd, produto_has_pedido.precototal FROM produto_has_pedido, produto "
                + "WHERE produto_has_pedido.produto_idproduto = produto.idproduto "
                + " ORDER BY id_produto_has_pedido";
        ResultSet rs = Conexao.consultar(sql);
        
        if(rs != null){
            try{
                int cont=0;
                while(rs.next()){
                    
                    int cod = rs.getInt("produto_has_pedido.id_produto_has_Pedido");
                    String produto_nome = rs.getString("produto.nome");
                    int id_produto = rs.getInt("produto.idproduto");
                    int id_pedido = rs.getInt("pedido_idpedido");
                    int qtd = rs.getInt("produto_has_pedido.qtd");
                    double precototal = rs.getDouble("produto_has_pedido.precototal");
                    
                    ItemPedido ip = new ItemPedido(cont, cod, id_produto, id_pedido, qtd, produto_nome, precototal);
                    ip.cadastrar();
                    lista.add(ip);
                    cont++;
                    
                }
            }catch(Exception e){
                
            };
        }
        return lista;
        
    }

    
    
    
    
}
