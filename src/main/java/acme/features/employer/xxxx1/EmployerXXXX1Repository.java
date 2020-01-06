
package acme.features.employer.xxxx1;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.xxxx1.XXXX1;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerXXXX1Repository extends AbstractRepository {

	@Query("select r from XXXX1 r where r.id = ?1")
	XXXX1 findOneById(int id);

	@Query("select r from XXXX1 r where r.job.id = ?1")
	XXXX1 findXXXX1ByJobId(int id);

	@Query("select r from XXXX1 r")
	Collection<XXXX1> findAllXXXX1s();

	//	@Query("select e from Employer e where e.id = ?1")
	//	Employer findXXXX1EmployerById(int employerId);
	//
	//	@Query("select j from Job j where j.id = ?1")
	//	Job findXXXX1JobById(int id);

}
