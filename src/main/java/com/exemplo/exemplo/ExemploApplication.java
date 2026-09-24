package com.exemplo.exemplo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;

@SpringBootApplication
public class ExemploApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExemploApplication.class, args);
    }

    @Bean
    public CommandLineRunner executarTestes(PedidoRepository pedidoRepository) {
        return args -> {
            System.out.println("==================================================");
            System.out.println("A INICIAR OS TESTES DO JPA...");
            
            LocalDate umaSemanaAtras = LocalDate.now().minusWeeks(1);
            
            System.out.println("-> A executar: findByStatus('RESERVADO')");
            pedidoRepository.findByStatus("RESERVADO");
            
            System.out.println("-> A executar: produtosReservadosAntigos()");
            pedidoRepository.produtosReservadosAntigos(umaSemanaAtras);
            
            System.out.println("-> A executar: cancelarPedidosAntigos()");
            pedidoRepository.cancelarPedidosAntigos(umaSemanaAtras);
            
            System.out.println("SUCESSO: As consultas JPA rodaram sem erros de SQL!");
            System.out.println("==================================================");
        };
    }
}