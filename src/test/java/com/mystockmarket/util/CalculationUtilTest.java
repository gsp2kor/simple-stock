package com.mystockmarket.util;

import static org.assertj.core.api.Assertions.assertThat;
import static com.mystockmarket.util.CalculationUtil.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class CalculationUtilTest {
	
	@Test
	public void timeValidationTest(){
		assertThat(isValiadTime(LocalDateTime.now().minusMinutes(18))).isEqualTo(false);
		assertThat(isValiadTime(LocalDateTime.now().plusMinutes(1))).isEqualTo(true);
	}
	
	@Test
	public void priceValidationTest(){
		assertThat(isValidPrice(new Double(0.0))).isEqualTo(false);
		assertThat(isValidPrice(new Double(1.0))).isEqualTo(true);

	}
	
	@Test
	public void quantityValidationTest(){
		assertThat(isValidQuantity(new Integer(0))).isEqualTo(false);
		assertThat(isValidQuantity(new Integer(1))).isEqualTo(true);
	}
	
	@Test
	public void doubleValueRoundOffValidationTest(){
		assertThat(roundOff(new Double(0.0))).isEqualByComparingTo(0.0);
		assertThat(roundOff(new Double(0.12345))).isEqualByComparingTo(0.123);
		assertThat(roundOff(new Double(123.4))).isEqualByComparingTo(123.4);
		assertThat(roundOff(new Double(123.45678))).isNotEqualByComparingTo(123.4);

	}

}
