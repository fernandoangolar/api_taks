package ao.com.angolartech.service;

import ao.com.angolartech.dto.TaskRequest;
import ao.com.angolartech.dto.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse create(TaskRequest request);
    TaskResponse findById(Long task_id);
    List<TaskResponse> findAll();
}
