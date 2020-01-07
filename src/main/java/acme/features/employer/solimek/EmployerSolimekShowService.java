
package acme.features.employer.solimek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Employer;
import acme.entities.solimek.Solimek;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerSolimekShowService implements AbstractShowService<Employer, Solimek> {

	@Autowired
	private EmployerSolimekRepository repository;


	@Override
	public boolean authorise(final Request<Solimek> request) {
		assert request != null;
		boolean result;

		int solimekId;
		Solimek solimek;
		Employer employer;
		Principal principal;

		solimekId = request.getModel().getInteger("id");
		solimek = this.repository.findOneById(solimekId);

		employer = solimek.getJob().getEmployer();
		principal = request.getPrincipal();
		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Solimek> request, final Solimek entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "moreInfo");
	}

	@Override
	public Solimek findOne(final Request<Solimek> request) {
		assert request != null;

		Solimek result;
		int idJob;

		idJob = request.getModel().getInteger("id");
		result = this.repository.findOneById(idJob);

		return result;
	}

}
