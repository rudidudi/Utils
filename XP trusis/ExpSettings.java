package it.csttech.recruitment.data.entities;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExpSettings
{
    private static final int LEVEL_MIN = 1;
    private static final int LEVEL_MAX = 100;
    private static final double BASE_EXPONENT = 1.8D;
    private static final double LVL_BASE = 2.5D;
    private static final double DEC_BASE = 0.01D;
    
    protected static final int XP_FACTOR = 50;
    
    private static int level = ExpSettings.LEVEL_MIN;
    private static double exponent = ExpSettings.BASE_EXPONENT;
    
    private static final Map<Integer, Double> factorMap;
    static {
        Map<Integer, Double> aMap = new LinkedHashMap<Integer,Double>();
        aMap.put(20, 0.01D);//From level 1 to 20
        aMap.put(50, 0D);//From level 21 to 50
        aMap.put(100, 0.01D);//From level 51 to 100
        factorMap = Collections.unmodifiableMap(aMap);
    }
    
    protected static  Map<Integer, Double> factorMapLvlMap;
    static {
        Map<Integer, Double> aMap = new LinkedHashMap<Integer,Double>();
        double factor = LVL_BASE;
        for(int counter = LEVEL_MIN; counter <= LEVEL_MAX;counter++){
            aMap.put(counter, factor);
            factor=factor-DEC_BASE;
        }
        factorMapLvlMap = Collections.unmodifiableMap(aMap);
    }
    
    protected static Map<Integer, Double> exponentMap;
    static{
        Map<Integer, Double> aMap = new LinkedHashMap<Integer,Double>();
        ExpSettings.factorMap.forEach((k,v)-> {
            for(int counter=level;counter<=k;counter++,level++){
                exponent+=v;
                aMap.put(level, exponent);
            }        
        });
        exponentMap = Collections.unmodifiableMap(aMap);
    }

}
