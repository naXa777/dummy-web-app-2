package by.naxa.demo.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static java.util.stream.Collectors.joining;

/**
 * Converter from a collection of integer rates to a string (for a text input on a form).
 *
 * Created on 17.03.2015.
 *
 * @param <S> the type of input values.
 * @author phomal
 */
@Component
@WritingConverter
public class RatesToString<S extends Collection<Integer>> implements Converter<S, String> {

	/**
	 * @param source a collection of rates.
	 * @return a string with whitespace-separated integers.
	 */
	@Override
	public String convert(S source) {
		return source.stream()
				.map(Object::toString)
				.collect(joining(" "));
	}
}
