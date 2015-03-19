package by.naxa.demo.conversion;

import net.jcip.annotations.ThreadSafe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.stream.Collectors.joining;

/**
 * Converter from a collection of integer rates to a string (for a text input on a form).
 *
 * Created on 17.03.2015.
 *
 * @author phomal
 */
@ThreadSafe
@Component
@WritingConverter
public class RatesToString implements Converter<Set<Integer>, String> {

	/**
	 * @param source a collection of rates.
	 * @return a string with whitespace-separated integers.
	 */
	@Override
	public String convert(Set<Integer> source) {
		return source.stream()
				.map(Object::toString)
				.collect(joining(" "));
	}
}
