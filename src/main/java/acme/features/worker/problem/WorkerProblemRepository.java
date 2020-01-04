/*
 * ProviderRequestsRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.worker.problem;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.problem.Problem;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerProblemRepository extends AbstractRepository {

	@Query("select p from Problem p where p.id = ?1")
	Problem findOneById(int idJob);

	@Query("select p from Problem p where p.job.id = ?1")
	Collection<Problem> findManyByJob(int idJob);

}
