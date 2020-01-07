
package acme.features.employer.solimek;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.roles.Employer;
import acme.entities.solimek.Solimek;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/solimek/")
public class EmployerSolimekController extends AbstractController<Employer, Solimek> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EmployerSolimekShowService		showService;

	@Autowired
	private EmployerSolimekListByJobService	listService;

	@Autowired
	private EmployerSolimekCreateService	createService;


	// Constructors -----------------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_BY_JOB, BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
