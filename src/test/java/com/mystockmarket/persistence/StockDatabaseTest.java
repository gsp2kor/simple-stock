package com.mystockmarket.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

public class StockDatabaseTest {
	
	private static Database db;
	
	@BeforeClass
	public static void loadPreRequsites(){
		db =StockDatabase.getDataBase();
	}
	
	@Test
	public void areStockLoadedTest(){
		assertThat(db.getAllStocks().size()).isEqualTo(5);
	}

}
