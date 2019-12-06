
package acme.entities.configuration;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "spamWords")
})
public class Configuration extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	private String				spamWords;

	private Double				spamThreshold;

}
