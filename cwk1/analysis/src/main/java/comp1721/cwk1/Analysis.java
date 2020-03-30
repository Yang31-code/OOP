package comp1721.cwk1;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public class Analysis {
	private static String doubleToString1(Double d) {  
		DecimalFormat decimalFormat = new DecimalFormat("0.###E0");
        String result = decimalFormat.format(d); 
        return result;
	}
	public static void main(String[] args) throws FileNotFoundException {
		WeatherDataset dataset = new WeatherDataset(args[0]);
		DateTimeFormatter FORMATTER1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter FORMATTER2 = DateTimeFormatter.ofPattern("HH:mm");
		System.out.println(String.format("%s valid records acquired.\n", dataset.size()));
		System.out.println(String.format("Highest wind speed: %.1f m/s\n(measured on %s at %s)\n",
				dataset.maxWindSpeed().getWindSpeed(),
				dataset.maxWindSpeed().getTime().format(FORMATTER1),
				dataset.maxWindSpeed().getTime().format(FORMATTER2)));
		System.out.println(String.format("Lowest humidity: %.1f%%\n(measured on %s at %s\n)",
				dataset.minHumidity().getHumidity(),
				dataset.minHumidity().getTime().format(FORMATTER1),
				dataset.minHumidity().getTime().format(FORMATTER2)));
		System.out.println(String.format("Highest temperature: %.1f°„C\n(measured on %s at %s)",
				dataset.maxTemperature().getTemperature(),
				dataset.maxTemperature().getTime().format(FORMATTER1),
				dataset.maxTemperature().getTime().format(FORMATTER2)));
		System.out.println(String.format("Insolation on %s: %s J/m2",
				dataset.maxTemperature().getTime().format(FORMATTER1),
				doubleToString1(dataset.insolation(dataset.maxTemperature().getTime().toLocalDate()))));
	}
}
