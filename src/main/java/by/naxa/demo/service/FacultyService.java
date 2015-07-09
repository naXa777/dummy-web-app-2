package by.naxa.demo.service;

import by.naxa.demo.exception.FacultyNotFoundException;
import by.naxa.demo.model.Faculty;

/**
 * StudentService interface that is used in the Controller.
 * Created by phomal on 10.03.2015.
 */
public interface FacultyService {

	/**
	 * Saves a given faculty. Use the returned instance for further operations as the save operation
	 * might have changed the entity instance completely.
	 *
	 * @param faculty for saving
	 * @return the saved faculty
	 */
	Faculty create(Faculty faculty);

	/**
	 * Returns all instances of the Faculty type.
	 *
	 * @return all faculties
	 */
	Iterable<Faculty> findAll();

	/**
	 * Retrieves a faculty by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the faculty with the given {@code id} or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	Faculty findById(Long id) throws FacultyNotFoundException;

	/**
	 * Retrieves a faculty by its name.
	 *
	 * @param name must not be {@literal null}.
	 * @return the faculty with the given {@code name} or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code name} is {@literal null}
	 */
	Faculty findByName(String name) throws FacultyNotFoundException;

	/**
	 * Returns whether the faculty is empty.
	 *
	 * @return {@literal true} if the faculty is empty, {@literal false} otherwise.
	 */
	boolean isEmpty();

}
