package com.mystockmarket.service;

import java.time.LocalDateTime;

import com.mystockmarket.enums.TradeType;
import com.mystockmarket.exception.CustomStockExchangeException;

/**
 * @author Shivanshu_Gupta
 *
 */
public interface TradeService {

	/**
	 * Save all the trade to the respective stocks
	 * 
	 * @param stockName
	 * @param quantity
	 * @param price
	 * @param timeOfTrade
	 * @param tradeType
	 * @throws IllegalArgumentException
	 * @throws CustomStockExchangeException
	 */
	void save(String stockName,Integer quantity,Double price,LocalDateTime timeOfTrade,TradeType tradeType) throws IllegalArgumentException,CustomStockExchangeException;

	/**
	 * @return Geometric mean value for all the stock
	 */
	Double getGCBEValue();
}
