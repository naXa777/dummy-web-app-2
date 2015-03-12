package by.naxa.demo.service;

import by.naxa.demo.exception.StudentNotFoundException;
import by.naxa.demo.model.Faculty;
import by.naxa.demo.model.Student;

/**
 * StudentService interface that is used in the Controller.
 * Created by phomal on 10.03.2015.
 */
public interface StudentService {

	/**
	 * Saves a given student. Use the returned instance for further operations as the save operation
	 * might have changed the entity instance completely.
	 *
	 * @param student for saving.
	 * @return the saved student.
	 */
	public Student create(Student student);

	/**
	 * Deletes the student with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @return a detached student entity.
	 * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
	 * @throws StudentNotFoundException in case there is no student with the given {@code id}
	 */
	public Student delete(Long id) throws StudentNotFoundException;

	/**
	 * Returns all instances of the Student type.
	 *
	 * @return all students.
	 */
	public Iterable<Student> findAll();

	/**
	 * Updates a given student. Use the returned instance for further operations as the update operation
	 * might have changed the entity instance completely.
	 *
	 * @param student for updating.
	 * @return the updated student
	 * @throws IllegalArgumentException in case the given entity is (@literal null}
	 * @throws StudentNotFoundException in case there is no student with the given {@code id}
	 */
	public Student update(Student student) throws StudentNotFoundException;

	/**
	 * Retrieves a student by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the student with the given {@code id} or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public Student findById(Long id);

	/**
	 * Retrieves students by their faculty.
	 *
	 * @param faculty must not be {@literal null}.
	 * @return a list of students from the given faculty
	 * @throws IllegalArgumentException if {@code faculty} is {@literal null}
	 */
	public Iterable<Student> findByFaculty(Faculty faculty);

}
