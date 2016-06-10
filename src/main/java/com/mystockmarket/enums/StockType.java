package com.mystockmarket.enums;

import javax.xml.bind.annotation.XmlEnumValue;
/**
 * @author Shivanshu_Gupta
 *
 */
public enum StockType {
	
	/**
	 * Stock type COMMON
	 */
	@XmlEnumValue("common")COMMON,
	
	/**
	 * Stock type PREFERRED
	 */
	@XmlEnumValue("preferred")PREFERRED

}
