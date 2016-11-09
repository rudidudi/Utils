package it.csttech.recruitment.data.entities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJson
{
  public static void main(String[] args) throws IOException
  {
      
      ArrayList<Map<String,String>> arL = new ArrayList<Map<String,String>>();
      
      Map<String,String> m1 = new HashMap<String,String>();
      m1.put("name", "SSD");
      m1.put("number", "1");
      m1.put("price", "4000");
      
      Map<String,String> m2 = new HashMap<String,String>();
      m2.put("name", "Notebook");
      m2.put("number", "1");
      m2.put("price", "60000");
      
      arL.add(m1);
      arL.add(m2);
      
      
    javaToJson(arL);
  }

        private static void javaToJson(Object obj)
        {  
            try
            {
                String jsonStr = new ObjectMapper().writeValueAsString(obj);
                System.out.println(""+jsonStr);
                //[{"number":"1","price":"4000","name":"SSD"},{"number":"1","price":"60000","name":"Notebook"}]
            }
            catch (JsonProcessingException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
}
