package by.naxa.demo.conversion;

import by.naxa.demo.model.Faculty;
import by.naxa.demo.service.FacultyService;
import net.jcip.annotations.ThreadSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

/**
 * Created on 18.03.2015.
 * @author phomal
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
        return facultyService.findById(id);
	}
}
