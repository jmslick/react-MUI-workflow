package main.java.com.gdeb.ripout.app;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.gdeb.ripout.model.TaskRouting;

public interface TaskRoutingRepo extends JpaRepository<TaskRouting, Long> {

}
