package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {
   
	/**
	 * Check if a Map is injective, or is one-to-one. It is injective if 
	 * for every value of the Map there is one and only one key for that value.
	 * @param map - Map with keys and values to be checked if one-to-one.
	 * @return result - true if for all int i and j;  map.get(i) = map.get(j) 
	 * only if i = j. If not false is returned.
	 */
	//@ ensures \result == (\forall int i, j ; map.get(i) == map.get(j) && i == j);
	public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        boolean result = true;
		
		for (int i = 0; i <= map.size(); i++) {
        	for (int j = map.size(); j >= 0; j--) {
        		if (map.get(i) == (map.get(j)) && i != j) {
        			result = false;
        		}
        	}
        }
        return result;
    }
	
	/**
	 * Check if a Map is surjective within a certain range. It is surjective 
	 * if for ever value in the range there is at least one key associated 
	 * with that value.
	 * @param map - Map with keys and values, to be checked if surjective 
	 * within a given range.
	 * @param range - a range of values that the Map's keys and values will be 
	 * compared against.
	 * @return result - true if forall int i, j; range[i] == map.get(j) else false.
	 */
	//@ ensures \result == (\forall int i ; map.values().containsAll(range));
    public static <K, V> 
           boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
    	boolean result = false;
    	
    	if (map.values().containsAll(range)) {
    		return true;
    	}
		
        return result;
    }
    
    /**
	 * Return the inverse of a Map.
	 * @param map - Map with keys and values, to be inverted
	 * @return result - the inverse of the Map which is a Map 
	 * made up of the values from the original Map, along 
	 * with a set containing the keys of those values.
	 */
	//@ ensures \result == (\forall int i ; map.values().containsAll(range));
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> result = new HashMap<V, Set<K>>();
        
        Set<K> temp1 = map.keySet();
        V temp2 = map.get(temp1);
        
        
        return result;
	}
    
    
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
        return null;
	}
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.4
        return false;
	}
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.5
        return null;
	}
}
