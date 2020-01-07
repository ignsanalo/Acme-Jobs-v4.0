
package acme.features.employer.xxxx1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Employer;
import acme.entities.xxxx1.XXXX1;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerXXXX1ShowService implements AbstractShowService<Employer, XXXX1> {

	@Autowired
	private EmployerXXXX1Repository repository;


	@Override
	public boolean authorise(final Request<XXXX1> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<XXXX1> request, final XXXX1 entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "moreInfo");
	}

	@Override
	public XXXX1 findOne(final Request<XXXX1> request) {
		assert request != null;

		XXXX1 result;
		int idJob;

		idJob = request.getModel().getInteger("id");
		result = this.repository.findXXXX1ByJobId(idJob);

		return result;
	}

}
