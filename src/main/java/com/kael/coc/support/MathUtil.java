package com.kael.coc.support;

public class MathUtil {
	public static int cal(int speedOfHour, double hours) {
		return (int) Math.max(0, Math.round(speedOfHour * hours));
	}
	
	public static int cal(int speedOfHour,long interInMills){
		return cal(speedOfHour, 1.0 * interInMills/3600000);
	}
}
