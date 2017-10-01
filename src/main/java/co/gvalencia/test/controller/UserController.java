package co.gvalencia.test.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.gvalencia.test.model.User;
import co.gvalencia.test.service.UserService;

@Controller
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	UserService userService = new UserService();

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<User>> listUsers() {
		List<User> users = userService.list();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<User> createUser(@RequestBody User user) {
		user = userService.create(user);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<User> delete(@PathVariable String id) {
		int response = userService.delete(id);
		if (response == 200) {
			return new ResponseEntity<User>((User) null, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>((User) null, HttpStatus.NOT_FOUND);
		}

	}

}
