package main.java.com.epam.controller.setters;

import main.java.com.epam.model.user.User;

public enum UserSetter {
	FIRST_NAME("firstName") {
		public void setField(User user, String value) {
			user.setFirstName(value);
		}
	},
	LAST_NAME("lastName") {
		public void setField(User user, String value) {
			user.setLastName(value);
		}
	}, 
	LOGIN("login") {
		public void setField(User user, String value) {
			user.setLogin(value);
		}
	},
	PASSWORD("password") {
		public void setField(User user, String value) {
			user.setPassword(value);
		}
	};
	
	private String value;
	
	private UserSetter(String value) {
		this.value = value;  
	}

	public String getValue() {
		return value;
	}
	
	public void setField(User user, String value) {
		return;
	}
}
