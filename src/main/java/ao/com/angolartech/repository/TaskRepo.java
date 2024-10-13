package ao.com.angolartech.repository;

import ao.com.angolartech.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {

    boolean existsByTitulo(String titulo);
}
