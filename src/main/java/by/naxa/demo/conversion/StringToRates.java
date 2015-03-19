package by.naxa.demo.conversion;

import net.jcip.annotations.ThreadSafe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
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
public class StringToRates implements Converter<String, Set<Integer>> {

	/**
	 * @param source a string with whitespace- or comma-separated numbers.
	 * @return a collection of rates.
	 */
	@Override
	public Set<Integer> convert(String source) {
		String rates[] = source.split("[ \\[\\],]");
		if (rates.length > 0 && !StringUtils.isEmpty(rates[0]))
			return Arrays.asList(rates).stream()
					.map(Integer::parseInt)
					.collect(Collectors.toSet());
		else
			return Collections.emptySet();
	}
}
