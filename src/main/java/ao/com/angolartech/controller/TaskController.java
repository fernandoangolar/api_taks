package ao.com.angolartech.controller;

import ao.com.angolartech.dto.TaskRequest;
import ao.com.angolartech.dto.TaskResponse;
import ao.com.angolartech.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody @Valid TaskRequest request) {

        TaskResponse response = taskService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{task_id}")
    public ResponseEntity<TaskResponse> findById(@PathVariable Long task_id) {

        TaskResponse response = taskService.findById(task_id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}
