package in.ravikalla.cloudBank.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.ravikalla.cloudBank.domain.Appointment;
import in.ravikalla.cloudBank.domain.User;
import in.ravikalla.cloudBank.service.AppointmentService;
import in.ravikalla.cloudBank.service.UserService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	private static final Logger L = LogManager.getLogger(AppointmentController.class);

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String createAppointment(Model model) {
		L.debug("35 : Start : AppointmentController.createAppointment(...)");

		Appointment appointment = new Appointment();
		model.addAttribute("appointment", appointment);
		model.addAttribute("dateString", "");

		L.debug("41 : End : AppointmentController.createAppointment(...)");
		return "appointment";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String createAppointmentPost(@ModelAttribute("appointment") Appointment appointment, @ModelAttribute("dateString") String date, Model model, Principal principal) throws ParseException {
		L.debug("47 : Start : AppointmentController.createAppointmentPost(...)");

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date d1 = format1.parse( date );
		appointment.setDate(d1);

		User user = userService.findByUsername(principal.getName());
		appointment.setUser(user);

		appointmentService.createAppointment(appointment);

		L.debug("58 : End : AppointmentController.createAppointmentPost(...)");
		return "redirect:/userFront";
	}
}
