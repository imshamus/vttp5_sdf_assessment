package vttp.batch5.sdf.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Use this class as the entry point of your program

public class Main {

	public static void main(String[] args) {
        

        String fileName = "day.csv";
        Path p = Paths.get("task01", fileName); // Input file
        String absPath = p.toAbsolutePath().toString();

        if(!Files.exists(p))
        {
            System.err.println("Error: File does not exist. Terminating program..");
            return; // End program if nth given
        }
        else
        {
            System.out.printf("File found at <%s> \n", absPath);
            System.out.println("Analysing.."); // continue analysing only if day.csv found
            System.out.println();
        }

        List<DataRecord> mr = new ArrayList<>();
        
		try (BufferedReader br = new BufferedReader(new FileReader(p.toFile()))) 
        {
            String line;

            while ((line = br.readLine()) != null) 
            {
                if (line.startsWith("season"))
                {
                continue; // skip headers
                }

                String[] tempList = line.split(","); // split csv elements

				boolean holiday; 
				String season; 	// relevantInfo index[0]
				String month; 	// relevantInfo index[1]
				String day;		// relevantInfo index[3]
				String weather;	// relevantInfo index[4]
				int casual;		// relevantInfo index[5]
				int registered;	// relevantInfo index[6]
                int total;
              
                try
                {
                    holiday = convertBoolean(tempList[2].trim()); 	// index[2]
                	season = Utilities.toSeason(Integer.parseInt(tempList[0].trim()));		// index[0]
                	month = Utilities.toMonth(Integer.parseInt(tempList[1].trim())); 		// index[1]
					day = Utilities.toWeekday(Integer.parseInt(tempList[3].trim()));		// index[3]
					weather = WeatherSit.toWeather(Integer.parseInt(tempList[4].trim()));		// index[4]
					casual = Integer.parseInt(tempList[8].trim());		// index[8]
					registered = Integer.parseInt(tempList[9].trim());		// index[9]

                    total = casual + registered;
                }
                catch (NumberFormatException e)
                {
					// e.printStackTrace();
                    continue;
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
					// e.printStackTrace();
                    continue;
                }
            		
                DataRecord record = new DataRecord(holiday, season, month, day, weather, casual, registered, total);
                
                mr.add(record);

            }
            
            FilterInfo fi = new FilterInfo();
            fi.appStats(mr);
            System.out.printf("The highest (position) recorded number of cyclist was in %s (season), on a %s (day) in the month of %s (month). \n", fi.getSeasonHighest(), fi.getDayHighest(), fi.getMonthHighest());
            System.out.printf("There were a total of %d (total) cyclists. The weather was %s (weather).", fi.getHighestTotal(), fi.getWeatherHighest());
            System.out.printf("%s (day) was a %b (holiday)\n", fi.getDayHighest(), fi.isHolidayHighest());
            System.out.println();
            System.out.printf("The second highest (position) recorded number of cyclist was in %s (season), on a %s (day) in the month of %s (month). \n", fi.getSeasonSecond(), fi.getDaySecond(), fi.getMonthSecond());
            System.out.printf("There were a total of %d (total) cyclists. The weather was %s (weather). \n", fi.getSecondHighest(), fi.getWeatherSecond());
            System.out.printf("%s (day) was a %b (holiday). \n", fi.getDaySecond(), fi.isHolidaySecond());
            System.out.println();
            System.out.printf("The third highest (position) recorded number of cyclist was in %s (season), on a %s (day) in the month of %s (month). \n", fi.getSeasonThird(), fi.getDayThird(), fi.getMonthThird());
            System.out.printf("There were a total of %d (total) cyclists. The weather was %s (weather). \n", fi.getThirdHighest(), fi.getWeatherThird());
            System.out.printf("%s (day) was a %b (holiday). \n", fi.getDayThird(), fi.isHolidayThird());
            System.out.println();
            System.out.printf("The fourth highest (position) recorded number of cyclist was in %s (season), on a %s (day) in the month of %s (month). \n", fi.getSeasonFourth(), fi.getDayFourth(), fi.getMonthFourth());
            System.out.printf("There were a total of %d (total) cyclists. The weather was %s (weather).\n", fi.getFourthHighest(), fi.getWeatherFourth());
            System.out.printf("%s (day) was a %b (holiday). \n ", fi.getDayFourth(), fi.isHolidayFourth());
            System.out.println();
            System.out.printf("The fifth highest (position) recorded number of cyclist was in %s (season), on a %s (day) in the month of %s (month). \n", fi.getSeasonFifth(), fi.getDayFifth(), fi.getMonthFifth());
            System.out.printf("There were a total of %d (total) cyclists. The weather was %s (weather). \n", fi.getFifthHighest(), fi.getWeatherFifth());
            System.out.printf("%s (day) was a %b (holiday). \n", fi.getDayFifth(), fi.isHolidayFifth());
            System.out.println();

        }
		catch (IOException e) 
        {
            e.printStackTrace();
        }

	}

    private static boolean convertBoolean(String value) 
    {
        boolean returnValue = false;
        if ("1".equalsIgnoreCase(value))
            returnValue = true;
        return returnValue;
    }

}

         