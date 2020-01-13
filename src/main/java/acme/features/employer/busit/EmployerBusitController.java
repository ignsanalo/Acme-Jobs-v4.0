
package acme.features.employer.busit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.busit.Busit;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/busit/")
public class EmployerBusitController extends AbstractController<Employer, Busit> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EmployerBusitShowService		showService;

	@Autowired
	private EmployerBusitListByJobService	listService;

	@Autowired
	private EmployerBusitCreateService		createService;


	// Constructors -----------------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_BY_JOB, BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
