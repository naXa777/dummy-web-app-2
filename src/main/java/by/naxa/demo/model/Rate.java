package by.naxa.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

/**
 * POJO Rate.
 * Created by phomal on 09.03.2015.
 */
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public @Data class Rate extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -7671542988780257235L;

	@Column(name = "Value", nullable = false)
	private int value;

	@NonNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Student_id", nullable = false)
	private Student student;

	public Rate(Student student, int value) {
		this.student = student;
		this.value = value;
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}
}
