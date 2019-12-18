// elreyrata 16.12.19

package acme.features.authenticated.participatesIn;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.ParticipatesIn;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedParticipatesInShowService implements AbstractShowService<Authenticated, ParticipatesIn> {

	@Autowired
	AuthenticatedParticipatesInRepository repository;


	@Override
	public boolean authorise(final Request<ParticipatesIn> request) {
		assert request != null;

		boolean isOwner;
		boolean isParticipant;

		Principal principal = request.getPrincipal();

		ParticipatesIn participatesIn = this.repository.findOneById(request.getModel().getInteger("id"));

		Collection<ParticipatesIn> participants = this.repository.findManyByThreadId(participatesIn.getThread().getId());

		/*
		 *
		 * elreyrata 16.12.19
		 *
		 * Una opción mejor sería buscar que ParticipatesIn tienen el par del thread al que apunto
		 * y el usuario que consulta, pero, de momento, por hacer consistente el código y mantener
		 * la forma que hemos tenido de tratar estas cuestiones, lo mantendremos así
		 *
		 */

		isOwner = participatesIn.getThread().getOwner().getId() == principal.getActiveRoleId();
		isParticipant = participants.stream().anyMatch(p -> p.getParticipant().getId() == principal.getActiveRoleId());

		return isOwner || isParticipant;
	}

	@Override
	public void unbind(final Request<ParticipatesIn> request, final ParticipatesIn entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("isOwner", request.getPrincipal().getActiveRoleId() == entity.getThread().getOwner().getId());

		request.unbind(entity, model, "thread.title", "participant", "participant.userAccount.username", "participant.userAccount.identity.fullName");
	}

	@Override
	public ParticipatesIn findOne(final Request<ParticipatesIn> request) {
		assert request != null;

		ParticipatesIn result;

		result = this.repository.findOneById(request.getModel().getInteger("id"));

		return result;
	}

}
