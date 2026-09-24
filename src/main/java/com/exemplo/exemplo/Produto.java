package com.exemplo.exemplo;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<Pedido> getPedidos() { return pedidos; }
    public void setPedidos(List<Pedido> pedidos) { this.pedidos = pedidos; }
}