
package acme.entities.messages;

import java.beans.Transient;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
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

	private static final long					serialVersionUID	= 1L;

	//Attributes

	@NotBlank
	@Length(max = 255)
	private String								title;

	@NotNull
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	private Date								moment;

	@NotNull
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<@Valid Authenticated>	users;


	@Transient
	public String userList() {
		String users = "";

		int count = 0;

		for (Authenticated a : this.users) {
			count++;
			users += a.getUserAccount().getUsername();
			if (count < this.users.size()) {
				users += ", ";
			}
		}
		return users;
	}

}
