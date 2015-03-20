package by.naxa.demo.model;

import by.naxa.demo.validation.Phone;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * Student Bean.
 * Created by phomal on 09.03.2015.
 */
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"photo", "rates"})
@ToString(callSuper = true, exclude = {"photo", "rates"}, includeFieldNames = false)
@NamedQuery(name = "Student.findByTheStudentsName", query = "select s from Student s where s.name = ?1")
public @Data class Student extends AbstractNamedPersistable<Long> {

	private static final long serialVersionUID = 6396741385679089363L;

	@Lob
	@Column(name = "Photo")
	private byte[] photo;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Gender")
	private Gender gender = Gender.UNKNOWN;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull @Past
	@Column(name = "Birthday")
	private Date birthday;

	@Phone
	@Column(name = "Phone", length = 32)
	private String phone;

	/*
	 * There is no cascade option on an ElementCollection,
	 * the target objects are always persisted, merged, removed with their parent.
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name="Rates",
			joinColumns = @JoinColumn(name = "student_id"))
	private Collection<Integer> rates = Collections.emptyList();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(
			name = "Faculty_id",
			nullable = false)
	private Faculty faculty;

}
