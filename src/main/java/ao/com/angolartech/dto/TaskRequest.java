package ao.com.angolartech.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskRequest {

    @NotNull(message = "O título é obrigatório")
    @Size(min = 3, max = 100, message = "P título deve ter entre 3 a 100 caracteres.")
    private String title;

    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
    private String description;

    @NotNull(message = "A data de vencimento é obrigatória")
    private LocalDateTime dataConclusao;
}
