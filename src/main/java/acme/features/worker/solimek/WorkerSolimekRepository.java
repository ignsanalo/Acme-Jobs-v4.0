
package acme.features.worker.solimek;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.solimek.Solimek;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerSolimekRepository extends AbstractRepository {

	@Query("select s from Solimek s where s.id = ?1")
	Solimek findOneById(int idJob);

	@Query("select s from Solimek s where s.job.id = ?1")
	Collection<Solimek> findManyByJob(int idJob);

}
