package by.naxa.demo.service;

import by.naxa.demo.exception.FacultyNotFoundException;
import by.naxa.demo.model.Faculty;
import by.naxa.demo.repositories.SimpleFacultyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Created on 10.03.2015.
 * @author phomal
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
	public Faculty findById(Long id) throws FacultyNotFoundException {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        if (!faculty.isPresent())
            throw new FacultyNotFoundException(id);
		return faculty.get();
	}

	@Override
	public Faculty findByName(String name) throws FacultyNotFoundException {
        Optional<Faculty> faculty = facultyRepository.findByTheFacultyName(name);
        if (!faculty.isPresent())
            throw new FacultyNotFoundException(name);
        return faculty.get();
	}

	@Override
	public boolean isEmpty() {
		return facultyRepository.count() <= 0;
	}
}
