package com.grupo11.app.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_APLICATIVO")
public class Aplicativo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idAplicativo;

    private String nome;

    @Column(precision = 10, scale = 2)
    private BigDecimal valor;

    @OneToMany(mappedBy = "aplicativo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Assinatura> listaAssinaturas;

}
