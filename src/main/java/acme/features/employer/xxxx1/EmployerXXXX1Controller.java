
package acme.features.employer.xxxx1;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Employer;
import acme.entities.xxxx1.XXXX1;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/xxxx1/")
public class EmployerXXXX1Controller extends AbstractController<Employer, XXXX1> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EmployerXXXX1ShowService	showService;

	@Autowired
	private EmployerXXXX1CreateService	createService;


	// Constructors -----------------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);

	}

}
