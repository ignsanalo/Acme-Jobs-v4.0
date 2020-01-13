
package acme.features.employer.busit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.busit.Busit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerBusitRepository extends AbstractRepository {

	@Query("select b from Busit b where b.id = ?1")
	Busit findOneBusitById(int idJob);

	@Query("select b from Busit b where b.job.id = ?1")
	Collection<Busit> findManyByJob(int idJob);

}
