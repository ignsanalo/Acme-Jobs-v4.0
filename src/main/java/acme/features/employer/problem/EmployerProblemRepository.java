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

package acme.features.employer.problem;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.problem.Problem;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerProblemRepository extends AbstractRepository {

	@Query("select r from Problem r where r.id = ?1")
	Problem findOneById(int id);

	@Query("select r from Problem r where r.job.id = ?1")
	Problem findProblemByJobId(int id);

	@Query("select r from Problem r")
	Collection<Problem> findAllProblems();

}
