
package acme.features.authenticated.message;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.Message;
import acme.entities.messages.MessageThread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMessageListByThreadService implements AbstractListService<Authenticated, Message> {

	@Autowired
	private AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;

		boolean result = false;
		int threadId;
		MessageThread messageThread;
		threadId = request.getModel().getInteger("id");

		Principal principal;
		principal = request.getPrincipal();

		messageThread = this.repository.findOneThreadById(threadId);

		for (Authenticated a : messageThread.getUsers()) {
			if (a.getId() == principal.getActiveRoleId()) {
				result = true;
			}
		}

		return result;

	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "tags");

	}

	@Override
	public Collection<Message> findMany(final Request<Message> request) {
		assert request != null;

		Collection<Message> result;
		int messageThreadId;

		messageThreadId = request.getModel().getInteger("id");
		result = this.repository.findManyByThreadId(messageThreadId);

		return result;
	}

}
