
package acme.features.employer.busit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.busit.Busit;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerBusitShowService implements AbstractShowService<Employer, Busit> {

	@Autowired
	private EmployerBusitRepository repository;


	@Override
	public boolean authorise(final Request<Busit> request) {
		assert request != null;
		boolean result;

		int busitId;
		Busit busit;
		Employer employer;
		Principal principal;

		busitId = request.getModel().getInteger("id");
		busit = this.repository.findOneBusitById(busitId);

		employer = busit.getJob().getEmployer();
		principal = request.getPrincipal();
		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Busit> request, final Busit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "keylet");
	}

	@Override
	public Busit findOne(final Request<Busit> request) {
		assert request != null;

		Busit result;
		int idJob;

		idJob = request.getModel().getInteger("id");
		result = this.repository.findOneBusitById(idJob);

		return result;
	}

}
