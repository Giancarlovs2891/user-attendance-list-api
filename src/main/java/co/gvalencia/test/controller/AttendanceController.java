package co.gvalencia.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.gvalencia.test.data.Data;
import co.gvalencia.test.model.Attendance;
import co.gvalencia.test.service.AttendanceService;

@Controller
@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	
	AttendanceService attendanceService = new AttendanceService();
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
		System.out.println(attendance);
		attendance = attendanceService.create(attendance);
		if (attendance != null) {
			System.out.println(Data.ATTENDANCE.size());
			return new ResponseEntity<Attendance>(attendance, HttpStatus.OK);
		} else {
			return new ResponseEntity<Attendance>(attendance, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
