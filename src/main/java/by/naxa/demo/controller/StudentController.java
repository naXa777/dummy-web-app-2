package by.naxa.demo.controller;

import by.naxa.demo.exception.StudentNotFoundException;
import by.naxa.demo.model.Faculty;
import by.naxa.demo.model.Gender;
import by.naxa.demo.model.Student;
import by.naxa.demo.service.FacultyService;
import by.naxa.demo.service.StudentService;
import by.naxa.demo.validation.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by phomal on 10.03.2015.
 */
@Controller
@RequestMapping(value = "/student")
@SessionAttributes(types = Student.class)
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private FacultyService facultyService;
	@Autowired
	private StudentValidator validator;

	/**
	 * Without this user can set any Student fields they want with a custom HTTP POST query.
	 */
	@InitBinder
	void allowFields(final WebDataBinder binder) {
		binder.setAllowedFields("name", "photo", "rates", "faculty", "gender");
		binder.setValidator(validator);
	}

	@RequestMapping(value="/create", method = RequestMethod.POST)
	public ModelAndView createNewStudent(
			@Validated @ModelAttribute Student student,
			final BindingResult result,
			final HttpServletRequest request,
			final RedirectAttributes redirectAttributes,
			final SessionStatus session) {
		ModelAndView mav;

		if (result.hasErrors()) {
			// incorrect
			String referrer = request.getHeader("Referer"); // sic!
			mav = new ModelAndView("redirect:" + referrer);

			mav.getModelMap().addAttribute(student);

			Iterable<Faculty> faculties = facultyService.findAll();
			mav.addObject("faculties", faculties);

			mav.addObject("genders", Gender.values());
		} else {
			// ok
			mav = new ModelAndView("redirect:/student/list");

			student = studentService.create(student);

			session.setComplete();
			String message = "New student " + student.getName() + " was successfully created.";
			redirectAttributes.addFlashAttribute("message", message);
		}
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
		mav.getModelMap().addAttribute(student);

		Iterable<Faculty> faculties = facultyService.findAll();
		mav.addObject("faculties", faculties);

		mav.addObject("genders", Gender.values());

		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editStudent(
			@Validated @ModelAttribute Student student,
			final BindingResult result,
			final HttpServletRequest request,
			final RedirectAttributes redirectAttributes,
			final SessionStatus session) throws StudentNotFoundException {
		if (result.hasErrors()) {
			String referrer = request.getHeader("Referer"); // sic!
			return new ModelAndView("redirect:" + referrer);
		}

		ModelAndView mav = new ModelAndView("redirect:/student/list");

		studentService.update(student);

		session.setComplete();
		String msg = "Student was successfully updated";
		redirectAttributes.addFlashAttribute("message", msg);
		return mav;
	}

	@RequestMapping(value = "/delete/{id:.+}", method = RequestMethod.DELETE)
	public ModelAndView deleteStudent(
			@PathVariable Long id,
			final RedirectAttributes redirectAttributes) throws StudentNotFoundException {
		ModelAndView mav = new ModelAndView("redirect:/student/list");

		Student student = studentService.delete(id);

		String msg = "The student " + student.getName() + " was successfully deleted.";
		redirectAttributes.addFlashAttribute("message", msg);
		return mav;
	}

}
