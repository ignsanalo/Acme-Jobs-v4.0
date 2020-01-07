
package acme.features.employer.solimek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.entities.solimek.Solimek;
import acme.features.employer.job.EmployerJobRepository;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerSolimekCreateService implements AbstractCreateService<Employer, Solimek> {

	@Autowired
	EmployerSolimekRepository	repository;

	@Autowired
	EmployerJobRepository		jobRepository;


	@Override
	public boolean authorise(final Request<Solimek> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Solimek> request, final Solimek entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Solimek> request, final Solimek entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "moreInfo");
		model.setAttribute("id", entity.getJob().getId());
	}

	@Override
	public Solimek instantiate(final Request<Solimek> request) {
		assert request != null;

		Solimek result = new Solimek();

		int jobId;

		jobId = request.getModel().getInteger("id");

		Job job = this.jobRepository.findOneJobById(jobId);

		assert job != null;
		result.setJob(job);

		return result;
	}

	@Override
	public void validate(final Request<Solimek> request, final Solimek entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Solimek> request, final Solimek entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

	@Override
	public void onSuccess(final Request<Solimek> request, final Response<Solimek> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
