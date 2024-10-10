package ao.com.angolartech.model;

import ao.com.angolartech.enums.Prioridade;
import ao.com.angolartech.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tarefas")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    private String descricao;

    @Column(name = "data_criacao")
    private final LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "data_conclusao")
    private final LocalDateTime dataConclusao = LocalDateTime.now();

    private Status status;
    private Prioridade prioridade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
