package by.naxa.demo.repositories;

import by.naxa.demo.model.Rate;
import by.naxa.demo.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Simple repository interface for {@link Rate} instances. The interface is used to declare so called query methods,
 * methods to retrieve single entities or collections of them.
 * Created by phomal on 10.03.2015.
 */
public interface SimpleRateRepository extends CrudRepository<Rate, Long> {

	/**
	 * Returns all rates of the given student. This method will be translated into a query using
	 * the {@link Query} annotation declared one.
	 *
	 * @param student Student
	 * @return List of rates.
	 */
	@Query("select r from Rate r where r.student = :student")
	List<Rate> findByStudent(@Param("student") Student student);

	/**
	 * Deletes all rates of the given student. This method will be translated into a query using
	 * the {@link Query} annotation declared one.
	 *
	 * @param student Student
	 */
	@Query("delete from Rate r where r.student = :student")
	void deleteByStudent(@Param("student") Student student);

}
