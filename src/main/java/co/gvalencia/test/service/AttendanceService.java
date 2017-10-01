package co.gvalencia.test.service;

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

	public List<Attendance> report(String date) {
		// TODO Auto-generated method stub
		return null;
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

}
