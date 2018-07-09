package model;

import java.util.ArrayList;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;

import model.concaveHull.Point;

public class GeometryBuilder {

	private static final GeometryBuilder INSTANCE = new GeometryBuilder();
	
	private GeometryBuilder() {
		
	}
	
	public static GeometryBuilder getInstance() {
		return INSTANCE;
	}
	
	public Geometry buildGeometry(ArrayList<Point> points) {
		
		Coordinate[] coordinateSeq = convertIntoCoordArray(points);
		
		return new GeometryFactory().createPolygon(coordinateSeq);
	}

	private Coordinate[] convertIntoCoordArray(ArrayList<Point> points) {
		Coordinate[] coordinateSeq = new Coordinate[points.size()];
		
		for (int i = 0; i < coordinateSeq.length; i++) {
			coordinateSeq[0] = new Coordinate(points.get(i).getX(), points.get(i).getY());
		}
		
		return coordinateSeq;
	}
	
}
