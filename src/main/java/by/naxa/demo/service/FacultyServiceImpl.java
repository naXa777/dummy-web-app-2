package by.naxa.demo.service;

import by.naxa.demo.model.Faculty;
import by.naxa.demo.repositories.SimpleFacultyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
	public Faculty findById(Long id) {
		return facultyRepository.findOne(id);
	}

	@Override
	public Faculty findByName(String name) {
		return facultyRepository.findByTheFacultyName(name);
	}

	@Override
	public boolean isEmpty() {
		return facultyRepository.count() <= 0;
	}
}
