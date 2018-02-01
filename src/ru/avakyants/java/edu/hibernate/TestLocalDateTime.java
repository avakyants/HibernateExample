package ru.avakyants.java.edu.hibernate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
/*import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;*/

public class TestLocalDateTime {

	public static void main(String[] args) {
		
		/*Set<String> zonesSet = ZoneId.getAvailableZoneIds();
		List<String> zones = new ArrayList<>(zonesSet);		
		Collections.sort(zones);
		
		for(String z : zones) {
			System.out.println(z);
		}*/
						
		String str = "20180201 1900";
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");
		LocalDateTime localGameTime = LocalDateTime.parse(str, dtformat);
		ZoneId gameZoneId = ZoneId.of("US/Eastern");
		
		ZonedDateTime gameTime = ZonedDateTime.of(localGameTime, gameZoneId);
		
		ZoneId myZoneId = ZoneId.of("Europe/Moscow");
		ZonedDateTime myTime = gameTime.withZoneSameInstant(myZoneId);
		
		System.out.println(myTime);
		
		

	}

}
