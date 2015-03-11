package by.naxa.demo.repositories;

import by.naxa.demo.model.Faculty;
import by.naxa.demo.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Simple repository interface for {@link Student} instances. The interface is used to declare so called query methods,
 * methods to retrieve single entities or collections of them.
 * Created by phomal on 09.03.2015.
 */
public interface SimpleStudentRepository extends PagingAndSortingRepository<Student, Long> {

	/**
	 * Find the student with the given name. This method will be translated into a query using the
	 * {@link javax.persistence.NamedQuery} annotation at the {@link Student} class.
	 *
	 * @param name Student's name.
	 * @return The student.
	 */
	Student findByTheStudentsName(String name);

	/**
	 * Returns all students from the given faculty. This method will be translated into a query using
	 * the {@link Query} annotation declared one.
	 *
	 * @param faculty Faculty
	 * @return List of students.
	 */
	@Query("select s from Student s where s.faculty = :faculty")
	List<Student> findByFaculty(@Param("faculty") Faculty faculty);

}
