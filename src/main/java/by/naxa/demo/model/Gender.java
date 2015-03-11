package by.naxa.demo.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enumeration for reflecting {@link Student}'s gender.<br />
 *
 * Created on 10.03.2015.
 * @author phomal
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Gender {
	/** Male. */
	M("Male"),
	/** Female. */
	F("Female"),
	/** Gender is not known, or not specified. */
	UNKNOWN("Unknown");

	/**
	 * The string representation of this element in the enumeration.
	 */
	@Getter
	private final String name;
}
