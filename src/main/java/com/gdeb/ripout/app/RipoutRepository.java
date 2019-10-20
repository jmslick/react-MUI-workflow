package main.java.com.gdeb.ripout.app;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.gdeb.ripout.model.Ripout;

public interface RipoutRepository extends JpaRepository<Ripout, Long> {

}
