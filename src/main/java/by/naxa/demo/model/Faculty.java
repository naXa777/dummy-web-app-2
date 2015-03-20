package by.naxa.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Faculty Bean.
 * Created by phomal on 09.03.2015.
 */
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"students"})
@ToString(callSuper = true, exclude = {"students"})
@NamedQuery(name = "Faculty.findByTheFacultyName", query = "select f from Faculty f where f.name = ?1")
public @Data class Faculty extends AbstractNamedPersistable<Long> {

	private static final long serialVersionUID = 8091706013938438847L;

	@OneToMany(
			fetch = FetchType.LAZY,
			mappedBy = "faculty")
	private List<Student> students;

	/**
	 * Parameterized constructor.
	 * @param name Faculty name.
	 */
	public Faculty(String name) {
		super(name);
	}

}
