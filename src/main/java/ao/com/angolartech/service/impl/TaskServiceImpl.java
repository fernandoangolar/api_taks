package ao.com.angolartech.service.impl;

import ao.com.angolartech.dto.TaskRequest;
import ao.com.angolartech.dto.TaskResponse;
import ao.com.angolartech.enums.Prioridade;
import ao.com.angolartech.enums.Status;
import ao.com.angolartech.exception.DataInvalidaException;
import ao.com.angolartech.exception.ResourceNotFoundException;
import ao.com.angolartech.exception.ResourceWithTitleExists;
import ao.com.angolartech.mapper.TaskMapper;
import ao.com.angolartech.model.Task;
import ao.com.angolartech.repository.TaskRepo;
import ao.com.angolartech.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private TaskMapper taskMapper;


    @Override
    public TaskResponse create(TaskRequest request) {

        // Aqui vai está a lógica de buscar usuário.

        if ( taskRepo.existsByTitulo(request.getTitulo()) ) {
            throw new ResourceWithTitleExists("Já existe uma tarefa com este título.");
        }

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

    @Override
    public List<TaskResponse> findAll() {

        List<Task> tasks = taskRepo.findAll();
//        List<TaskResponse> taskResponses = new ArrayList<>();
//
//        for ( Task task : tasks ) {
//            TaskResponse response = taskMapper.entityToResponse(task);
//            taskResponses.add(response);
//        }

        List<TaskResponse> responses = tasks.stream()
                .map(task -> taskMapper.entityToResponse(task))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public TaskResponse update(TaskRequest request, Long task_id) {

        Task task = taskRepo.findById(task_id)
                .orElseThrow( () -> new ResourceNotFoundException(
                        String.format("Task com id %d não foi encontrado", task_id)
                ));

        // Aqui vai ter a lógica do usuário

        if ( taskRepo.existsByTitulo(request.getTitulo()) && !task.getTitulo().equals(request.getTitulo()) ) {
            throw new ResourceWithTitleExists("Já existe uma tarefa com este título.");
        }

        task.setTitulo(request.getTitulo());
        task.setDescricao(request.getDescricao());
        task.setDataConclusao(request.getDataConclusao());

        validarDatas(task.getDataCriacao(), task.getDataConclusao());

        dateExperited(Status.CONCLUIDA);

        Task taskupdate = taskRepo.save(task);
        return taskMapper.entityToResponse(taskupdate);
    }

    private void dateExperited(Status status) {

        Task task = new Task();

        if ( task.getDataCriacao().isBefore(LocalDateTime.now()) ) {

            task.setStatus(Status.CONCLUIDA);
        }
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
