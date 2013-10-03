package main.java.com.epam.model.marksheet;

public class MarkSheet {
	private int certificate;
	private int mathematics;
	private int physics;
	private int english;
	private int ukrainian;
	private double avgMark;
	
	public int getCertificate() {
		return certificate;
	}
	public void setCertificate(int certificate) {
		this.certificate = certificate;
	}
	public int getMathematics() {
		return mathematics;
	}
	public void setMathematics(int mathematics) {
		this.mathematics = mathematics;
	}
	public int getPhysics() {
		return physics;
	}
	public void setPhysics(int physics) {
		this.physics = physics;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getUkrainian() {
		return ukrainian;
	}
	public void setUkrainian(int ukrainian) {
		this.ukrainian = ukrainian;
	}
	public double getAvgMark() {
		return avgMark;
	}
	public void setAvgMark(double avgMark) {
		this.avgMark = avgMark;
	}

}
