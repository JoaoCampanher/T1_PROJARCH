package com.grupo11.asscache.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record AssinaturaStatusDTO(UUID idAssinatura, LocalDate fim_vigencia) {
}
