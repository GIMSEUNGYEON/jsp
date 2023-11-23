package kr.or.ddit.time;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class Java8TimeAPITest2 {

	@Test
	@Order(2)
	public void test01() {
		System.out.println(LocalDateTime.now(ZoneId.of("America/Anchorage")));
		System.out.println(LocalDate.from(LocalDateTime.now((ZoneId.of("America/Anchorage")))));
		System.out.println(YearMonth.from(LocalDateTime.now((ZoneId.of("America/Anchorage")))));
		System.out.println(Year.from(LocalDateTime.now((ZoneId.of("America/Anchorage")))));
		System.out.println(Month.from(LocalDateTime.now((ZoneId.of("America/Anchorage")))));
	}
	
	@Test
	@Order(1)
	public void test02() {
		LocalDateTime current = LocalDateTime.now();
		System.out.println(LocalDate.from(current)
				.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.GERMAN)));
		System.out.println(YearMonth.from(current));
		System.out.println(Year.from(current));
	}
	
	@Test
	void test03() {
		System.out.println(YearMonth.of(2023,1).format(DateTimeFormatter.ofPattern("yyyy, MMMM").withLocale(Locale.ENGLISH)));
	}

	@Test
	void test04() {
		System.out.println(YearMonth.now().minusMonths(1));
		System.out.println(YearMonth.now().plusMonths(2));
	}
	@Test
	void test05() {

		LocalDate today = LocalDate.now();
		
		DayOfWeek dayOfWeek = today.getDayOfWeek();
		
		Locale locale = Locale.forLanguageTag(Locale.CANADA.toLanguageTag());
		
		Stream.of(Locale.getAvailableLocales())
			.forEach(l->{
				System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL,l));				
			});
	}
	@Test
	void test06() {
		Arrays.stream(DayOfWeek.values()).forEach(dow->{
			System.out.println(dow.getDisplayName(TextStyle.FULL, Locale.GERMAN));			
		});
		System.out.println("");
		Stream.of(DayOfWeek.values()).forEach(w->{
			System.out.println(w.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
		});
	}
	
	@Test
	void test07() {
//		Locale locale = Locale.GERMAN;
		Locale locale = Locale.KOREAN;
		WeekFields weekFields =  WeekFields.of(locale);
		DayOfWeek first = weekFields.getFirstDayOfWeek();
		System.out.println(first.getDisplayName(TextStyle.FULL, locale));
		
		for(int i = 0; i < 7; i++) {
			DayOfWeek tmp = first.plus(i);
			System.out.println(tmp.getDisplayName(TextStyle.FULL, locale));
		}
		
	}
}
