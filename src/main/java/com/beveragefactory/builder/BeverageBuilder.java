package com.beveragefactory.builder;

import com.beveragefactory.model.BeverageItem;

public class BeverageBuilder {

	BeverageItem beverageItem;

	public BeverageBuilder(BeverageItem beverageItem) {
		this.beverageItem = beverageItem;
	}

	public double createBeverageBuilder(String item) {

		if (item.equals("chai")) {
			return beverageItem.getChaiPrice();
		} else if (item.equals("coffee")) {
			return beverageItem.getCoffeePrice();
		} else if (item.equals("banana smoothie")) {
			return beverageItem.getBananaSmoothiePrice();
		} else if (item.equals("strawberry shake")) {
			return beverageItem.getStrawberryShakePrice();
		} else if (item.equals("mojito")) {
			return beverageItem.getMojitoPrice();
		} else if (item.equals("-milk")) {
			return - beverageItem.getMilkPrice();
		} else if (item.equals("-sugar")) {
			return - beverageItem.getSugarPrice();
		} else if (item.equals("-soda")) {
			return - beverageItem.getSodaPrice();
		} else if (item.equals("-mint")) {
			return - beverageItem.getMintPrice();
		} else if (item.equals("-water")) {
			return - beverageItem.getWaterPrice();
		} else {
			return 0;
		}

	}
}