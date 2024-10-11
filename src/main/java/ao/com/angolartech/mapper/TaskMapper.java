package ao.com.angolartech.mapper;


import ao.com.angolartech.dto.TaskRequest;
import ao.com.angolartech.dto.TaskResponse;
import ao.com.angolartech.model.Task;
import ao.com.angolartech.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Task requestToEntity(TaskRequest request) {
        return modelMapper.map(request, Task.class);
    }

    public TaskResponse entityToResponse(Task task) {
        return modelMapper.map(task, TaskResponse.class);
    }

}
