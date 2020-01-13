
package acme.features.employer.busit;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.busit.Busit;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EmployerBusitListByJobService implements AbstractListService<Employer, Busit> {

	@Autowired
	EmployerBusitRepository repository;


	@Override
	public boolean authorise(final Request<Busit> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Busit> request, final Busit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "keylet");

	}

	@Override
	public Collection<Busit> findMany(final Request<Busit> request) {

		assert request != null;

		Collection<Busit> result;
		Integer idJob;

		idJob = request.getModel().getInteger("id");
		result = this.repository.findManyByJob(idJob);

		return result;

	}

}
