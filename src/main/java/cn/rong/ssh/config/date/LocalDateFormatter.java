package cn.rong.ssh.config.date;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Author:rong
 * Description:
 * Data: Create in 下午 7:38 17.11.6
 * Package: cn.rong.ssh.config.date
 */
public class LocalDateFormatter implements Formatter {
	public static final String US_PATTERN = "MM/dd/yyyy";
	public static final String NORMAL_PATTERN = "yyyy/MM/dd";
	@Override
	public LocalDate parse(String text, Locale locale) throws ParseException {

		return LocalDate.parse(text, DateTimeFormatter.ofPattern(getpatten(locale)));
	}

	public static String getpatten(Locale locale) {
		return isUS(locale)? US_PATTERN:NORMAL_PATTERN;
	}
	public static boolean isUS(Locale locale){
		return Locale.US.getCountry().equals(locale.getCountry());
	}

	@Override
	public String print(Object object, Locale locale) {
		return null;
	}
}
