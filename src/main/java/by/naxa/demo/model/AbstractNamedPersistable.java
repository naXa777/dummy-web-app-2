package by.naxa.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Abstract superclass of named entities.
 *
 * (Created on 09.03.2015)
 * @author Paul Homal
 * @param <PK> the primary key of the entity
 */
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public abstract @Data class AbstractNamedPersistable<PK extends Serializable> extends AbstractPersistable<PK> {

	private static final long serialVersionUID = 6500449905653154356L;

	@NotBlank
	@Column(name = "Name", nullable = false, unique = true)
	private String name;

	@Override
	public String toString() {
		return getName();
	}
}
