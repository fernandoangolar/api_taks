package ao.com.angolartech.service;

import ao.com.angolartech.dto.TaskRequest;
import ao.com.angolartech.dto.TaskResponse;

public interface TaskService {

    TaskResponse create(TaskRequest request);
}
