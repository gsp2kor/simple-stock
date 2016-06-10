package com.mystockmarket.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.mystockmarket.persistence.StockDatabaseTest;
import com.mystockmarket.service.StockServiceTest;
import com.mystockmarket.service.TradeServiceTest;
import com.mystockmarket.util.CalculationUtilTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TradeServiceTest.class,
   StockServiceTest.class,
   StockDatabaseTest.class,
   CalculationUtilTest.class
})
public class TestSuite {
	
}
