package com.mystockmarket.exception;

/**
 * @author Shivanshu_Gupta
 *
 *	This class is for all the business exception that might occur.
 *	Its extending Runtime Exception assuming the Handler will be present up in the hierarchy
 *
 */
public class CustomStockExchangeException extends RuntimeException{

	/**
	 * Ser Id
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor.
	 */
	/**
	 * @param Message to be shown in case of Exception
	 */
	public CustomStockExchangeException(String message){
		super(message);
	}

}
