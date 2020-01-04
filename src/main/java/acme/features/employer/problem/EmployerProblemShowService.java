
package acme.features.employer.problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.problem.Problem;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerProblemShowService implements AbstractShowService<Employer, Problem> {

	@Autowired
	private EmployerProblemRepository repository;


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

		request.unbind(entity, model, "text", "moreInfo");
	}

	@Override
	public Problem findOne(final Request<Problem> request) {
		assert request != null;

		Problem result;
		int idJob;

		idJob = request.getModel().getInteger("id");
		result = this.repository.findOneById(idJob);

		return result;
	}

}
