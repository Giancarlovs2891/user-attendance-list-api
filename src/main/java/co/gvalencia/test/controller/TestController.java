package co.gvalencia.test.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.gvalencia.test.model.User;
import co.gvalencia.test.model.User.UserStatus;

@Controller
@RestController
@RequestMapping("/hello")
public class TestController {

	@RequestMapping(value = "/test", 
					method = RequestMethod.GET)
	public @ResponseBody User test() {
		User user = new User();
		user.setStatus(UserStatus.ACTIVE);
		return user;
	}
	
	@RequestMapping(value = "/user", 
					method = RequestMethod.POST, 
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User getUser(@RequestBody User user){
		user.setStatus(UserStatus.ACTIVE);
		return user;
	}
}
