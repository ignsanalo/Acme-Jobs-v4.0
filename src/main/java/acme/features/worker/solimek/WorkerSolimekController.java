
package acme.features.worker.solimek;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.roles.Worker;
import acme.entities.solimek.Solimek;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/worker/solimek/")
public class WorkerSolimekController extends AbstractController<Worker, Solimek> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private WorkerSolimekShowService		showService;

	@Autowired
	private WorkerSolimekListByJobService	listService;


	// Constructors -----------------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_BY_JOB, BasicCommand.LIST, this.listService);
	}

}
