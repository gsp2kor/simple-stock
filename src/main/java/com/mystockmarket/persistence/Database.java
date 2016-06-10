package com.mystockmarket.persistence;

import java.util.List;
import java.util.Map;

import com.mystockmarket.exception.CustomStockExchangeException;
import com.mystockmarket.model.Stock;
import com.mystockmarket.model.Trade;
import com.mystockmarket.util.LoadStocks;

/**
 * @author Shivanshu_Gupta
 *
 */
public interface Database {
	
	/**
	 * Database for all the stocks available. Loaded for xml.
	 */
	static final Map<String, Stock> stockDB = LoadStocks.load();
	
	/**
	 * @return database of stocks
	 * @throws CustomStockExchangeException
	 */
	Map<String, Stock> getAllStocks() throws CustomStockExchangeException;
	
	/**
	 * @param symbol of the Stock
	 * @return Stock
	 * @throws CustomStockExchangeException
	 */
	Stock findStockByName(String symbol) throws CustomStockExchangeException;

	/**
	 * @param symbol of the Stock
	 * @return All the trades that happened for this stock
	 */
	List<Trade> getTradeListForStock(String symbol);
	
	/**
	 * @param symbol
	 * @param price
	 * @return dividend yield value
	 */
	Double getStockDividendYeildValue(String symbol, Double price);
	
	/**
	 * @param symbol
	 * @param price
	 * @return P/E ratio value
	 */
	Double getPEValueRatio(String symbol, Double price);
	
	/**
	 * @param symbol
	 * @return the current price of the stock
	 */
	Double getCurrentPrice(String symbol);
	
	/**
	 * @param symbol
	 */
	default void validateStock(String symbol) {
		if(!stockDB.containsKey(symbol)){
			throw new CustomStockExchangeException("Stock not found in Database");
		}
	}

}
