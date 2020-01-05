
package acme.features.employer.xxxx1;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXXX1.XXXX1;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.features.employer.job.EmployerJobRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerXXXX1CreateService implements AbstractCreateService<Employer, XXXX1> {

	@Autowired
	EmployerXXXX1Repository	repository;

	@Autowired
	EmployerJobRepository	jobRepository;


	@Override
	public boolean authorise(final Request<XXXX1> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<XXXX1> request, final XXXX1 entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "job.title");
	}

	@Override
	public void unbind(final Request<XXXX1> request, final XXXX1 entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "moreInfo");
		model.setAttribute("jobId", entity.getJob().getId());
	}

	@Override
	public XXXX1 instantiate(final Request<XXXX1> request) {
		XXXX1 result;
		Job job;
		int jobId;

		result = new XXXX1();
		jobId = request.getModel().getInteger("jobId");
		job = this.jobRepository.findOneJobById(jobId);

		assert job != null;
		result.setJob(job);

		return result;
	}

	@Override
	public void validate(final Request<XXXX1> request, final XXXX1 entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		int jobId = request.getModel().getInteger("jobId");
		Job job = this.jobRepository.findOneJobById(jobId);

		Collection<XXXX1> XXXX1s = this.repository.findAllXXXX1s();

		Boolean isValid;
		if (!errors.hasErrors("moreInfo")) {
			for (XXXX1 p : XXXX1s) {
				isValid = !p.getJob().equals(job);
				errors.state(request, isValid, "moreInfo", "employer.XXXX1.form.error.notcreate");
			}
		}
	}

	@Override
	public void create(final Request<XXXX1> request, final XXXX1 entity) {
		this.repository.save(entity);
	}

}
