package com.grupo11.app.application.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CriaAssinaturaDTO(@NotNull UUID id_aplicativo,@NotNull UUID id_cliente) {
}
