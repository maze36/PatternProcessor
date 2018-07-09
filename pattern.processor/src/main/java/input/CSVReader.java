package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.concaveHull.Point;
import model.data.FishingGround;

public class CSVReader {

	private static String LINE = "";

	private final static String SPLITTER = ",";

	public static ArrayList<FishingGround> readFishingGrounds(String path) {

		ArrayList<Point> coordinates = new ArrayList<Point>();
		ArrayList<FishingGround> fishingGrounds = new ArrayList<FishingGround>();
		File[] listOfFiles = getFilesInDirectory(path);
		for (int i = 0; i < listOfFiles.length; i++) {
			String location = listOfFiles[i].getPath();
			try {
				@SuppressWarnings("resource")
				BufferedReader reader = new BufferedReader(new FileReader(location));

				while ((LINE = reader.readLine()) != null) {

					String[] fishingGroundLine = LINE.split(SPLITTER);

					if (!fishingGroundLine[0].contains("lat")) {
						coordinates.add(
								new Point(Double.valueOf(fishingGroundLine[0]), Double.valueOf(fishingGroundLine[1])));
					}

				}
				FishingGround ground = new FishingGround(coordinates, "FishingGround" + i);
				coordinates.clear();
				fishingGrounds.add(ground);

			} catch (IOException e) {
				return null;
			}
		}
		return fishingGrounds;
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
