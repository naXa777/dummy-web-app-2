package by.naxa.demo.conversion;

import by.naxa.demo.model.Faculty;
import by.naxa.demo.service.FacultyService;
import net.jcip.annotations.ThreadSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

/**
 * Created by phomal on 18.03.2015.
 */
@ThreadSafe
@Component
@ReadingConverter
public class IdToFaculty implements Converter<String, Faculty> {

	@Autowired
	private FacultyService facultyService;

	/**
	 * @param source a faculty ID as string.
	 * @return a faculty.
	 */
	@Override
	public Faculty convert(String source) throws IllegalArgumentException {
		Long id = Long.parseLong(source);
		Faculty result = facultyService.findById(id);
		if (result == null)
			throw new IllegalArgumentException(String.format("Faculty with id=%d not found.", id));
		return result;
	}
}
