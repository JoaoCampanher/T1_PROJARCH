package com.grupo11.asscache.proxy;

import com.grupo11.asscache.dtos.AssinaturaStatusDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "scaa-service")
public interface ValidaAssinaturaClient {
    @GetMapping("/scaa-service/assinatura/status/{codass}")
    AssinaturaStatusDTO getStatusAssinaturaAndPersist(@PathVariable("codass") UUID uuid);

}
