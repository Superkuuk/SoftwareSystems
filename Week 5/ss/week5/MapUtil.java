package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {
    /**
     * Checks if the given map passes as an injective function.
     * 
     * @param a Map (function)
     * @return true if the given map is an injective function.
     */
	public static <K, V> boolean isOneOnOne(Map<K, V> map) {
    	boolean returnValue = true;
    	for (Map.Entry<K, V> entry : map.entrySet()) {
    	    K key = entry.getKey();
    	    V value = entry.getValue();
    		if (value != map.get(key)) {
    			returnValue = false;
    		}
        	for (Map.Entry<K, V> entry2 : map.entrySet()) {
        	    K key2 = entry2.getKey();
        	    V value2 = entry2.getValue();
        		
        		if (value2 == value && key2 != key) {
        			returnValue = false;
        		}
        	}
    	}
        return returnValue;
    }
	
    /**
     * Checks if the given map passes as an injective function.
     * 
     * @param a Map (function) and a range of values to test within
     * @return true if the given map is a surjective function.
     */
    public static <K, V> 
           boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
    	boolean returnValue = true;
    	
    	for (V val : range) {
        	boolean a = false;
    		for (Map.Entry<K, V> entry : map.entrySet()) {
        	    K key = entry.getKey();
        		if (val == map.get(key)) {
        			a = true;
        		}
        	}
    		if (!a) {
    			returnValue = false;
    		}
    	}	
        return returnValue;
    }
 
    /**
     * Returns the inverse of a mapping.
     * 
     * @param a Map (function).
     * @return the inverse map of a map, the inverse function.
     */
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> inverse = new HashMap<V, Set<K>>();	
        for (Map.Entry<K, V> entry : map.entrySet()) {
        	K key = entry.getKey();
    	    V value = entry.getValue();
    	    Set<K> set = new HashSet<K>();
    	    set.add(key);
    	    for (Map.Entry<K, V> entry2 : map.entrySet()) {
        	    K key2 = entry2.getKey();
        	    V value2 = entry2.getValue();
        	    if (value2 == value && key2 != key) {
        			// another key with the same value
        			set.add(key2);
        		}
        	}	
    	    inverse.put(value, set);
    	}        
        return inverse;
	}
    
    /**
     * Returns the inverse of a bijection mapping.
     * 
     * @param a Map (function).
     * @return the inverse map of a bijection map, the inverse function.
     */   
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        Map<V, K> inverse = new HashMap<V, K>();	
        for (Map.Entry<K, V> entry : map.entrySet()) {
        	K key = entry.getKey();
    	    V value = entry.getValue();	
    	    inverse.put(value, key);
    	}        
        return inverse;
	}

    /**
     * Checks whether the two given maps are compatible, i.e. if the values 
     * of the first map are in the key set of the second.
     * 
     * @param Two maps to be compared.
     * @return true if the two maps are compatible.
     */   
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		for (Map.Entry<K, V> entry : f.entrySet()) {
    	    boolean entryCompatible = false;
			V value = entry.getValue();
            for (Map.Entry<V, W> entry2 : g.entrySet()) {
            	V key2 = entry2.getKey();
            	if (value.equals(key2)) {
            		entryCompatible = true;
            		break;
            	}
        	}
            if (!entryCompatible) {
            	return false;
            }
    	}         
        return true;
	}

    /**
     * Composes the two maps given.
     * 
     * @param Two maps to be composed, provided that they are compatible.
     * @return a composed map of the two given maps.
     */   
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		Map<K, W> compose = new HashMap<K, W>();
		for (Map.Entry<K, V> entry : f.entrySet()) {
			K key = entry.getKey();
			V value = entry.getValue();
			compose.put(key, g.get(value));
    	}        
        return compose;
	}
}
