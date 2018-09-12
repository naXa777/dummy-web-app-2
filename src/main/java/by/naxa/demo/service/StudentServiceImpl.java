package by.naxa.demo.service;

import by.naxa.demo.exception.StudentNotFoundException;
import by.naxa.demo.model.Faculty;
import by.naxa.demo.model.Student;
import by.naxa.demo.repositories.SimpleStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

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
		Optional<Student> deletedStudent = studentRepository.findById(id);
		if (!deletedStudent.isPresent())
			throw new StudentNotFoundException(id);

		studentRepository.delete(deletedStudent.get());

		return deletedStudent.get();
	}

	@Override
	public Iterable<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = StudentNotFoundException.class)
	public Student update(Student student) throws StudentNotFoundException {
		Optional<Student> updatedStudentOpt = studentRepository.findById(student.getId());
		if (!updatedStudentOpt.isPresent())
			throw new StudentNotFoundException(student.getId());

		final Student updatedStudent = updatedStudentOpt.get();
		updatedStudent.setName(student.getName());
		updatedStudent.setGender(student.getGender());
		updatedStudent.setBirthday(student.getBirthday());
		updatedStudent.setPhone(student.getPhone());
		updatedStudent.setFaculty(student.getFaculty());
		updatedStudent.setPhoto(student.getPhoto());
		updatedStudent.setRates(student.getRates());

		return studentRepository.save(updatedStudent);
	}

	@Override
	public Student findById(Long id) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent())
            throw new StudentNotFoundException(id);
		return student.get();
	}

	@Override
	public Iterable<Student> findByFaculty(Faculty faculty) {
		return studentRepository.findByFaculty(faculty);
	}

}
