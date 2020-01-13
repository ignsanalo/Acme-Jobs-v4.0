
package acme.features.worker.busit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.busit.Busit;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerBusitShowService implements AbstractShowService<Worker, Busit> {

	@Autowired
	private WorkerBusitRepository repository;


	@Override
	public boolean authorise(final Request<Busit> request) {
		assert request != null;
		boolean result;

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
	public Busit findOne(final Request<Busit> request) {
		assert request != null;

		Busit result;
		int idJob;

		idJob = request.getModel().getInteger("id");
		result = this.repository.findOneById(idJob);

		return result;
	}

}
