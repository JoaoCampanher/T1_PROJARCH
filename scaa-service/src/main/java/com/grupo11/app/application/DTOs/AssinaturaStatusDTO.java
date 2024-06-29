package com.grupo11.app.application.DTOs;

import java.time.LocalDate;
import java.util.UUID;

public record AssinaturaStatusDTO(UUID idAssinatura, LocalDate fim_vigencia) {
}
