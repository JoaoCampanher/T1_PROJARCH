package com.grupo11.app.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TB_PAGAMENTO")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_pagamento;

    @ManyToOne
    @JoinColumn(name = "id_assinatura", nullable = false)
    private Assinatura assinatura;

    @Column(name = "valorPago", precision = 10, scale = 2)
    private BigDecimal valorPago;

    @Column(name = "dataPagamento")
    private LocalDate dataPagamento;

    private String promocao;

}
