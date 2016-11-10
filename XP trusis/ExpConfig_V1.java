package it.csttech.recruitment.data.entities;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExpConfig {

    public static final int LEVEL_MIN = 1;
    public static final int LEVEL_MAX = 100;
    public static final int FACTOR = 50;
    public static final double BASE_EXPONENT = 1.8D;
    
    public static int level = LEVEL_MIN;
    public static double exponent = BASE_EXPONENT;
    
    private static final Map<Integer, Double> myMap;
    static {
        Map<Integer, Double> aMap = new LinkedHashMap<Integer,Double>();
        aMap.put(20, 0.01D);//From level 1 to 20
        aMap.put(50, 0D);//From level 21 to 50
        aMap.put(100, 0.01D);//From level 51 to 100
        myMap = Collections.unmodifiableMap(aMap);
    }
    
    //@SERVICES:
    //@Populating Exponent map
    //@Populating XP map
    ExpConfig(){
        Map<Integer, Double> exponentMap = new LinkedHashMap<Integer,Double>();
        Map<Integer, Integer> xpMap = new LinkedHashMap<Integer,Integer>();
        exponentMap = populateExponentMap(exponentMap);
        xpMap = populateXpMap(exponentMap);
    }

    private Map<Integer, Double> populateExponentMap(Map<Integer, Double> exponentMap)
    { 
        ExpConfig.myMap.forEach((k,v)-> {
            for(int counter=level;counter<=k;counter++,level++){
                exponent+=v;
                exponentMap.put(level, exponent);
                //System.out.println(level + " : " + exponent);
            }        
        });  
        
        return exponentMap;
    }
    
    private Map<Integer, Integer> populateXpMap(Map<Integer, Double> exponentMap)
    {
        Map<Integer, Integer> xpMap = new LinkedHashMap<Integer,Integer>();
        
        exponentMap.forEach((k,v)->{
            Integer exp = (int) round((ExpConfig.FACTOR*(Math.pow(k,v))),0);
            xpMap.put(k, exp);
            System.out.println(k + " : " + exp);
        });

        return xpMap;
    }
    
    //@TestMethod Run As Java Application
    public static void main(String[] args) throws IOException
    {
        ExpConfig asd = new ExpConfig();
    }
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}