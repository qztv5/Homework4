package com.Anderson.homework4;

import java.util.List;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Lambdas {
	
	public static void main(String[] args)
	{
		List<String> str = new ArrayList<>();
		str.add("One string");
		str.add("Another string");
		str.add("The final string");
		str.add("eAB");
		str.add("EE");
		str.add("art");
		str.add("are");
		str.add("ace");
		str.add("apple");
		//str.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
		//str.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);;
		//str.stream().sorted().forEach(System.out::println);
		//str.stream().filter(e->e.startsWith("e")).forEach(System.out::println);
		//str.stream().filter(e->!e.startsWith("e")).forEach(System.out::println);
		Arrays.sort(str.toArray(), (s1,s2)-> sortByE(s1,s2));
		
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(3);
		l1.add(5);
		l1.add(44);
		
		//l1.stream().map(i -> i%2 == 0 ? "e" + i : "o" + i).forEach(System.out::println);
		//str.parallelStream().filter(s->s.startsWith("a")).filter(s -> s.length() == 3).forEach(System.out::println);
	
	}
	
	public static int sortByE(Object s1, Object  s2)
	{
		String first = s1.toString();
		String second = s2.toString();
		if (first.charAt(0) == 'e' && (second.charAt(0) != 'e'))
				{
					return 1;
				}
		else if (first.charAt(0) != 'e' && (second.charAt(0) == 'e'))
				{
					return -1;
				}
		else return 0;
	}

}
