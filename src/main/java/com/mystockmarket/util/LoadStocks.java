package com.mystockmarket.util;

import java.util.Arrays;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.mystockmarket.exception.CustomStockExchangeException;
import com.mystockmarket.model.Stock;

import lombok.extern.log4j.Log4j;

/**
 * @author Shivanshu_Gupta
 *
 */
@Log4j
public class LoadStocks {

	private static final Map<String, Stock> stockDB = populateStocks("stocks.xml");

	public static Map<String, Stock> load() {
		return stockDB;
	}

	/**
	 * @param fileName
	 * @return Map of stocks where key is stock name and value is stock itself
	 */
	private static Map<String, Stock> populateStocks(String fileName) {
		log.info("Loding Stocks Database");
		try {
			JAXBContext context = JAXBContext.newInstance(Stocks.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Stocks stocks = (Stocks) unmarshaller.unmarshal(ClassLoader.getSystemResourceAsStream(fileName));
			log.info(Arrays.toString(stocks.getStocks().values().toArray()));
			return stocks.getStocks();
		} catch (JAXBException e) {
			throw new CustomStockExchangeException("Unable to load the database");
		}
	}

}
