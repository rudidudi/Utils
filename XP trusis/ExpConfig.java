package it.csttech.recruitment.data.entities;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExpConfig {

    //Method that defines
    public static Map<Integer, Integer> xpMap;
    static{
        Map<Integer, Integer> aMap = new LinkedHashMap<Integer,Integer>();
        ExpSettings.exponentMap.forEach((k,v)->{
            Integer exp = (int) ExpUtils.round((ExpSettings.XP_FACTOR*(Math.pow(k,v))),0);
            aMap.put(k, exp);
        });     
        xpMap = Collections.unmodifiableMap(aMap);
    }
    
    //Method that defines how many games a player have to do to level up
    public static Map<Integer, Double> levelUpGamesMap;
    static{
        Map<Integer, Double> aMap = new LinkedHashMap<Integer,Double>();
        ExpSettings.factorMapLvlMap.forEach((k,v)->{ 
            double asd= 0D;
            asd =ExpUtils.logOfBase(k,v);
            
            aMap.put(k,asd );
        });
        levelUpGamesMap = Collections.unmodifiableMap(aMap);
    }
    
    //@TestMethod Run As Java Application
    public static void main(String[] args) throws IOException
    {
        ExpConfig.levelUpGamesMap.forEach((k,v)->{System.out.println(k + " : " + v);});
    }
    
}