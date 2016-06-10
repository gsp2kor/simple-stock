package com.mystockmarket.service;

import static com.mystockmarket.util.CalculationUtil.isValidPrice;
import static com.mystockmarket.util.CalculationUtil.isValidQuantity;
import static com.mystockmarket.enums.AppConstants.*;

import java.time.LocalDateTime;

import com.mystockmarket.enums.TradeType;
import com.mystockmarket.exception.CustomStockExchangeException;
import com.mystockmarket.model.Stock;
import com.mystockmarket.model.Trade;
import com.mystockmarket.persistence.Database;
import com.mystockmarket.persistence.StockDatabase;

import lombok.extern.log4j.Log4j;

/**
 * @author Shivanshu_Gupta
 *
 */
@Log4j
public class TradeServiceImpl implements TradeService{

	private static TradeService tradeService = new TradeServiceImpl();
	private static StockService stockService = StockServiceImpl.get();
	private static Database db = StockDatabase.getDataBase();
	
	@Override
	public void save(String stockName, Integer quantity, Double price, LocalDateTime timeOfTrade, TradeType tradeType) {
		if(!isValidPrice(price) || !isValidQuantity(quantity)) throw new IllegalArgumentException("Incorrect values provided for Trade");
		Stock stock = stockService.findStockByName(stockName);
		
		Trade trade = new Trade(stockName,quantity,price,timeOfTrade,tradeType);
		stock.setLastTradePrice(price);
		stock.getTradeList().add(trade);
		log.info("Trade Saved for " + trade.toString());
		
	}

	public static TradeService get() {
		return tradeService;
	}

	@Override
	public Double getGCBEValue() {
		
		if(db.getAllStocks().isEmpty()) throw new CustomStockExchangeException("No stocks present");
		double priceProduct = 1.0;
		for (Stock stock : db.getAllStocks().values()) {
			priceProduct *= stockService.getCurrentPrice(stock.getSymbol());
		}
		return Math.pow(priceProduct, DOUBLE_ONE/(db.getAllStocks().size()));
	}

}
