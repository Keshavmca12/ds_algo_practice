package com.adp.practice;

import java.util.HashMap;
import java.util.List;

public interface CovidProductVendingMachineInterface {
	public long selectItemAndGetPrice(Item item) throws Exception;
    public void insertCoin(Coin coin) throws Exception;
    public List<Coin> refund();
    public HashMap<Item, List<Coin>> collectItemAndChange() throws Exception;   
    public void reset();
}
