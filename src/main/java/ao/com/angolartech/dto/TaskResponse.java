package ao.com.angolartech.dto;

import ao.com.angolartech.enums.Prioridade;
import ao.com.angolartech.enums.Status;
import ao.com.angolartech.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskResponse {

    private Long id;

    private String titulo;

    private String descricao;

    private final LocalDateTime dataCriacao = LocalDateTime.now();

    private final LocalDateTime dataConclusao;

    private Status status;
    private Prioridade prioridade;

    private User user;
}
