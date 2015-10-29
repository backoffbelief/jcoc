package com.kael.coc.data;

import java.io.FileWriter;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BuilingData {
    //seconds
	public static final int TownHallSize = 4;
	public static final long[] TownHallUpgradeTime = {0, 
		TimeUnit.MINUTES.toSeconds(5),
		TimeUnit.HOURS.toSeconds(3),
		TimeUnit.DAYS.toSeconds(1),
		TimeUnit.DAYS.toSeconds(2),
		TimeUnit.DAYS.toSeconds(4),
		TimeUnit.DAYS.toSeconds(6),
		TimeUnit.DAYS.toSeconds(8),
		TimeUnit.DAYS.toSeconds(10),
		TimeUnit.DAYS.toSeconds(14)};
	
	public static final long[] TownHallUpgradeGold = {0, 1000,4000,25000,1500000, 7500000, 1200000, 2000000,3000000,4000000};
	
	public static final int[] GoldMineNums = {1,2,3,4,5,6,6,6,6,7};
	public static final int GoldMineSize = 3;
	public static final int[] GoldMineCapacity = {500,1000,1500,2500,10000,20000,30000,50000,75000,100000,150000,200000};
	public static final int[] GoldMineSpeedPerHour = {200, 400, 600, 800, 1000, 1300, 1600, 1900, 2200, 2500, 3000, 3500}; 
	public static final int[] GoldMineNeedElixirNum = {300,750,1500,3000,6000,12000,25000,50000,100000,250000,500000}; 
	public static final long[] GoldMineUpgradeTime = {
		TimeUnit.MINUTES.toSeconds(1),
		TimeUnit.MINUTES.toSeconds(5),
		TimeUnit.MINUTES.toSeconds(15),
		TimeUnit.MINUTES.toSeconds(60),
		TimeUnit.MINUTES.toSeconds(120),
		TimeUnit.MINUTES.toSeconds(360),
		TimeUnit.MINUTES.toSeconds(720),
		TimeUnit.MINUTES.toSeconds(1440),
		TimeUnit.MINUTES.toSeconds(2880),
		TimeUnit.DAYS.toSeconds(3),
		TimeUnit.DAYS.toSeconds(4),
		TimeUnit.DAYS.toSeconds(5)};
	public static final int[] GoldMineHp = {400,440,480,520,560,600,640,680,720,780,860,960};
	public static final int[] GoldMineNeedTownLevel = {1,1,2,2,3,3,4,4,5,5,7,8};

	public static final int ElixirCollectorSize = 3;
	public static final int[] ElixirCollectorNums = {1,2,3,4,5,6,6,6,6,7};
	public static final int[] ElixirCollectorCapacity = {500,1000,1500,2500,10000,20000,30000,50000,75000,100000,150000,200000};
	public static final int[] ElixirCollectorSpeedPerHour = {200, 400, 600, 800, 1000, 1300, 1600, 1900, 2200, 2500, 3000, 3500}; 
	public static final int[] ElixirCollectorNeedGoldNum = {300,750,1500,3000,6000,12000,25000,50000,100000,250000,500000}; 
	public static final long[] ElixirCollectorUpgradeTime = {
		TimeUnit.MINUTES.toSeconds(1),
		TimeUnit.MINUTES.toSeconds(5),
		TimeUnit.MINUTES.toSeconds(15),
		TimeUnit.MINUTES.toSeconds(60),
		TimeUnit.MINUTES.toSeconds(120),
		TimeUnit.MINUTES.toSeconds(360),
		TimeUnit.MINUTES.toSeconds(720),
		TimeUnit.MINUTES.toSeconds(1440),
		TimeUnit.MINUTES.toSeconds(2880),
		TimeUnit.DAYS.toSeconds(3),
		TimeUnit.DAYS.toSeconds(4),
		TimeUnit.DAYS.toSeconds(5)};
	public static final int[] ElixirCollectorHp = {400,440,480,520,560,600,640,680,720,780,860,960};
	public static final int[] ElixirCollectorNeedTownLevel = {1,1,2,2,3,3,4,4,5,5,7,8};

	
	public static final int GoldStorageSize = 3;
	public static final int[] GoldStorageNums = {1, 1, 2, 2, 2, 2, 2, 3, 4, 4};
	public static final int[] GoldStorageCapacity = {1500,3000,6000,12000,25000,50000,100000,250000,500000,1000000,2000000};
	public static final int[] GoldStorageNeedElixirNum = {300,750,1500,3000,6000,12000,25000,50000,100000,250000,500000};
	public static final int[] GoldStorageHp = {400,600,800,1000,1200,1400,1600,1700,1800,1900,2100};
	public static final int[] GoldStorageNeedTownLevel = {1,2,2,3,3,3,4,4,5,6,7};
	public static final long[] GoldStorageUpgradeTime = {
		TimeUnit.MINUTES.toSeconds(15),
		TimeUnit.MINUTES.toSeconds(30),
		TimeUnit.MINUTES.toSeconds(60),
		TimeUnit.MINUTES.toSeconds(120),
		TimeUnit.MINUTES.toSeconds(180),
		TimeUnit.MINUTES.toSeconds(240),
		TimeUnit.MINUTES.toSeconds(360),
		TimeUnit.MINUTES.toSeconds(480),
		TimeUnit.MINUTES.toSeconds(720),
		TimeUnit.MINUTES.toSeconds(1440),
		TimeUnit.MINUTES.toSeconds(2880)};

	public static final int ElixirStorageSize = 3;
	public static final int[] ElixirStorageNums = {1,2,2,2,2,2,2,3,4,4};
	public static final int[] ElixirStorageCapacity = {1500,3000,6000,12000,25000,50000,100000,250000,500000,1000000,2000000};
	public static final int[] ElixirStorageNeedGoldNum = {300,750,1500,3000,6000,12000,25000,50000,100000,250000,500000};
	public static final int[] ElixirStorageHp = {400,600,800,1000,1200,1400,1600,1700,1800,1900,2100};
	public static final int[] ElixirStorageNeedTownLevel = {1,2,2,3,3,3,4,4,5,6,7};
	public static final long[] ElixirStorageUpgradeTime = {
		TimeUnit.MINUTES.toSeconds(15),
		TimeUnit.MINUTES.toSeconds(30),
		TimeUnit.MINUTES.toSeconds(60),
		TimeUnit.MINUTES.toSeconds(120),
		TimeUnit.MINUTES.toSeconds(180),
		TimeUnit.MINUTES.toSeconds(240),
		TimeUnit.MINUTES.toSeconds(360),
		TimeUnit.MINUTES.toSeconds(480),
		TimeUnit.MINUTES.toSeconds(720),
		TimeUnit.MINUTES.toSeconds(1440),
		TimeUnit.MINUTES.toSeconds(2880)};
	
	public static final int ArmyCampSize = 5;
	public static final int[] ArmyCampNums = {1,1,2,2,3,3,4,4,4,4};
	public static final int[] ArmyCampCapacity = {20,30,35,40,45,50,55,60};
	public static final int[] ArmyCampNeedElixirNum = {250,2500,10000,100000,250000,750000,2250000,6250000};
	public static final int[] ArmyCampHp = {250,270,290,310,330,350,400,500};
	public static final int[] ArmyCampNeedTownLevel = {1,2,3,4,5,6,9,10};
	public static final long[] ArmyCampUpgradeTime = {
		TimeUnit.MINUTES.toSeconds(5),
		TimeUnit.HOURS.toSeconds(1),
		TimeUnit.HOURS.toSeconds(3),
		TimeUnit.HOURS.toSeconds(8),
		TimeUnit.DAYS.toSeconds(1),
		TimeUnit.DAYS.toSeconds(3),
		TimeUnit.DAYS.toSeconds(5),
		TimeUnit.DAYS.toSeconds(10)};

	public static final int BarracksSize = 3;
	public static final int[] BarracksNums = {1,2,2,3,3,3,4,4,4,4};
	public static final int[] BarracksCapacity = {20,25,30,35,40,45,50,55,60,75};
	public static final int[] BarracksNeedElixirNum = {200,1000,2500,5000,10000,80000,240000,700000,1500000,2000000};
	public static final int[] BarracksHp = {250,290,330,370,420,470,520,600,720,860};
	public static final int[] BarracksNeedTownLevel = {1,1,1,2,3,4,5,6,7,8};
	public static final long[] BarracksUpgradeTime = {
		TimeUnit.MINUTES.toSeconds(1),
		TimeUnit.MINUTES.toSeconds(15),
		TimeUnit.HOURS.toSeconds(2),
		TimeUnit.HOURS.toSeconds(4),
		TimeUnit.HOURS.toSeconds(10),
		TimeUnit.HOURS.toSeconds(16),
		TimeUnit.DAYS.toSeconds(1),
		TimeUnit.DAYS.toSeconds(2),
		TimeUnit.DAYS.toSeconds(4),
		TimeUnit.DAYS.toSeconds(6)};
	
    static String toString(int i)
    {
    	return String.valueOf(i);
    }
    static String toString(int[] arr)
    {
    	return Arrays.toString(arr);
    }
    static String toString(long[] arr)
    {
    	return Arrays.toString(arr);
    }
    
    static boolean cas(Field f, BuilingData bd, Properties p) throws Exception
    {
           Object val = f.get(bd);
           if(val.getClass().equals(int.class))
           {
        	   if(toString((Integer)val).equals(p.get(f.getName()))){
        		   return false;
        	   }
        	   p.setProperty(f.getName(), toString((Integer)val));
        	   return true;
        			   
           }
           
           if(val.getClass().equals(int[].class))
           {
        	   if(toString((int[])val).equals(p.get(f.getName()))){
        		   return false;
        	   }
        	   p.setProperty(f.getName(), toString((int[])val));
        	   return true;
        			   
           }
           
           if(val.getClass().equals(long[].class))
           {
        	   if(toString((long[])val).equals(p.get(f.getName()))){
        		   return false;
        	   }
        	   p.setProperty(f.getName(), toString((long[])val));
        	   return true;
        			   
           }
		return false;
    }
    
	public static void compareAndSet(){
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Properties p = new Properties();
		boolean isStrore = false;
		try(InputStream inputStream = cl.getResourceAsStream("coc.properties")) {
			
			p.load(inputStream);
			BuilingData bd = new BuilingData();
			Field[] fs = bd.getClass().getDeclaredFields();
			for (Field field : fs) {
				isStrore = cas(field, bd, p) || isStrore;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(isStrore){
			
			try (FileWriter fw = new FileWriter(System.getProperty("user.dir")+"/src/main/resources/coc.properties")){
				p.store(fw, null);
				System.out.println("cas success!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
