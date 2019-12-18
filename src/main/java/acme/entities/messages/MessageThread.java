
package acme.entities.messages;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import acme.framework.entities.Authenticated;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "moment")
})
public class MessageThread extends DomainEntity {

	//Serialization identifier -----------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes

	@NotBlank
	@Length(max = 255)
	private String				title;

	@Past
	@Temporal(TemporalType.TIMESTAMP)
	private Date				moment;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Authenticated		owner;

}
