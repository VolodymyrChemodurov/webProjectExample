package main.java.com.epam.controller.setters;

import main.java.com.epam.model.marksheet.MarkSheet;

public enum MarkSheetSetter {
	CERTIFICATE("certificate") {
		public void setField(MarkSheet markSheet, String value) {
			markSheet.setCertificate(Integer.parseInt(value));
		}
	},
	ENGLISH("english") {
		public void setField(MarkSheet markSheet, String value) {
			markSheet.setEnglish(Integer.parseInt(value));
		}
	},
	MATHEMATICS("mathematics") {
		public void setField(MarkSheet markSheet, String value) {
			markSheet.setMathematics(Integer.parseInt(value));
		}
	},
	PHYSICS("physics") {
		public void setField(MarkSheet markSheet, String value) {
			markSheet.setPhysics(Integer.parseInt(value));
		}
	},
	UKRAINIAN("ukrainian") {
		public void setField(MarkSheet markSheet, String value) {
			markSheet.setUkrainian(Integer.parseInt(value));
		}
	};
	
	private String value;
	
	private MarkSheetSetter(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public void setField(MarkSheet markSheet, String value) {
		return;
	}
}
