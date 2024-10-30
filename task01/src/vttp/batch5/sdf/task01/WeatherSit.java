package vttp.batch5.sdf.task01;

public class WeatherSit {

    public static final String[] WEATHER = { "Clear, Few clouds, Partly cloudy, Partly cloudy", "Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist", "Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds", "Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog" };

	public static String toWeather(int weather) {
		//season (1:spring, 2:summer, 3:fall, 4:winter)
		switch (weather) {
			case 1:
			case 2:
			case 3:
			case 4:
				return WEATHER[weather - 1];
			default:
				return "funny weather";
		}
	}
    
}


// + weathersit : 
		// - 1: Clear, Few clouds, Partly cloudy, Partly cloudy
		// - 2: Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist
		// - 3: Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds
		// - 4: Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog