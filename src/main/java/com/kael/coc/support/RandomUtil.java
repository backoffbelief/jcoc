package com.kael.coc.support;

import java.util.Arrays;
import java.util.Random;

public class RandomUtil {
	
	private static ThreadLocal<Random> rnds = new ThreadLocal<Random>(){

		@Override
		protected Random initialValue() {
			return new Random(System.currentTimeMillis());
		}
		
	};
	
	private static Random r(){
		return rnds.get();
	}
	
	public static int nextInt(){
		return r().nextInt();
	}

	public static int nextInt(int i){
		return r().nextInt(i);
	}
	
	public static int rndInWeights (int[] weigthts){
		int sum = 0;
		for (int i : weigthts) {
			sum += i;
		}
		int r = nextInt(sum);
		int val = 0;
		for (int i = 0; i < weigthts.length; i++) {
			val +=weigthts[i];
			if(r <= val){
				return i;
			}
		}
		throw new IllegalArgumentException(String.format("rndInWeights find error-===weigthts(%s), sum(%d),r(%d)",Arrays.toString(weigthts),sum,r));
	}

}
