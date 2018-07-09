package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import app.PatternProcesser;
import model.concaveHull.Point;
import model.data.FishingGround;

public class CSVReader {

	private static String LINE = "";

	private final static String SPLITTER = ",";

	private final static Logger logger = Logger.getLogger(PatternProcesser.class.getName());
	
	public static ArrayList<FishingGround> readFishingGrounds(String path) {
		
		logger.info("Reading data");
		
		ArrayList<FishingGround> fishingGrounds = new ArrayList<FishingGround>();
		File[] listOfFiles = getFilesInDirectory(path);
		
		logger.info("Found " + listOfFiles.length + " files");
		
		for (int i = 0; i < listOfFiles.length; i++) {
			FishingGround ground = new FishingGround("FishingGround" + i);
			String location = listOfFiles[i].getPath();
			try {
				@SuppressWarnings("resource")
				BufferedReader reader = new BufferedReader(new FileReader(location));

				while ((LINE = reader.readLine()) != null) {

					String[] fishingGroundLine = LINE.split(SPLITTER);

					if (!fishingGroundLine[0].contains("lat")) {
						ground.addPoint(
								new Point(Double.valueOf(fishingGroundLine[0]), Double.valueOf(fishingGroundLine[1])));
					}

				}
				
				fishingGrounds.add(ground);
			} catch (IOException e) {
				return null;
			}
		}
		logger.info("Finished reading data");
		
		return fishingGrounds;
	}
	
	public static ArrayList<Point> readingTrackData(String location) {
		
		logger.info("Reading " + location);
		
		ArrayList<Point> points = new ArrayList<>();
		
			try {
				@SuppressWarnings("resource")
				BufferedReader reader = new BufferedReader(new FileReader(location));

				while ((LINE = reader.readLine()) != null) {

					String[] fishingGroundLine = LINE.split(SPLITTER);

					if (!fishingGroundLine[0].contains("mmsi")) {
						points.add(
								new Point(Double.valueOf(fishingGroundLine[7]), Double.valueOf(fishingGroundLine[8])));
					}

				}
				logger.info("Finished reading " + location);
				return points;
			} catch (IOException e) {
				logger.severe(e.getMessage());
				return null;
			}
		}
		

	/**
	 * Returns all files in the given directory.
	 * 
	 * @param directory
	 * @return
	 */
	private static File[] getFilesInDirectory(String directory) {
		File folder = new File(directory);
		File[] result = folder.listFiles();
		return result;
	}
}
