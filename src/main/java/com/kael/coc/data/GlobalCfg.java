package com.kael.coc.data;

import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.kael.coc.support.JsonUtils;

public class GlobalCfg {
    private static void addBuildingl(List<BuildElemet> buildElemets, Map<String, Object> args)  throws Exception{
    	BuildElemet e = new BuildElemet();
    	Class c = e.getClass();
    	for(Entry<String, Object> entry : args.entrySet()){
    		  Field f = c.getDeclaredField(entry.getKey());
    		  if(!f.isAccessible()){
    			  f.setAccessible(true);
    		  }
    		  f.set(e, entry.getValue());
    	}
		buildElemets.add(e);
    }
	private static void addTownHall(List<BuildElemet> buildElemets) throws Exception {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("xmlId", 1000);
		args.put("name", "TownHall");
		args.put("size", 4);
		args.put("hps", new int[]{1500,1600,1850,2100,2400,2800,3300,3900,4600,5500,0});
		args.put("fames", new int[]{0,17,103,293,415,587,720,831,929,1099,0});
		args.put("maxLevel",11);
		args.put("upgradeNeedGold",new int[]{0, 1000,4000,25000,1500000, 7500000, 1200000, 2000000,3000000,4000000});
		args.put("goldMineNums",new int[] {1,2,3,4,5,6,6,6,6,7});
		args.put("elixirCollectorNums",new int[] {1,2,3,4,5,6,6,6,6,7});
		args.put("goldStorageNums",new int[] {1,2,2,2,2,2,2,3,4,4});
		args.put("elixirStorageNums",new int[] {1,2,2,2,2,2,2,3,4,4});
		args.put("armyCampNums",new int[] {1,1,2,2,3,3,4,4,4,4});
		args.put("barracksNums",new int[] {1,2,2,3,3,3,4,4,4,4});
		args.put("upgradeTime",new long[] {0, 
				TimeUnit.MINUTES.toSeconds(5),
				TimeUnit.HOURS.toSeconds(3),
				TimeUnit.DAYS.toSeconds(1),
				TimeUnit.DAYS.toSeconds(2),
				TimeUnit.DAYS.toSeconds(4),
				TimeUnit.DAYS.toSeconds(6),
				TimeUnit.DAYS.toSeconds(8),
				TimeUnit.DAYS.toSeconds(10),
				TimeUnit.DAYS.toSeconds(14)});
		addBuildingl(buildElemets,args);
	}

	private static void addGoldMine(List<BuildElemet> buildElemets) throws Exception {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("xmlId", 1001);
		args.put("name", "GoldMine");
		args.put("size", 3);
		args.put("hps", new int[]{400,440,480,520,560,600,640,680,720,780,860,960});
		args.put("maxLevel",12);
		args.put("goldCapacity",new int[]{500,1000,1500,2500,10000,20000,30000,50000,75000,100000,150000,200000});
		args.put("goldMineSpeedPerHour",new int[]{200, 400, 600, 800, 1000, 1300, 1600, 1900, 2200, 2500, 3000, 3500});
		args.put("upgradeNeedElixir",new int[]{300,750,1500,3000,6000,12000,25000,50000,100000,250000,500000});
		args.put("needTownLevel",new int[]{1,1,2,2,3,3,4,4,5,5,7,8});
		args.put("upgradeTime",new long[]{
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
				TimeUnit.DAYS.toSeconds(5)});
		addBuildingl(buildElemets,args);
	}
	
	private static void addElixirCollector(List<BuildElemet> buildElemets) throws Exception {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("xmlId", 1002);
		args.put("name", "ElixirCollector");
		args.put("size", 3);
		args.put("hps", new int[]{400,440,480,520,560,600,640,680,720,780,860,960});
		args.put("maxLevel",12);
		args.put("elixirCapacity",new int[]{500,1000,1500,2500,10000,20000,30000,50000,75000,100000,150000,200000});
		args.put("elixirCollectorSpeedPerHour",new int[]{200, 400, 600, 800, 1000, 1300, 1600, 1900, 2200, 2500, 3000, 3500});
		args.put("upgradeNeedGold",new int[]{300,750,1500,3000,6000,12000,25000,50000,100000,250000,500000});
		args.put("needTownLevel",new int[]{1,1,2,2,3,3,4,4,5,5,7,8});
		args.put("upgradeTime",new long[]{
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
				TimeUnit.DAYS.toSeconds(5)});
		addBuildingl(buildElemets,args);
	}

	private static void addGoldStorage(List<BuildElemet> buildElemets) throws Exception {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("xmlId", 1003);
		args.put("name", "GoldStorage");
		args.put("size", 3);
		args.put("hps", new int[]{400,600,800,1000,1200,1400,1600,1700,1800,1900,2100});
		args.put("maxLevel",11);
		args.put("goldCapacity",new int[]{1500,3000,6000,12000,25000,50000,100000,250000,500000,1000000,2000000});
		args.put("upgradeNeedElixir",new int[]{300,750,1500,3000,6000,12000,25000,50000,100000,250000,500000});
		args.put("needTownLevel",new int[]{1,2,2,3,3,3,4,4,5,6,7});
		args.put("upgradeTime",new long[]{
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
				TimeUnit.MINUTES.toSeconds(2880)});
		addBuildingl(buildElemets,args);
	}

