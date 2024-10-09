package edu.wgu.d387_sample_code.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class TimeController {
    private final ZoneId zEastern = ZoneId.of("America/New_York");
    private final ZoneId zMountain = ZoneId.of("America/Denver");
    private final ZoneId zUTC = ZoneId.of("UTC");

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a z");

    @GetMapping("/timezones")
    public Map<String, String> getTimeZones() {

        LocalDateTime localDateTime = LocalDateTime.now();


        ZonedDateTime easternTime = localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(zEastern);
        ZonedDateTime mountainTime = localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(zMountain);
        ZonedDateTime utcTime = localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(zUTC);

        //Store in HashMap (made it easy :))

        Map<String, String> timeZones = new HashMap<>();
        timeZones.put("easternTime", easternTime.format(formatter));
        timeZones.put("mountainTime", mountainTime.format(formatter));
        timeZones.put("centralTime", utcTime.format(formatter));

        return timeZones;
    }
}
