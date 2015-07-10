package by.naxa.demo.controller;

import by.naxa.demo.exception.StudentNotFoundException;
import by.naxa.demo.model.Faculty;
import by.naxa.demo.model.Gender;
import by.naxa.demo.model.Student;
import by.naxa.demo.service.FacultyService;
import by.naxa.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Student form controller.
 * Created by phomal on 10.03.2015.
 */
@Controller
@RequestMapping(value = "/student")
@SessionAttributes(types = {Student.class, Faculty.class, Gender[].class})
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private FacultyService facultyService;
	@Autowired
	@Qualifier("studentValidator")
	private Validator validator;

	/**
	 * Without this user can set any Student fields they want with a custom HTTP POST query.
	 */
	@InitBinder("student")
	void initBinder(final WebDataBinder binder) {
		//binder.setAllowedFields("name", "photo", "rates", "faculty", "gender", "birthday", "phone");
		binder.setValidator(validator);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(true);
		boolean allowEmpty;
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, allowEmpty = false));

		// tell Spring to set empty values as null instead of empty string.
		//binder.registerCustomEditor( String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(value="/create.do", method = RequestMethod.POST)
	public ModelAndView createNewStudent(
			@Valid @ModelAttribute Student student,
			final BindingResult result,
			final RedirectAttributes redirectAttributes,
			final SessionStatus session,
			final ModelAndView mav) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
			mav.setViewName("student-edit");
		} else {
			mav.setViewName("redirect:/student/list");

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

    @RequestMapping(value = "/list/json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Student> studentList() {
        return studentService.findAll();
    }

    @RequestMapping(value = "/{id:[0-9]+}/json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Student student(@PathVariable Long id) throws StudentNotFoundException {
        return studentService.findById(id);
    }

	@RequestMapping(value = "/edit/{id:.+}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(
			@PathVariable Long id,
	        final ModelAndView mav) {
		mav.setViewName("student-edit");

		Student student = (id > 0)? studentService.findById(id) : new Student();
		mav.getModelMap().addAttribute(student);

		Iterable<Faculty> faculties = facultyService.findAll();
		mav.addObject("faculties", faculties);

		mav.addObject("genders", Gender.values());

		return mav;
	}

	@RequestMapping(value = "/edit.do", method = RequestMethod.POST)
	public ModelAndView editStudent(
			@Valid @ModelAttribute Student student,
			final BindingResult result,
			final RedirectAttributes redirectAttributes,
			final SessionStatus session,
			final ModelAndView mav) throws StudentNotFoundException {

		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
			mav.setViewName("student-edit");
			return mav;
		} else {
			mav.setViewName("redirect:/student/list");

			studentService.update(student);
			session.setComplete();

			String msg = "Student was successfully updated";
			redirectAttributes.addFlashAttribute("message", msg);
		}

		return mav;
	}

	@RequestMapping(value = "/delete/{id:.+}.do", method = RequestMethod.DELETE)
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
