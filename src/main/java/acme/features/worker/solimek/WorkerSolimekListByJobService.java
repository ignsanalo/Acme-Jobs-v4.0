
package acme.features.worker.solimek;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Worker;
import acme.entities.solimek.Solimek;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class WorkerSolimekListByJobService implements AbstractListService<Worker, Solimek> {

	@Autowired
	WorkerSolimekRepository repository;


	@Override
	public boolean authorise(final Request<Solimek> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Solimek> request, final Solimek entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "moreInfo");

	}

	@Override
	public Collection<Solimek> findMany(final Request<Solimek> request) {

		assert request != null;

		Collection<Solimek> result;
		Integer idJob;

		idJob = request.getModel().getInteger("id");
		result = this.repository.findManyByJob(idJob);

		return result;

	}

}
