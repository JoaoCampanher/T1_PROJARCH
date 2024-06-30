package com.grupo11.asscache.services;

import com.grupo11.asscache.dtos.AssinaturaStatusDTO;
import com.grupo11.asscache.dtos.NewValidDateMessage;
import com.grupo11.asscache.proxy.ValidaAssinaturaClient;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ValidaAssinaturaService {

    @Autowired
    private ValidaAssinaturaClient validaAssinaturaClient;

    private Map<String, LocalDate> dicionarioDeAssinaturas;

    public ValidaAssinaturaService(ValidaAssinaturaClient validaAssinaturaClient) {
        this.dicionarioDeAssinaturas = new HashMap<>();
        this.validaAssinaturaClient = validaAssinaturaClient;
    }

    public boolean validaAssinatura(UUID codass){

        LocalDate dataDeValidade = dicionarioDeAssinaturas.get(codass.toString());

        if (dataDeValidade != null && dataDeValidade.isAfter(LocalDate.now())){
            return true;
        }

        AssinaturaStatusDTO statusAssinaturaAndPersist;

        try {
            statusAssinaturaAndPersist = validaAssinaturaClient.getStatusAssinaturaAndPersist(codass);
        } catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Assinatura não encontrada");
        }

        if (statusAssinaturaAndPersist != null){
            dicionarioDeAssinaturas.put(codass.toString(), statusAssinaturaAndPersist.fim_vigencia());
        }
        return statusAssinaturaAndPersist != null && statusAssinaturaAndPersist.fim_vigencia().isAfter(LocalDate.now());
    }

    @RabbitListener(queues = "#{queue.name}")
    public void receiveMessage(NewValidDateMessage message) {
        String dateStr = message.newValidDate();
        UUID codass  = message.codass();
        String codassString = codass.toString();
        LocalDate date = LocalDate.parse(dateStr);

        LocalDate localDate = dicionarioDeAssinaturas.get(codassString);

        if (localDate != null ) {
            dicionarioDeAssinaturas.replace(codassString, date);
        }

        System.out.println("Received update subscription validation date: " + message);
    }

}