	private static void addElixirStorage(List<BuildElemet> buildElemets) throws Exception {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("xmlId", 1004);
		args.put("name", "ElixirStorage");
		args.put("size", 3);
		args.put("hps", new int[]{400,600,800,1000,1200,1400,1600,1700,1800,1900,2100});
		args.put("maxLevel",11);
		args.put("elixirCapacity",new int[]{1500,3000,6000,12000,25000,50000,100000,250000,500000,1000000,2000000});
		args.put("upgradeNeedGold",new int[]{300,750,1500,3000,6000,12000,25000,50000,100000,250000,500000});
		args.put("needTownLevel",new int[]{1,2,2,3,3,3,4,4,5,6,7});
		args.put("upgradeTime",new long[]{
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
				TimeUnit.MINUTES.toSeconds(2880)});
		addBuildingl(buildElemets,args);
	}
	private static void addArmyCamp(List<BuildElemet> buildElemets) throws Exception {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("xmlId", 1005);
		args.put("name", "ArmyCamp");
		args.put("size", 5);
		args.put("hps", new int[]{250,270,290,310,330,350,400,500});
		args.put("maxLevel",8);
		args.put("solidersCapacity",new int[]{20,30,35,40,45,50,55,60});
		args.put("upgradeNeedElixir",new int[]{250,2500,10000,100000,250000,750000,2250000,6250000});
		args.put("needTownLevel",new int[]{1,2,3,4,5,6,9,10});
		args.put("upgradeTime",new long[]{
				TimeUnit.MINUTES.toSeconds(5),
				TimeUnit.HOURS.toSeconds(1),
				TimeUnit.HOURS.toSeconds(3),
				TimeUnit.HOURS.toSeconds(8),
				TimeUnit.DAYS.toSeconds(1),
				TimeUnit.DAYS.toSeconds(3),
				TimeUnit.DAYS.toSeconds(5),
				TimeUnit.DAYS.toSeconds(10)});
		addBuildingl(buildElemets,args);
	}
	
	private static void addBarracks(List<BuildElemet> buildElemets) throws Exception {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("xmlId", 1006);
		args.put("name", "Barracks");
		args.put("size", 3);
		args.put("hps", new int[]{250,290,330,370,420,470,520,600,720,860});
		args.put("maxLevel",10);
		args.put("solidersCapacity",new int[]{20,25,30,35,40,45,50,55,60,75});
		args.put("upgradeNeedElixir",new int[]{200,1000,2500,5000,10000,80000,240000,700000,1500000,2000000});
		args.put("needTownLevel",new int[]{1,1,1,2,3,4,5,6,7,8});
		args.put("upgradeTime",new long[]{
				TimeUnit.MINUTES.toSeconds(1),
				TimeUnit.MINUTES.toSeconds(15),
				TimeUnit.HOURS.toSeconds(2),
				TimeUnit.HOURS.toSeconds(4),
				TimeUnit.HOURS.toSeconds(10),
				TimeUnit.HOURS.toSeconds(16),
				TimeUnit.DAYS.toSeconds(1),
				TimeUnit.DAYS.toSeconds(2),
				TimeUnit.DAYS.toSeconds(4),
				TimeUnit.DAYS.toSeconds(6)});
		addBuildingl(buildElemets,args);
	}
	private static void addBarrier(List<BuildElemet> buildElemets) throws Exception {
	    int[] costTime = {10,15,30,30,30,30,45,60};
	    int[] size = {2,2,2,2,2,2,3,3};
	    int[] costRe= {100,250,1000,1000,1000,2000,7500,10000};
	    int[] fame= {3,3,5,5,5,5,6,7};
	    int[] weights= {10,20,10,10,20,20,5,5};
	    String[] names = {"Mushroom","Shrub","TrunkLineSmall","Trunk","TrunkLineBig","TreeSmall","TreeMiddle","TreeBig"};
		for (int i = 0; i < costTime.length; i++) {
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("xmlId", 2000+i);
			args.put("name", names[i]);
			args.put("size", size[i]);
			args.put("maxLevel",1);
			args.put("clearCostTime",costTime[i]);
			args.put("costElixir",costRe[i]);
			args.put("fame",fame[i]);
			args.put("weight",weights[i]);
			addBuildingl(buildElemets,args);
		}
	}

	
	   public static void main(String[] args) {
	    	List<BuildElemet> buildElemets = new ArrayList<BuildElemet>();
			try {
				addTownHall(buildElemets);
				addGoldMine(buildElemets);
				addElixirCollector(buildElemets);
				addGoldStorage(buildElemets);
				addElixirStorage(buildElemets);
				addArmyCamp(buildElemets);
				addBarracks(buildElemets);
				addBarrier(buildElemets);
				Collections.sort(buildElemets);
				try(FileWriter fw = new FileWriter(System.getProperty("user.dir")+"/src/main/resources/coc_bulid.json", false)){
					fw.write(JsonUtils.toJSON(buildElemets));
					fw.flush();
				}catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
	    
}
