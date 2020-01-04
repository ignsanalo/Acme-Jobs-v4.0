
package acme.features.employer.problem;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.problem.Problem;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/problem/")
public class EmployerProblemController extends AbstractController<Employer, Problem> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EmployerProblemShowService		showService;

	@Autowired
	private EmployerProblemCreateService	createService;


	// Constructors -----------------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);

	}

}
