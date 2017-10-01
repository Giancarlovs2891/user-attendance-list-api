package co.gvalencia.test.service;

import java.util.ArrayList;
import java.util.List;

import co.gvalencia.test.data.Data;
import co.gvalencia.test.model.User;
import co.gvalencia.test.model.User.UserStatus;

public class UserService {
	
	public List<User> list(){
		List<User> users = new ArrayList<>();
		for (User user : Data.USER){
			if(user.getStatus().equals(UserStatus.ACTIVE)){
				users.add(user);
			}
		}		
		return users;
	}

	public User create(User user) {
		try {
			if (!exist(user.getId())) {
				user.setStatus(UserStatus.ACTIVE);
				Data.USER.add(user);
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
			return null;
		}
	}

	public int delete(String id) {
		List<User> users = Data.USER;
		for (User user : users) {
			if (user.getId().equals(id)) {
				user.setStatus(UserStatus.INACTIVE);;
				return 200;
			}
		}
		return 404;
	}

	private boolean exist(String id) {
		List<User> users = Data.USER;
		for (User user : users) {
			if (user.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

}
