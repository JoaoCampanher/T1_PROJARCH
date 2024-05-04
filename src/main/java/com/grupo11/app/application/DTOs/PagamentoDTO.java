package com.grupo11.app.application.DTOs;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PagamentoDTO(LocalDate dataPagamento, UUID codass, BigDecimal valorPago) {
}
