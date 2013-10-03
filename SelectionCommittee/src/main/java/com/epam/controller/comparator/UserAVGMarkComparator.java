package main.java.com.epam.controller.comparator;

import java.util.Comparator;

import main.java.com.epam.model.user.User;

public class UserAVGMarkComparator implements Comparator<User>{

	@Override
	public int compare(User arg0, User arg1) {
		if(arg0.getMarks().getAvgMark() < arg1.getMarks().getAvgMark())
			return 1;
		else if(arg0.getMarks().getAvgMark() > arg1.getMarks().getAvgMark())
			return -1;
		return 0;
	}

}
