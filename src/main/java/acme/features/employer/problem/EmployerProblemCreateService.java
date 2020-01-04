
package acme.features.employer.problem;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.problem.Problem;
import acme.entities.roles.Employer;
import acme.features.employer.job.EmployerJobRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerProblemCreateService implements AbstractCreateService<Employer, Problem> {

	@Autowired
	EmployerProblemRepository	repository;

	@Autowired
	EmployerJobRepository		jobRepository;


	@Override
	public boolean authorise(final Request<Problem> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Problem> request, final Problem entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "job.title");
	}

	@Override
	public void unbind(final Request<Problem> request, final Problem entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "moreInfo");
		model.setAttribute("jobId", entity.getJob().getId());
	}

	@Override
	public Problem instantiate(final Request<Problem> request) {
		Problem result;
		Job job;
		int jobId;

		result = new Problem();
		jobId = request.getModel().getInteger("jobId");
		job = this.jobRepository.findOneJobById(jobId);

		assert job != null;
		result.setJob(job);

		return result;
	}

	@Override
	public void validate(final Request<Problem> request, final Problem entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		int jobId = request.getModel().getInteger("jobId");
		Job job = this.jobRepository.findOneJobById(jobId);

		Collection<Problem> problems = this.repository.findAllProblems();

		Boolean isValid;
		if (!errors.hasErrors("moreInfo")) {
			for (Problem p : problems) {
				isValid = !p.getJob().equals(job);
				errors.state(request, isValid, "moreInfo", "employer.problem.form.error.notcreate");
			}
		}
	}

	@Override
	public void create(final Request<Problem> request, final Problem entity) {
		this.repository.save(entity);
	}

}
