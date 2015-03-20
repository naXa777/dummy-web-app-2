package by.naxa.demo.controller;

import by.naxa.demo.model.Faculty;
import by.naxa.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Faculty form controller.
 * Created by phomal on 10.03.2015.
 */
@Controller
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@RequestMapping(value="/create.do", method = RequestMethod.POST)
	public ModelAndView createNewFaculty(@ModelAttribute Faculty faculty,
	                                     final RedirectAttributes redirectAttributes,
	                                     final ModelAndView mav) {
		mav.setViewName("redirect:/faculty/list");

		facultyService.create(faculty);

		String message = "New faculty " + faculty.getName() + " was successfully created.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView facultyListPage() {
		ModelAndView mav = new ModelAndView("faculty-list");
		Iterable<Faculty> faculties = facultyService.findAll();
		mav.addObject("faculties", faculties);
		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editFacultyPage() {
		ModelAndView mav = new ModelAndView("faculty-edit");
		mav.addObject("faculty", new Faculty());
		return mav;
	}

	/**
	 * Fill the Faculties table.
	 */
	@RequestMapping(value = "/init.do", method = RequestMethod.POST)
	public ModelAndView facultiesInit() {
		if (facultyService.isEmpty()) {
			String theLeedsFaculties[] = {
					"Faculty of Arts",
					"Faculty of Biological Science",
					"Faculty of Business",
					"Faculty of Engineering (includes the School of Computing)",
					"Faculty of Environment",
					"Faculty of Mathematics and Physical Sciences",
					"Faculty of Medicine and Health",
					"Faculty of Performance, Visual Arts and Communication"};
			for (String name : theLeedsFaculties)
				facultyService.create(new Faculty(name));
		}

		return new ModelAndView("redirect:/faculty/list");
	}

}
