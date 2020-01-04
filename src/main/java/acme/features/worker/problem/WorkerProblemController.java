
package acme.features.worker.problem;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.problem.Problem;
import acme.entities.roles.Worker;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/worker/problem/")
public class WorkerProblemController extends AbstractController<Worker, Problem> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private WorkerProblemShowService		showService;

	@Autowired
	private WorkerProblemListByJobService	listService;


	// Constructors -----------------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_BY_JOB, BasicCommand.LIST, this.listService);
	}

}
