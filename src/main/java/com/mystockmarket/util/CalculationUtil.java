package com.mystockmarket.util;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Shivanshu_Gupta
 * 
 * Util calss for this application.
 * This class will provide some basic common methods. 
 *
 */
/**
 * @author Shivanshu_Gupta
 *
 */
public class CalculationUtil {
	
	/**
	 * @param value
	 * @return double value with 3 digits after decimal
	 */
	public static Double roundOff(Double value) {
		return new BigDecimal(value)
			    .setScale(3, BigDecimal.ROUND_HALF_UP)
			    .doubleValue();
	}
	
	/**
	 * @param price
	 * @return true if the price is greater than 0
	 */
	public static boolean isValidPrice(Double price){
		if(price>0) return true;
			return false;
	}

	/**
	 * @param quantity
	 * @return true if quantity is greater than 0
	 */
	public static boolean isValidQuantity(Integer quantity){
		if(quantity>0) return true;
			return false;
	}


	/**
	 * @param trade
	 * @return true if the time duration of trade is within 15 minutes
	 */
	public static boolean isValiadTime(LocalDateTime tradeTime) {
		LocalDateTime timeNow = LocalDateTime.now();
		return Duration.between(tradeTime,timeNow).toMinutes() <=15;
	}

}
