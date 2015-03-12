package by.naxa.demo.model;

import lombok.*;
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
@RequiredArgsConstructor
public abstract @Data class AbstractNamedPersistable<PK extends Serializable> extends AbstractPersistable<PK> {

	private static final long serialVersionUID = 6500449905653154356L;

	@NonNull
	@Column(name = "Name", nullable = false, unique = true)
	private String name;

	@Override
	public String toString() {
		return getName();
	}
}
