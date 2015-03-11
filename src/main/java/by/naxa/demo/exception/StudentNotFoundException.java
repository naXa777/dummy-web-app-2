package by.naxa.demo.exception;

import org.springframework.dao.EmptyResultDataAccessException;

/**
 * Created on 10.03.2015.
 * @author phomal
 */
public class StudentNotFoundException extends EmptyResultDataAccessException {

	private static final long serialVersionUID = -81460315521662721L;

	public StudentNotFoundException(Long id) {
		super(String.format("No Student entity with id %s exists!", id), 1);
	}

}
