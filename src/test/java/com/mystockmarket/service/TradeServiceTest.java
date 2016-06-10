package com.mystockmarket.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mystockmarket.enums.TradeType;

public class TradeServiceTest {
	
	private static TradeService tradeService;
	private static StockService stockService;
	
	@BeforeClass
	public static void loadPreRequsites(){
		stockService = StockServiceImpl.get();
		tradeService = TradeServiceImpl.get();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void saveTradeExceptionTest(){
		
		tradeService.save("JOE", 0, 5.0, LocalDateTime.now(), TradeType.BUY);
		tradeService.save("JOE", 5, 0.0, LocalDateTime.now(), TradeType.BUY);	
		
	}
	
	@Test
	public void saveTradeTest(){
		tradeService.save("JOE", 22, 5.0, LocalDateTime.now(), TradeType.BUY);
		tradeService.save("JOE", 33, 10.0, LocalDateTime.now(), TradeType.BUY);
		assertThat(stockService.findStockByName("JOE").getTradeList().size()).isEqualTo(2);
		
	}
	
	@Test
	public void getGCBEValueTest(){
		assertThat(tradeService.getGCBEValue()).isGreaterThan(0);
	}

}
