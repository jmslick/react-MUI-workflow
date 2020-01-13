package main.java.com.gdeb.ripout.app;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import main.java.com.gdeb.ripout.model.Task;

//@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {
	@Query("from Task t where t.routingCurrent = :routingCurrent")
	Task findTaskByRoutingCurrent(@Param("routingCurrent") String routingCurrent);

	@Query("from Task t where t.xref = :xref and t.xrefSeq = :xrefSeq")
	Task findByXrefAndXrefSeq(@Param("xref") long xref, @Param("xrefSeq") long xrefSeq);

	@Query("from Task t where t.xref = :xref")
	Task findByXref(@Param("xref") long xref);
}
