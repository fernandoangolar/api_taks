package ao.com.angolartech.dto;

import ao.com.angolartech.enums.Prioridade;
import ao.com.angolartech.enums.Status;
import ao.com.angolartech.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskResponse {

    private Long id;

    private String titulo;

    private String descricao;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    private LocalDateTime dataConclusao;

    private Status status;
    private Prioridade prioridade;
}
