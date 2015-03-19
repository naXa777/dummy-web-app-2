package by.naxa.demo.service;

import by.naxa.demo.exception.StudentNotFoundException;
import by.naxa.demo.model.Faculty;
import by.naxa.demo.model.Student;
import by.naxa.demo.repositories.SimpleStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Student service backed by {@link SimpleStudentRepository}.
 * Created by phomal on 10.03.2015.
 */
@Transactional
@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	private SimpleStudentRepository studentRepository;

	@Override
	public Student create(Student student) {
		return studentRepository.save(student);
	}

	@Override
	@Transactional(rollbackFor = StudentNotFoundException.class)
	public Student delete(Long id) throws StudentNotFoundException {
		Student deletedStudent = studentRepository.findOne(id);
		if (deletedStudent == null)
			throw new StudentNotFoundException(id);

		studentRepository.delete(deletedStudent);

		return deletedStudent;
	}

	@Override
	public Iterable<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = StudentNotFoundException.class)
	public Student update(Student student) throws StudentNotFoundException {
		Student updatedStudent = studentRepository.findOne(student.getId());
		if (updatedStudent == null)
			throw new StudentNotFoundException(student.getId());

		updatedStudent.setName(student.getName());
		updatedStudent.setFaculty(student.getFaculty());
		updatedStudent.setPhoto(student.getPhoto());
		updatedStudent.setRates(student.getRates());
		updatedStudent = studentRepository.save(updatedStudent);

		return updatedStudent;
	}

	@Override
	public Student findById(Long id) {
		return studentRepository.findOne(id);
	}

	@Override
	public Iterable<Student> findByFaculty(Faculty faculty) {
		return studentRepository.findByFaculty(faculty);
	}

}
