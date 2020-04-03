package com.beveragefactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		String str = "Chai, -sugar, -milk";
		List<String> itemList = Arrays.asList(str.split(",")).stream().map(s->s.replace("\"", "").replace("[", "").replace("]", "").trim().toLowerCase()).collect(Collectors.toList());

		System.out.println(itemList);
		
		if(itemList.contains("-coffee") || itemList.contains("-tea") || itemList.contains("-banana") || itemList.contains("-strawberries")) {
			System.out.println("Ordered Item not valid");
		} else {
			double temp = 0;
			
			for (int i = 0; i < itemList.size(); i++) {
				String item = itemList.get(i);
				if(item.equals("chai")) {
					temp = temp + 4;
				} else if(item.equals("coffee")) {
					temp = temp + 5;
				} else if(item.equals("banana smoothie")) {
					temp = temp + 6;
				} else if(item.equals("strawberry shake")) {
					temp = temp + 7;
				} else if(item.equals("mojito")) {
					temp = temp + 7.5;
				} else if(item.equals("-milk")) {
					temp = temp - 1;
				} else if(item.equals("-sugar")) {
					temp = temp - 0.5;
				} else if(item.equals("-soda")) {
					temp = temp - 0.5;
				} else if(item.equals("-mint")) {
					temp = temp - 0.5;
				} else if(item.equals("-water")) {
					temp = temp - 0.5;
				} 
			}
			
			System.out.println("Total Bill = " + temp);
		}
	}
}