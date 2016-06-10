package com.mystockmarket.service;

import java.util.List;

import com.mystockmarket.exception.CustomStockExchangeException;
import com.mystockmarket.model.Stock;
import com.mystockmarket.model.Trade;

/**
 * @author Shivanshu_Gupta
 *
 */
public interface StockService {

	/**
	 * @param symbol
	 * @return Stock for the symbol
	 * @throws CustomStockExchangeException
	 */
	Stock findStockByName(String symbol) throws CustomStockExchangeException;
	
	/**
	 * @param symbol
	 * @return return list of trade for a particular stock name
	 */
	List<Trade> getTradeListForStock(String symbol);
	
	/**
	 * @param symbol
	 * @param price
	 * @return dividend yield value for gaven stock and price
	 * @throws CustomStockExchangeException
	 */
	Double getStockDividendValue(String symbol, Double price) throws CustomStockExchangeException;
	
	/**
	 * @param symbol
	 * @param price
	 * @return return the P/E ration for given stock and price
	 */
	Double getPEValueRatio(String symbol, Double price);
	
	/**
	 * @param symbol
	 * @return value of volume weight of stock
	 */
	Double volumeWeightedStockPrice(String symbol);

	/**
	 * @param symbol
	 * @return current price of stock
	 */
	Double getCurrentPrice(String symbol);
}
