package by.naxa.demo.validation;

import by.naxa.demo.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Validates:
 *   - Student.rates should be between 0 and 10;
 *   - Student.name should be not empty
 *
 * Created on 17.03.2015.
 * @author phomal
 */
@Component
public class StudentValidator implements Validator {

	public static final String RATES = "rates";

	/**
	 * Validator validates Student instances, and any subclasses of Student too.
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Student студень = (Student) target;

		Iterable<Integer> rates = студень.getRates();
		for (Integer rate : rates)
			if (rate < 0)
				errors.rejectValue(RATES, "student.rates.negative");
			else if (rate > 10)
				errors.rejectValue(RATES, "student.rates.moreThanTen");
	}
}
