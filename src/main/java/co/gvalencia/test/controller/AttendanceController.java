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

import co.gvalencia.test.data.Data;
import co.gvalencia.test.model.Attendance;
import co.gvalencia.test.service.AttendanceService;
import co.gvalencia.test.service.UserService;

@Controller
@RestController
@RequestMapping("/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

	AttendanceService attendanceService = new AttendanceService();
	UserService userService = new UserService();

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
		System.out.println(attendance);
		if (userService.exist(attendance.getUserId())) {
			attendance = attendanceService.create(attendance);
			if (attendance != null) {
				System.out.println(Data.ATTENDANCE.size());
				return new ResponseEntity<Attendance>(attendance, HttpStatus.OK);
			} else {
				return new ResponseEntity<Attendance>(attendance, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<Attendance>(attendance, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/from/{dateFrom}/to/{dateTo}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Attendance>> listUsers(@PathVariable String dateFrom, @PathVariable String dateTo) {
		List<Attendance> attendances = attendanceService.report(dateFrom, dateTo);
		return new ResponseEntity<List<Attendance>>(attendances, HttpStatus.OK);
	}

}
