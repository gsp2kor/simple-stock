package com.mystockmarket.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mystockmarket.enums.TradeType;
import com.mystockmarket.exception.CustomStockExchangeException;

public class StockServiceTest {
	
	private static TradeService tradeService;
	private static StockService stockService;
	
	@BeforeClass
	public static void loadPreRequsites(){
		stockService = StockServiceImpl.get();
		tradeService = TradeServiceImpl.get();
		tradeService.save("JOE", 25, 5.0, LocalDateTime.now(), TradeType.BUY);
        tradeService.save("JOE", 45, 23.0, LocalDateTime.now(), TradeType.SELL);
	}
	
	@Test
	public void findStockByNameTest(){
		assertThat(stockService.findStockByName("JOE")).isNotNull();
		assertThatThrownBy(()->stockService.findStockByName("MISSING")).isInstanceOf(CustomStockExchangeException.class);
	}
	
	@Test
	public void getCurrentPriceTest(){
		assertThat(stockService.getCurrentPrice("JOE")).isEqualTo(23.0);
		assertThatThrownBy(()->stockService.getCurrentPrice("MISSING")).isInstanceOf(CustomStockExchangeException.class);
		assertThat(stockService.getCurrentPrice("POP")).isEqualTo(32.5);
	}

	@Test
	public void getStockDividendYeildValue(){
		assertThatThrownBy(() -> stockService.getStockDividendValue("JOE",0.0)).isInstanceOf(IllegalArgumentException.class);
		assertThat(stockService.getStockDividendValue("JOE",10.0)).isEqualTo(1.3);
		assertThatThrownBy(()->stockService.getStockDividendValue("MISSING",23.5)).isInstanceOf(CustomStockExchangeException.class);
		assertThat(stockService.getStockDividendValue("TEA",50.0)).isEqualTo(0.0);
	}
	
	@Test
	public void getPEValueRatioTest(){
		assertThatThrownBy(() -> stockService.getPEValueRatio("JOE",0.0)).isInstanceOf(IllegalArgumentException.class);
		assertThat(stockService.getPEValueRatio("JOE",13.0)).isEqualTo(1.0);
		assertThatThrownBy(()->stockService.getPEValueRatio("MISSING",23.5)).isInstanceOf(CustomStockExchangeException.class);
		assertThat(stockService.getPEValueRatio("TEA",50.0)).isEqualTo(0.0);
	}

}
