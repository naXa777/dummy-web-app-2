package by.naxa.demo.exception;

import org.springframework.dao.EmptyResultDataAccessException;

/**
 * Thrown to indicate that a method has failed to find a student.
 *
 * Created on 10.03.2015.
 * @author phomal
 */
public class StudentNotFoundException extends EmptyResultDataAccessException {

	private static final long serialVersionUID = -81460315521662721L;

	/**
	 * Constructs a new exception with a detail message, which contains the specified id.
	 *
	 * @param  id the ID of a non-existent Student entity.
	 */
	public StudentNotFoundException(Long id) {
		super(String.format("No Student entity with id %s exists!", id), 1);
	}

}
