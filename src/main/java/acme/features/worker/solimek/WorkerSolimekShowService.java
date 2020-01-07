
package acme.features.worker.solimek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Worker;
import acme.entities.solimek.Solimek;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerSolimekShowService implements AbstractShowService<Worker, Solimek> {

	@Autowired
	private WorkerSolimekRepository repository;


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
	public Solimek findOne(final Request<Solimek> request) {
		assert request != null;

		Solimek result;
		int idJob;

		idJob = request.getModel().getInteger("id");
		result = this.repository.findOneById(idJob);

		return result;
	}

}
