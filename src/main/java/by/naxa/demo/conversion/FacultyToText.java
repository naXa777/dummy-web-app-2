package by.naxa.demo.conversion;

import by.naxa.demo.model.Faculty;
import net.jcip.annotations.ThreadSafe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

/**
 * Created on 18.03.2015.
 * @author phomal
 */
@ThreadSafe
@Component
@WritingConverter
public class FacultyToText implements Converter<Faculty, String> {

	/**
	 * @param source a faculty.
	 * @return a faculty text representation (its name).
	 */
	@Override
	public String convert(Faculty source) {
		return source.getName();
	}
}
