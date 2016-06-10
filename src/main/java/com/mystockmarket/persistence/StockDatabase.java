package com.mystockmarket.persistence;

import static com.mystockmarket.enums.StockType.COMMON;
import static com.mystockmarket.enums.StockType.PREFERRED;
import static com.mystockmarket.enums.AppConstants.*;
import static com.mystockmarket.util.CalculationUtil.isValidPrice;
import static com.mystockmarket.util.CalculationUtil.roundOff;

import java.util.List;
import java.util.Map;

import com.mystockmarket.exception.CustomStockExchangeException;
import com.mystockmarket.model.Stock;
import com.mystockmarket.model.Trade;

import lombok.extern.log4j.Log4j;
/**
 * @author Shivanshu_Gupta
 *
 */
@Log4j
public enum StockDatabase implements Database{
	
	DATABASE;
	
	public Map<String, Stock> getAllStocks() {
		return stockDB;
	}

	@Override
	public Stock findStockByName(String symbol) throws CustomStockExchangeException {			
		validateStock(symbol);
		log.info("Stock with symbol " + symbol + " found in database");
		return stockDB.get(symbol);
	}

	@Override
	public List<Trade> getTradeListForStock(String symbol) {
		return findStockByName(symbol).getTradeList();
	}

	@Override
	public Double getCurrentPrice(String symbol) {
		Stock stock = findStockByName(symbol);
		if(stock.getLastTradePrice()>0) {
			log.info("Current Price of stock " + symbol + " is " + stock.getLastTradePrice());
			return stock.getLastTradePrice();}
			log.info("Current Price of stock " + symbol + " is " + stock.getBasePrice());
		return stock.getBasePrice();
	}
	
	@Override
	public Double getStockDividendYeildValue(String symbol, Double price) {
		
		if(!isValidPrice(price)) throw new IllegalArgumentException("Invalid Values for price");
		Stock stock = findStockByName(symbol);
		
		if(COMMON.equals(stock.getStockType())){
			log.info("Dividend Yield Value of stock " + symbol + " and price "+ price + " is " + roundOff(stock.getLastDividend()/price));
			return roundOff(stock.getLastDividend()/price);

		}else if(PREFERRED.equals(stock.getStockType())){
			log.info("Dividend Yield Value of stock " + symbol + " and price "+ price + " is " + roundOff((stock.getFixedDividend()*stock.getParValue())/price));
			return roundOff((stock.getFixedDividend()*stock.getParValue())/price);
					
		}
		throw  new CustomStockExchangeException ("Invalid Type of Stock");
	}



	@Override
	public Double getPEValueRatio(String symbol, Double price) {
		if(!isValidPrice(price)) throw new IllegalArgumentException("Invalid Values for price");
		Stock stock = findStockByName(symbol);
		if(stock.getLastDividend()>DOUBLE_ZERO){ 
			log.info("PE Ratio Value of stock " + symbol + " and price "+ price + " is " + roundOff(price/stock.getLastDividend()));
			return roundOff(price/stock.getLastDividend());	
		}
		log.info("PE Ratio Value of stock " + symbol + " and price "+ price + " is 0.0");
		return DOUBLE_ZERO;
	}

	public static Database getDataBase() {
		return DATABASE;
	}

}
