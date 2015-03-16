package by.naxa.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * POJO Student.
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

	@Enumerated
	@Column(name = "Gender", columnDefinition = "enum('M', 'F', 'UNKNOWN')")
	private Gender gender = Gender.UNKNOWN;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name="Rates",
			joinColumns = @JoinColumn(name = "student_id"))
	private List<Integer> rates = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(
			name = "Faculty_id",
			nullable = false)
	private Faculty faculty;

	/**
	 * Parameterized constructor.
	 */
	public Student(String name, Gender gender, Faculty faculty) {
		super(name);
		this.gender = gender;
		this.faculty = faculty;
	}

	/**
	 * Updates the student's rates.
	 *
	 * @param ratesString a string with whitespace-separated rates.
	 */
	public void updateRates(String ratesString) {
		this.rates = Arrays.asList(ratesString.split(" "))
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

}
