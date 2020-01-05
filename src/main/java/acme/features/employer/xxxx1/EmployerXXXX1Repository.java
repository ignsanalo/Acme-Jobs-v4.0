
package acme.features.employer.xxxx1;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.XXXX1.XXXX1;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerXXXX1Repository extends AbstractRepository {

	@Query("select r from XXXX1 r where r.id = ?1")
	XXXX1 findOneById(int id);

	@Query("select r from XXXX1 r where r.job.id = ?1")
	XXXX1 findXXXX1ByJobId(int id);

	@Query("select r from XXXX1 r")
	Collection<XXXX1> findAllXXXX1s();

}
