package by.naxa.demo.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown to indicate that a method has failed to find a faculty.
 *
 * Created on 09.07.2015.
 * @author phomal
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class FacultyNotFoundException extends EmptyResultDataAccessException {

	/**
	 * Constructs a new exception with a detail message, which contains the specified id.
	 *
	 * @param  id the ID of a non-existent Faculty entity.
	 */
	public FacultyNotFoundException(Long id) {
		super(String.format("No Faculty entity with id %s exists!", id), 1);
	}

    /**
     * Constructs a new exception with a detail message, which contains the specified name.
     *
     * @param  name the name of a non-existent Faculty entity.
     */
    public FacultyNotFoundException(String name) {
        super(String.format("No Faculty entity with name '%s' exists!", name), 1);
    }

}
