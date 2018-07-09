package model.data;

import java.util.ArrayList;

import model.concaveHull.Point;

public class FishingGround {

	private ArrayList<Point> points;

	private String name;

	public FishingGround(ArrayList<Point> points, String name) {
		this.setPoints(points);
		this.setName(name);
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
