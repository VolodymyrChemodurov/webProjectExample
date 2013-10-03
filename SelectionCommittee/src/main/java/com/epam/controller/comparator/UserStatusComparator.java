package main.java.com.epam.controller.comparator;

import java.util.Comparator;

import main.java.com.epam.model.user.Status;
import main.java.com.epam.model.user.User;

public class UserStatusComparator implements Comparator<User>{

	@Override
	public int compare(User arg0, User arg1) {
		Status status0 = arg0.getStatus();
		Status status1 = arg1.getStatus();
		if(status0 == Status.ACCEPTED && status1 == Status.REJECTED)
			return -1;
		else if(status0 == Status.REJECTED && status1 == Status.ACCEPTED)
			return 1;
		return 0;
	}

}
