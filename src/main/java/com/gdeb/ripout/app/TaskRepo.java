package main.java.com.gdeb.ripout.app;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.gdeb.ripout.model.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

}
