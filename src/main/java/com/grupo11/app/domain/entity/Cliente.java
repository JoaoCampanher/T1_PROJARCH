package com.grupo11.app.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TB_CLIENTE", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_cliente;

    @Column(name = "nome")
    private String nome;

    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<Assinatura> listaAssinaturas;

}
