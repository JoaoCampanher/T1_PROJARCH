package com.grupo11.app.application.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CriaAssinaturaDTO(@NotBlank UUID id_assinatura,@NotBlank UUID id_cliente) {
}
