package co.gvalencia.test.service;

import java.util.ArrayList;
import java.util.List;

import co.gvalencia.test.data.Data;
import co.gvalencia.test.model.Attendance;

public class AttendanceService {

	public Attendance create(Attendance attendance) {
		try {
			if (!exist(attendance.getUserId(), attendance.getDate())) {
				Data.ATTENDANCE.add(attendance);
				return attendance;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
			return null;
		}
	}

	public List<Attendance> report(String dateFrom, String dateTo) {
		dateFrom = reverseDate(dateFrom);
		dateTo = reverseDate(dateTo);
		UserService userService = new UserService();
		List<Attendance> attendances = new ArrayList<Attendance>();
		for (Attendance attendance : Data.ATTENDANCE) {
			String currentDate = reverseDate(attendance.getDate());
			if ((currentDate.compareTo(dateFrom) >= 0 && currentDate.compareTo(dateTo) <= 0) && userService.exist(attendance.getUserId())) {
				attendances.add(attendance);
			}
		}
		return attendances;
	}

	private boolean exist(String userId, String date) {
		List<Attendance> attendances = Data.ATTENDANCE;
		for (Attendance attendance : attendances) {
			if (attendance.getUserId().equals(userId) && attendance.getDate().equals(date)) {
				return true;
			}
		}
		return false;
	}

	private String reverseDate(String date) {
		String[] sd = date.split("-");
		date = sd[2] + "-" + sd[1] + "-" + sd[0];
		return date;
	}

}
