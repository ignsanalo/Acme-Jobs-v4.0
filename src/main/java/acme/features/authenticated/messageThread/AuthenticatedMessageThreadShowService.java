/*
 * AuthenticatedRequestsCreateService.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.messageThread;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.MessageThread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageThreadShowService implements AbstractShowService<Authenticated, MessageThread> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedMessageThreadRepository repository;

	// AbstractCreateService<Authenticated, MessageThread> ---------------------------


	@Override
	public boolean authorise(final Request<MessageThread> request) {
		assert request != null;

		boolean result = false;
		int threadId;
		MessageThread messageThread;
		threadId = request.getModel().getInteger("id");

		Principal principal;
		principal = request.getPrincipal();
		Collection<Authenticated> users;

		messageThread = this.repository.findOneById(threadId);

		users = messageThread.getUsers();

		for (Authenticated a : users) {
			if (a.getId() == principal.getActiveRoleId()) {
				result = true;
			}
		}

		return result;

	}

	@Override
	public void unbind(final Request<MessageThread> request, final MessageThread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("userList", entity.userList());

		request.unbind(entity, model, "title", "moment");
	}

	@Override
	public MessageThread findOne(final Request<MessageThread> request) {
		assert request != null;

		MessageThread result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
