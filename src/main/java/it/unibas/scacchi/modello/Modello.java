package it.unibas.scacchi.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {
    
    private Map<String,Object> beans = new HashMap<String,Object>();
    
    public void insertBean(String s , Object o ){
        beans.put(s,o);
    }
    
    public Object getBean(String s){
        return beans.get(s);
    }
}
