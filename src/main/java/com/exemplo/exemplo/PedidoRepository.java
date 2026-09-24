package com.exemplo.exemplo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(String status);

    @Query("SELECT prod FROM Pedido p JOIN p.produtos prod WHERE p.status = 'RESERVADO' AND p.data < :dataLimite")
    List<Produto> produtosReservadosAntigos(@Param("dataLimite") LocalDate dataLimite);

    @Transactional
    @Modifying
    @Query("UPDATE Pedido p SET p.status = 'CANCELADO' WHERE p.status = 'RESERVADO' AND p.data < :dataLimite")
    void cancelarPedidosAntigos(@Param("dataLimite") LocalDate dataLimite);
}