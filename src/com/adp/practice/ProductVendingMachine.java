package com.adp.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductVendingMachine implements CovidProductVendingMachineInterface {

	public static Map<String, Integer> pricemap = new HashMap<>();
	List<Integer> validCoins = new ArrayList<>();
	static {
		pricemap.put("Sanitizer", 25);
		pricemap.put("Mask", 35);
		pricemap.put("Oximeter", 100);
	}
	Item selectedItem;
	List<Coin> coins = new ArrayList<>();

	@Override
	public long selectItemAndGetPrice(Item item) throws Exception {
		if (item == null) {
			throw new Exception();
		}
		this.selectedItem = item;
		return this.selectedItem.getPrices();
	}

	@Override
	public void insertCoin(Coin coin) throws Exception {
		if (!validCoins.contains(coin.getValue())) {
			throw new Exception();
		}
		coins.add(coin);
	}

	@Override
	public List<Coin> refund() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Item, List<Coin>> collectItemAndChange() throws Exception {
		Integer total = 0;
		HashMap<Item, List<Coin>> itemMap = new HashMap<>();
		for (Coin coin : coins) {
			total = +coin.getValue();
		}
		if (total < selectedItem.getPrices()) {
			throw new Exception("Insufficient fund");
		} else if (total == selectedItem.getPrices()) {
			itemMap.put(selectedItem, new ArrayList<>());
		} else {

			switch (selectedItem.getPrices()) {
			case 25:

				break;
			case 35:

				break;
			case 100:

				break;
			}

		}
		return null;
	}

	@Override
	public void reset() {
		selectedItem = new Item();
		coins = new ArrayList<>();
	}

}
