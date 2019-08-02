package com.Anderson.homework4;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class DateTime {
	public static void main(String[] args)
	{
		System.out.println("Enter a year greater than 0");
		Scanner in = new Scanner(System.in);
		int year = in.nextInt();
		if(year <= 0)
		{
			System.out.println("The year is not greater than 0");
		}
		else
		{
			MonthsInYear(year);
		}
		System.out.println("Enter a month to find all of the mondays");
		String month = in.next();
		ListMondays(month);
		System.out.println("Enter a month followed by a day");
		month = in.next();
		int day = in.nextInt();
		Fri13(month, day);
	}

	public static void MonthsInYear(int y) 
	{
        int year = y;
        System.out.println("For the year " + year);
        for (Month month : Month.values()) {
            YearMonth ym = YearMonth.of(year, month);
            System.out.println(month+ ": " +ym.lengthOfMonth() +" days");
        }
    }

	public static void ListMondays(String m)
	{
		Month month = null;
		
		try {
			month = Month.valueOf(m.toUpperCase());
		} catch(IllegalArgumentException exc)
		{
			System.out.println(m + "is not a valid month.");
		}
		System.out.println("For the month of " +month);
		LocalDate date = Year.now().atMonth(month).atDay(1)
				.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		Month mi = date.getMonth();
		while (mi == month) {
			System.out.println(date);
			date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
			mi = date.getMonth();
		}
		
	}
	
	public static void Fri13(String m, int d)
	{
		Month month = null;
		int day = d;
		LocalDate date = null;
		
		try {
			month = Month.valueOf(m.toUpperCase());
		} catch(IllegalArgumentException exc)
		{
			System.out.println(m + "is not a valid month.");
		}
		try {
			date = Year.now().atMonth(month).atDay(day);
		} catch(DateTimeException exc) {
			System.out.println(month + " " + day + " is not a valid date");
		}
		if((date.get(ChronoField.DAY_OF_MONTH) == 13) && (date.get(ChronoField.DAY_OF_WEEK) == 5))
		{
			System.out.println(month + " " + day + " is Firday the 13th");
		}
		else 
		{
			System.out.println(month + " " + day + " is not Firday the 13th");
		}
	}
}