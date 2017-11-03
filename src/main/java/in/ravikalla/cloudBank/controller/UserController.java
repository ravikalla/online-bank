package in.ravikalla.cloudBank.controller;

import java.security.Principal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.ravikalla.cloudBank.domain.User;
import in.ravikalla.cloudBank.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger L = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Principal principal, Model model) {
		L.debug("27 : Start : UserController.profile(...)");

		User user = userService.findByUsername(principal.getName());

		model.addAttribute("user", user);

		L.debug("33 : End : UserController.profile(...)");
		return "profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String profilePost(@ModelAttribute("user") User newUser, Model model) {
		L.debug("39 : Start : UserController.profilePost(...)");

		User user = userService.findByUsername(newUser.getUsername());
		user.setUsername(newUser.getUsername());
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		user.setEmail(newUser.getEmail());
		user.setPhone(newUser.getPhone());

		model.addAttribute("user", user);

		userService.saveUser(user);

		L.debug("52 : End : UserController.profilePost(...)");
		return "profile";
	}
}

