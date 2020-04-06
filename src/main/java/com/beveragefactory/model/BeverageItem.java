package com.beveragefactory.model;

public class BeverageItem {

	private double chaiPrice;
	private double coffeePrice;
	private double bananaSmoothiePrice;
	private double strawberryShakePrice;
	private double mojitoPrice;
	private double milkPrice;
	private double sugarPrice;
	private double sodaPrice;
	private double mintPrice;
	private double waterPrice;

	public BeverageItem() {
		this.chaiPrice = 4;
		this.coffeePrice = 5;
		this.bananaSmoothiePrice = 6;
		this.strawberryShakePrice = 7;
		this.mojitoPrice = 7.5;
		this.sugarPrice = 0.5;
		this.milkPrice = 1;
		this.sodaPrice = 0.5;
		this.mintPrice = 0.5;
		this.waterPrice = 0.5;
	}

	public double getChaiPrice() {
		return chaiPrice;
	}

	public double getCoffeePrice() {
		return coffeePrice;
	}

	public double getBananaSmoothiePrice() {
		return bananaSmoothiePrice;
	}

	public double getStrawberryShakePrice() {
		return strawberryShakePrice;
	}

	public double getMojitoPrice() {
		return mojitoPrice;
	}

	public double getMilkPrice() {
		return milkPrice;
	}

	public double getSugarPrice() {
		return sugarPrice;
	}

	public double getSodaPrice() {
		return sodaPrice;
	}

	public double getMintPrice() {
		return mintPrice;
	}

	public double getWaterPrice() {
		return waterPrice;
	}

}