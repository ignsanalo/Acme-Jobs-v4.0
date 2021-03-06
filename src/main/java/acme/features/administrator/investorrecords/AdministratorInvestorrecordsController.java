
package acme.features.administrator.investorrecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.investorrecords.Investorrecords;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/investorrecords/")
public class AdministratorInvestorrecordsController extends AbstractController<Administrator, Investorrecords> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AdministratorInvestorrecordsListService		listService;

	@Autowired
	private AdministratorInvestorrecordsShowService		showService;

	@Autowired
	private AdministratorInvestorrecordsCreateService	createService;

	@Autowired
	private AdministratorInvestorrecordsUpdateService	updateService;

	@Autowired
	private AdministratorInvestorrecordsDeleteService	deleteService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}

}
