package com.grupo11.app.application.DTOs;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PagamentoDTO(@PastOrPresent LocalDate dataPagamento, @NotNull UUID codass,@DecimalMin(value = "0.01",message = "Amount must be greater than or equal to 0.01") @DecimalMax(value = "10000000.00") BigDecimal valorPago) {
}
