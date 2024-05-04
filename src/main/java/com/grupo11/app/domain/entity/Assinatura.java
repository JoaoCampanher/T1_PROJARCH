package com.grupo11.app.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.grupo11.app.domain.entity.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Table(name = "TB_ASSINATURA")
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idAssinatura;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    @JsonIgnoreProperties(value = {"listaAssinaturas", "nome", "email", "listaPagamentos"}) // Ignore other fields of Cliente except idCliente
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_aplicativo", nullable = false)
    @JsonIgnoreProperties(value = {"nome", "valor", "listaAssinaturas"}) // Ignore other fields of Aplicativo except idAplicativo
    private Aplicativo aplicativo;

    @Column(name = "inicioVigencia")
    private LocalDate inicio_vigencia;

    @Column(name = "fimVigencia")
    private LocalDate fim_vigencia;

    @OneToMany(mappedBy = "assinatura")
    private List<Pagamento> listaPagamentos;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status statusAssinatura;

}
