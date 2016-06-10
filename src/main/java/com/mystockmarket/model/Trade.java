package com.mystockmarket.model;

import java.time.LocalDateTime;

import com.mystockmarket.enums.TradeType;

import lombok.AllArgsConstructor;

/**
 * @author Shivanshu_Gupta
 *
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString
@AllArgsConstructor

public class Trade {

	/**
	 * Name of the Stock
	 */
	private String stockName;
	/**
	 * Quantity of shares to buy
	 */
	private Integer quantity;
	/**
	 * Price of shares to buy
	 */
	private Double price;
	/**
	 * Time stamp of the trade
	 */
	private LocalDateTime timeOfTrade;
	/**
	 * Type of the trade
	 */
	private TradeType tradeType;
}
