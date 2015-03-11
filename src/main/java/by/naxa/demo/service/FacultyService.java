package by.naxa.demo.service;

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
	public Faculty create(Faculty faculty);

	/**
	 * Returns all instances of the Faculty type.
	 *
	 * @return all faculties
	 */
	public Iterable<Faculty> findAll();

	/**
	 * Retrieves a faculty by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the faculty with the given {@code id} or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public Faculty findById(Long id);

	/**
	 * Retrieves a faculty by its name.
	 *
	 * @param name must not be {@literal null}.
	 * @return the faculty with the given {@code name} or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code name} is {@literal null}
	 */
	public Faculty findByName(String name);


	/**
	 * Returns whether the faculty is empty.
	 *
	 * @return {@literal true} if the faculty is empty, {@literal false} otherwise.
	 */
	public boolean isEmpty();

}
