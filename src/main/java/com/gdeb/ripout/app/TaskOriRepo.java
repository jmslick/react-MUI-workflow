package main.java.com.gdeb.ripout.app;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import main.java.com.gdeb.ripout.model.TaskOri;

//@Repository
public interface TaskOriRepo extends CrudRepository<TaskOri, Long> {
	@Query("from TaskOri t where t.routingCurrent = :routingCurrent")
	TaskOri findTaskOriByRoutingCurrent(@Param("routingCurrent") String routingCurrent);
}
