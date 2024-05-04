package com.grupo11.app.domain.entity;


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
    private UUID id_assinatura;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_aplicativo", nullable = false)
    private Aplicativo aplicativo;

    @Column(name = "inicioVigencia")
    private LocalDate inicio_vigencia;

    @Column(name = "fimVigencia")
    private LocalDate fim_vigencia;

    @OneToMany(mappedBy = "assinatura")
    private List<Pagamento> listaPagamentos;

    @Enumerated(EnumType.STRING)
    private Status statusAssinatura;

}
