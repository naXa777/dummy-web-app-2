package by.naxa.demo.service;

import by.naxa.demo.model.Faculty;
import by.naxa.demo.repositories.SimpleFacultyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Created by phomal on 10.03.2015.
 */
@Transactional
@Service
public class FacultyServiceImpl implements FacultyService {

	@Resource
	private SimpleFacultyRepository facultyRepository;

	@Override
	public Faculty create(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public Iterable<Faculty> findAll() {
		return facultyRepository.findAll();
	}

	@Override
	public Optional<Faculty> findById(Long id) {
		return Optional.ofNullable(facultyRepository.findOne(id));
	}

	@Override
	public Optional<Faculty> findByName(String name) {
		return facultyRepository.findByTheFacultyName(name);
	}

	@Override
	public boolean isEmpty() {
		return facultyRepository.count() <= 0;
	}
}
