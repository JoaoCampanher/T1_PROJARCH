package com.grupo11.app.application.DTOs;

import com.grupo11.app.domain.entity.enums.StatusPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RespostaPagamentoDTO(StatusPagamento statusPagamento, LocalDate dataValidade, BigDecimal valorEstornado) {
}
