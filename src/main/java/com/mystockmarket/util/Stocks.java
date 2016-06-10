package com.mystockmarket.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mystockmarket.model.Stock;

/**
 * @author Shivanshu_Gupta
 *
 */
@XmlRootElement(name = "stocks")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stocks {

	@XmlElement(name = "stock")
	private List<Stock> stocks;

	public Map<String,Stock> getStocks() {
		Map<String, Stock> stockMap = new HashMap<>();
		for (Stock stock : stocks) {
			stockMap.put(stock.getSymbol(), stock);
		}
		return Collections.unmodifiableMap(stockMap);
	}

}
