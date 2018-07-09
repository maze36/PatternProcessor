package app;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.vividsolutions.jts.geom.GeometryFactory;

import input.CSVReader;
import model.concaveHull.ConcaveHull;
import model.concaveHull.Point;
import model.data.FishingGround;

public class PatternProcesser {

	final static Logger logger = Logger.getLogger(PatternProcesser.class.getName());

	
	public static void main(String[] args) {

		
		System.out.println("****************************** \n"
				+ "* Starting Pattern Processor *\n"
				+ "******************************");
		
		ArrayList<FishingGround> fishingGrounds = CSVReader.readFishingGrounds("input");
		ArrayList<Point> points = CSVReader.readingTrackData("input/track/track.csv");
		ConcaveHull concaveHulle = new ConcaveHull();
		
		ArrayList<Point> result = concaveHulle.calculateConcaveHull(points, 3);
		
		GeometryFactory factory = new GeometryFactory();
		
		
		
		System.out.println(result.size());

	}

}
