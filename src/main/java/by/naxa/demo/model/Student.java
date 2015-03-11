package by.naxa.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

/**
 * POJO Student.
 * Created by phomal on 09.03.2015.
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@NamedQuery(name = "Student.findByTheStudentsName", query = "select s from Student s where s.name = ?1")
public @Data class Student extends AbstractNamedPersistable<Long> {

	private static final long serialVersionUID = 6396741385679089363L;

	@Lob
	@Column(name = "Photo")
	private byte[] photo;

	@Column(name = "Gender")
	private Gender gender = Gender.UNKNOWN;

	@OneToMany(
			fetch = FetchType.EAGER,
			mappedBy = "student",
			orphanRemoval = true,
			cascade = CascadeType.ALL)
	private Collection<Rate> rates;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(
			name = "Faculty_id",
			nullable = false)
	private Faculty faculty;

	public Student(String name, Faculty faculty) {
		super(name);
		this.faculty = faculty;
	}

}
