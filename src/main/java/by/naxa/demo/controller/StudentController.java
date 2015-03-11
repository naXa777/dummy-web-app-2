package by.naxa.demo.controller;

import by.naxa.demo.exception.StudentNotFoundException;
import by.naxa.demo.model.Faculty;
import by.naxa.demo.model.Rate;
import by.naxa.demo.model.Student;
import by.naxa.demo.service.FacultyService;
import by.naxa.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;

/**
 * Created by phomal on 10.03.2015.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private FacultyService facultyService;

	@RequestMapping(value="/create", method = RequestMethod.POST)
	public ModelAndView createNewStudent(
			@ModelAttribute Student student,
			@RequestParam(value="rates", required = false) String ratesString,
			final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("redirect:/index.html");

		studentService.create(student);

		String message = "New student " + student.getName() + " was successfully created.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView studentListPage() {
		ModelAndView mav = new ModelAndView("student-list");

		Iterable<Student> students = studentService.findAll();
		mav.addObject("students", students);

		return mav;
	}

	@RequestMapping(value = "/edit/{id:.+}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("student-edit");

		Student student = (id > 0)? studentService.findById(id) : new Student();
		mav.addObject("student", student);

		Iterable<Faculty> faculties = facultyService.findAll();
		mav.addObject("faculties", faculties);

		Collection<Rate> rates = student.getRates();
		String ratesString = StringUtils.collectionToDelimitedString(rates, " ");
		mav.addObject("rates", ratesString);

		return mav;
	}

	@RequestMapping(value = "/edit/{id:.+}", method = RequestMethod.POST)
	public ModelAndView editStudent(
			@ModelAttribute Student student,
			@RequestParam(value="rates", required = false) String ratesString,
			@PathVariable Long id,
			final RedirectAttributes redirectAttributes) throws StudentNotFoundException {
		ModelAndView mav = new ModelAndView("redirect:/index.html");

		studentService.update(student);

		String msg = "Student was successfully updated";
		redirectAttributes.addFlashAttribute("message", msg);
		return mav;
	}

	@RequestMapping(value = "/delete/{id:.+}", method = RequestMethod.POST)
	public ModelAndView deleteStudent(
			@PathVariable Long id,
			final RedirectAttributes redirectAttributes) throws StudentNotFoundException {
		ModelAndView mav = new ModelAndView("redirect:/index.html");

		Student student = studentService.delete(id);

		String msg = "The student " + student.getName() + " was successfully deleted.";
		redirectAttributes.addFlashAttribute("message", msg);
		return mav;
	}

}
