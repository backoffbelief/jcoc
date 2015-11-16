package com.kael.coc.support;

public class TimeUtil {

	private static class TimeSource {
		private final long offset;

		private TimeSource(long offset) {
			this.offset = offset;
		}
		
		private long currentTimeMillis() {
			return System.currentTimeMillis() + offset;
		}
	}
	
	private static TimeSource source = new TimeSource(0);
	
	public static long currentTimeMillis(){
		return source.currentTimeMillis();
	}
	
	public static void changeTime(long now){
		source = new TimeSource(now- System.currentTimeMillis());
	}
}
