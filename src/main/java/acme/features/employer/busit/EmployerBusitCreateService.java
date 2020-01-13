
package acme.features.employer.busit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.busit.Busit;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.features.employer.job.EmployerJobRepository;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerBusitCreateService implements AbstractCreateService<Employer, Busit> {

	@Autowired
	EmployerBusitRepository	repository;

	@Autowired
	EmployerJobRepository	jobRepository;


	@Override
	public boolean authorise(final Request<Busit> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Busit> request, final Busit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Busit> request, final Busit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "keylet");
		model.setAttribute("id", entity.getJob().getId());
	}

	@Override
	public Busit instantiate(final Request<Busit> request) {
		assert request != null;

		Busit result = new Busit();

		int jobId;

		jobId = request.getModel().getInteger("id");

		Job job = this.jobRepository.findOneJobById(jobId);

		assert job != null;
		result.setJob(job);

		return result;
	}

	@Override
	public void validate(final Request<Busit> request, final Busit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		//		int jobId = request.getModel().getInteger("jobId");
		//		Job job = this.jobRepository.findOneJobById(jobId);
		//
		//		Collection<XXXX1> XXXX1s = this.repository.findAllXXXX1s();
		//
		//		Boolean isValid;
		//		if (!errors.hasErrors("moreInfo")) {
		//			for (XXXX1 p : XXXX1s) {
		//				isValid = !p.getJob().equals(job);
		//				errors.state(request, isValid, "moreInfo", "employer.XXXX1.form.error.notcreate");
		//			}
		//		}
	}

	@Override
	public void create(final Request<Busit> request, final Busit entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

	@Override
	public void onSuccess(final Request<Busit> request, final Response<Busit> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
