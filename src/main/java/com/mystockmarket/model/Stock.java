package com.mystockmarket.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.mystockmarket.enums.StockType;
/**
 * @author Shivanshu_Gupta
 *
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString(exclude = "tradeList")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stock {

	/**
	 * Name of the Stock
	 */
	@XmlAttribute(name ="name")
	private String symbol;
	
	/**
	 * Type of the Stock
	 */
	@XmlAttribute(name = "type")
	private StockType stockType;
	
	/**
	 * Last Dividend value for a particular stock
	 */
	@XmlElement(name = "last-dividend")
	private double lastDividend;
	
	/**
	 * Fix Dividend value for a particular stock ( 0 in case not present)
	 */
	@XmlElement(name = "fix-dividend")
	private double fixedDividend;
	
	/**
	 * Par value for a Stock
	 */
	@XmlElement(name = "par-value")
	private double parValue;
	
	/**
	 * Base price of a Stock
	 */
	@XmlElement(name = "base-price")
	private double basePrice;
	
	
	/**
	 * List of all the trade that happens for the given Stock
	 */
	private List<Trade> tradeList = new ArrayList<>();
	
	/**
	 * Latest trade price recorded for the stock
	 */
	private double lastTradePrice;

}
