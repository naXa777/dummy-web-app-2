package by.naxa.demo.repositories;

import by.naxa.demo.model.Faculty;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Simple repository interface for {@link Faculty} instances. The interface is used to declare so called query methods,
 * methods to retrieve single entities or collections of them.
 * Created by phomal on 09.03.2015.
 */
public interface SimpleFacultyRepository extends PagingAndSortingRepository<Faculty, Long> {

	/**
	 * Find the faculty with the given name. This method will be translated into a query using the
	 * {@link javax.persistence.NamedQuery} annotation at the {@link Faculty} class.
	 *
	 * @param name Faculty name.
	 * @return The faculty or {@literal null} if none found.
	 */
	Faculty findByTheFacultyName(String name);

}
