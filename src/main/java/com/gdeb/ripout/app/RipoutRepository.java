package main.java.com.gdeb.ripout.app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import main.java.com.gdeb.ripout.model.Ripout;

public interface RipoutRepository extends JpaRepository<Ripout, Long> {

	@Query("SELECT r FROM Ripout r WHERE lower(r.routing) = lower(:routing)")
	List<Ripout> findByRouting(String routing);

	@Query("SELECT r FROM Ripout r WHERE xref = :xref")
	Ripout findByXref(long xref);

	@Query("SELECT DISTINCT r.routing FROM Ripout r")
	List<String> findOpenRoutings();

}
