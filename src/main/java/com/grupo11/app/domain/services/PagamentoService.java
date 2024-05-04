package com.grupo11.app.domain.services;

import com.grupo11.app.application.DTOs.PagamentoDTO;
import com.grupo11.app.application.DTOs.RespostaPagamentoDTO;
import com.grupo11.app.domain.entity.Assinatura;
import com.grupo11.app.domain.entity.Pagamento;
import com.grupo11.app.domain.entity.enums.Status;
import com.grupo11.app.domain.entity.enums.StatusPagamento;
import com.grupo11.app.domain.repositories.AssinaturaRepositorio;
import com.grupo11.app.domain.repositories.PagamentoRepositorio;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class PagamentoService {

    private final PagamentoRepositorio pagamentoRepositorio;

    private final AssinaturaRepositorio assinaturaRepositorio;


    public PagamentoService(PagamentoRepositorio pagamentoRepositorio, AssinaturaRepositorio assinaturaRepositorio) {
        this.pagamentoRepositorio = pagamentoRepositorio;
        this.assinaturaRepositorio = assinaturaRepositorio;
    }

    public RespostaPagamentoDTO registrarPagamento(PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = new Pagamento();

        Assinatura assinatura = assinaturaRepositorio.findById(pagamentoDTO.codass()).orElseThrow(() -> new RuntimeException("Assinatura não encontrada"));

        if(assinatura.getAplicativo().getValor().equals(pagamentoDTO.valorPago())) {
            if(assinatura.getStatusAssinatura().equals(Status.CANCELADA)){
                assinatura.setStatusAssinatura(Status.ATIVA);
            }
            assinatura.setFim_vigencia(LocalDate.now().plusMonths(1));
            assinaturaRepositorio.save(assinatura);
            pagamento.setDataPagamento(LocalDate.now());
            pagamento.setAssinatura(assinatura);
            pagamento.setValorPago(pagamentoDTO.valorPago());
            pagamentoRepositorio.save(pagamento);
            return new RespostaPagamentoDTO(StatusPagamento.PAGAMENTO_OK, LocalDate.now().plusMonths(1), BigDecimal.ZERO);
        } else {
            return new RespostaPagamentoDTO(StatusPagamento.VALOR_INCORRETO,assinatura.getFim_vigencia(),pagamentoDTO.valorPago());
        }
    }

}
