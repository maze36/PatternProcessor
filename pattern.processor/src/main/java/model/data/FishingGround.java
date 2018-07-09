package model.data;

import java.util.ArrayList;

import model.concaveHull.Point;

public class FishingGround {

	private ArrayList<Point> points;

	private String name;

	public FishingGround(String name) {
		this.points = new ArrayList<Point>();
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
	
	public boolean addPoint(Point point) {
		if(this.points != null) {
			return this.points.add(point);
		} else {
			this.points = new ArrayList<>();
			return this.points.add(point);
		}
	}

}
