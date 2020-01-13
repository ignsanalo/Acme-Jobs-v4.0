
package acme.features.worker.busit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.busit.Busit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerBusitRepository extends AbstractRepository {

	@Query("select b from Busit b where b.id = ?1")
	Busit findOneById(int idJob);

	@Query("select b from Busit b where b.job.id = ?1")
	Collection<Busit> findManyByJob(int idJob);

}
