
package acme.features.worker.problem;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.problem.Problem;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class WorkerProblemListByJobService implements AbstractListService<Worker, Problem> {

	@Autowired
	WorkerProblemRepository repository;


	@Override
	public boolean authorise(final Request<Problem> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Problem> request, final Problem entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "moreInfo", "job");

	}

	@Override
	public Collection<Problem> findMany(final Request<Problem> request) {

		assert request != null;

		Collection<Problem> result;
		Integer idJob;

		idJob = request.getModel().getInteger("id");
		result = this.repository.findManyByJob(idJob);

		return result;

	}

}
