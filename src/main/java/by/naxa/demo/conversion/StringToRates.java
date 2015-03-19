package by.naxa.demo.conversion;

import net.jcip.annotations.ThreadSafe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Converter from a string (from a text input on a form) to a collection of integer rates.
 *
 * Created on 17.03.2015.
 *
 * @author phomal
 */
@ThreadSafe
@Component
@ReadingConverter
public class StringToRates implements Converter<String, Collection<Integer>> {

	/**
	 * @param source a string with whitespace- or comma-separated numbers.
	 * @return a collection of rates.
	 */
	@Override
	public Collection<Integer> convert(String source) {
		String rates[] = source.split("[ \\[\\],]");
		return Arrays.asList(rates).stream()
				.filter(s -> !s.isEmpty())
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}
