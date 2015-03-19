package by.naxa.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	@Override
	public void initialize(Phone constraintAnnotation) {}

	@Override
	public boolean isValid(String phoneNo, ConstraintValidatorContext context) {
		if (phoneNo == null)
			return false;

				// phone number may start with +, 00, or 8
				// phone number may contain '.', ' ', and '-' separators
				// phone number should end with a digit
		return  (phoneNo.matches("^[\\+80](?:[0-9][-\\.\\s]?){6,14}[0-9]$")) ||
				// 7-digit phone number where area code (2 to 5 digits) is in brackets
				(phoneNo.matches("^[\\+80]?\\(\\d{2,5}\\)\\s?\\d{3}[-\\.\\s]?\\d{2}[-\\.\\s]?\\d{2}$"));
	}
}
