package com.inventory;

public class Inventory {
	public int price;
	public int count;
	
	public Inventory(int price, int count) {
		this.price = price;
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
