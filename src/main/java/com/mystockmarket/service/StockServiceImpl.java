package com.mystockmarket.service;

import static com.mystockmarket.util.CalculationUtil.isValiadTime;
import static com.mystockmarket.util.CalculationUtil.roundOff;

import java.util.List;

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
public final class StockServiceImpl implements StockService{

	private static Database db = StockDatabase.getDataBase();
	private static StockService stockService = new StockServiceImpl();
	
	@Override
	public Stock findStockByName(String symbol) throws CustomStockExchangeException {		
		return db.findStockByName(symbol);
	}

	@Override
	public List<Trade> getTradeListForStock(String symbol) {
		return db.getTradeListForStock(symbol);
	}

	@Override
	public Double getStockDividendValue(String symbol, Double price) throws CustomStockExchangeException {	
		return db.getStockDividendYeildValue(symbol,price);
	}

	@Override
	public Double getPEValueRatio(String symbol, Double price) {
		return db.getPEValueRatio(symbol, price);
	}

	@Override
	public Double getCurrentPrice(String symbol) {
		return db.getCurrentPrice(symbol);
	}
	
	public static StockService get() {
		return stockService ;
	}
	
	@Override
	public Double volumeWeightedStockPrice(String symbol) {
		
		Stock stock =db.findStockByName(symbol);
		double totalPrice = 0.0;
		int totalQuantity = 0;
		if(!stock.getTradeList().isEmpty()){
			for (Trade trade : stock.getTradeList()) {
				if(isValiadTime(trade.getTimeOfTrade())){
					totalPrice += trade.getPrice()*trade.getQuantity();
					totalQuantity += trade.getQuantity();	
				}
			}
			log.info("Volume Weighted Value of stock " + symbol + " is " + roundOff(totalPrice/totalQuantity));
			return roundOff(totalPrice/totalQuantity);
		}
		
		return new Double(0.0);
	}

}

