package by.naxa.demo.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown to indicate that a method has failed to find a student.
 *
 * Created on 10.03.2015.
 * @author phomal
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends EmptyResultDataAccessException {

	/**
	 * Constructs a new exception with a detail message, which contains the specified id.
	 *
	 * @param  id the ID of a non-existent Student entity.
	 */
	public StudentNotFoundException(Long id) {
		super(String.format("No Student entity with id %s exists!", id), 1);
	}

}
