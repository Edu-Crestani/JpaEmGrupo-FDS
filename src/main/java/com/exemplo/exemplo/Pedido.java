package com.exemplo.exemplo;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String status;
    private LocalDate data;
    
    @ManyToMany
    @JoinTable(name = "pedido_produto",
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}