package ss.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
	//@ ensures\result instanceof Map<V, Set<K>>;
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> result = new HashMap<V, Set<K>>();

        for (K key : map.keySet()) {
        	Set<K> tmp = new HashSet<K>();
        	for (K key1 : map.keySet()) {
        		if (map.get(key).equals(map.get(key1)))  {
        			tmp.add(key1);

        			System.out.println("Key got added " + key1);
        		}
        		System.out.println("Key loop " + key1);

        	}
        	System.out.println("Key loop " + key);
        	result.put(map.get(key), tmp);

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
    //@ requires MapUtil.isOneonOne(map) && 
    // MapUtil.isSurjectiveOnRange(map, (Set<Integer>) map.values());
    //@ ensures \result instanceof Map<V, K>;
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        Map<V, K> result = new HashMap<V, K>();
       
        
        for (K key : map.keySet()) {
        	result.put(map.get(key), key);
        	
        }

        return result;
	}
	
	/**
	 * Return a boolean based on whether two maps are compatitble.
	 * @param f - a map with generic types K, V.
	 * @param g - a map with generic types V, W.
	 * @return \result == (\forall values v in map f : !(g.containsKey(v))
	 */
	/*@ pure */ public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {

		System.out.println("Test");
		System.out.println(f.values());
		System.out.println(g.values());
		
		for (V v : f.values()) {
			if (!g.containsKey(v)) {
				return false;
			}
		}
        return true;
	}
	
	/**
	 * Returns a map which is the composition of maps f and g.
	 * @param f - a map with generic types K, V.
	 * @param g - a map with generic types V, W.
	 * @return \result - a map of types K, W which is the composition of f and g. 
	 */
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		Map<K, W> result = new HashMap<K, W>();
		if (MapUtil.compatible(f, g)) {

			for (K key : f.keySet()) {
				V gKey = f.get(key);

				result.put(key, g.get(gKey));

			}
		}
		return result;
	}
}
