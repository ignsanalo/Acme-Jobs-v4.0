
package acme.entities.problem;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.jobs.Job;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Problem extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(min = 5, max = 10)
	private String				text;

	@URL
	private String				moreInfo;

	@Valid
	@OneToOne(optional = true)
	private Job					job;

}
