package by.naxa.demo.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter from a string (from a text input on a form) to a collection of integer rates.
 *
 * Created on 17.03.2015.
 *
 * @author phomal
 */
@Component
@ReadingConverter
public class StringToRates implements Converter<String, List<Integer>> {

	/**
	 * @param source a string with whitespace-separated integers.
	 * @return a collection of rates.
	 */
	@Override
	public List<Integer> convert(String source) {
		String rates[] = source.split(" ");
		if (rates.length > 0)
			try {
				return Arrays.asList(rates).stream()
						.map(Integer::parseInt)
						.collect(Collectors.toList());
			} catch (NumberFormatException exc) {
				throw new IllegalArgumentException(
						String.format("Input string (%s) contains illegal characters.", source), exc);
			}
		else
			return null;
	}
}
