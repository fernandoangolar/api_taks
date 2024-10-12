package ao.com.angolartech.service.impl;

import ao.com.angolartech.dto.TaskRequest;
import ao.com.angolartech.dto.TaskResponse;
import ao.com.angolartech.enums.Prioridade;
import ao.com.angolartech.enums.Status;
import ao.com.angolartech.exception.DataInvalidaException;
import ao.com.angolartech.exception.ResourceNotFoundException;
import ao.com.angolartech.mapper.TaskMapper;
import ao.com.angolartech.model.Task;
import ao.com.angolartech.repository.TaskRepo;
import ao.com.angolartech.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private TaskMapper taskMapper;


    @Override
    public TaskResponse create(TaskRequest request) {

        // Aqui vai está a lógica de buscar usuário.

        Task task = taskMapper.requestToEntity(request);

        task.setDataCriacao(LocalDateTime.now());
        task.setStatus(Status.PENDENTE);
        task.setPrioridade(Prioridade.MEDIA);

        validarDatas(task.getDataCriacao(), task.getDataConclusao());

        Task taskSave = taskRepo.save(task);
        return taskMapper.entityToResponse(taskSave);
    }

    @Override
    public TaskResponse findById(Long task_id) {

        Task task = taskRepo.findById(task_id)
                .orElseThrow( () -> new ResourceNotFoundException(
                        String.format("Task com id %d não foi encontrado", task_id)));

        TaskResponse response = taskMapper.entityToResponse(task);
        return response;
    }


    private void validarDatas(LocalDateTime dataCriacao, LocalDateTime dataConclusao) {

        if (dataConclusao.isBefore(dataCriacao)) {
            throw new DataInvalidaException("A data de conclusão não pode ser anterior à data de criação");
        }
        if (dataConclusao.isBefore(LocalDateTime.now())) {
            throw new DataInvalidaException("A data de conclusão não pode ser no passado");
        }

    }
}
