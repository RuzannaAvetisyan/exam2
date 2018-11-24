package am.aca;

import java.lang.reflect.Field;
import java.util.*;

public class Validator {
    boolean isValid(Object object) {
    	if(object == null){
    		return false;
    	} else {
    		Class<?> sc = object.getClass(); 

			Field[] fs = sc.getDeclaredFields();
			for(Field f: fs){
				f.setAccessible(true);
				try{
					Object ob = f.get(object);
					if (f.isAnnotationPresent(NotEmpty.class) || f.isAnnotationPresent(NotNull.class) || f.isAnnotationPresent(Valid.class)){
						if (f.isAnnotationPresent(Valid.class)){
							Valid v = f.getAnnotation(Valid.class);
							double minValue = (float)v.minValue();
							double maxValue = (float)v.maxValue();
							double val = (double)getFloatAsDouble((Float)ob);
							if ((val >= minValue) && (val  <= maxValue)){
								continue;
							}else{
								return false;
							}		
						}
						if(f.isAnnotationPresent(NotEmpty.class)){
							if(ob instanceof Collection<?> && !((Collection)ob).isEmpty() && !((Collection)ob).contains(null)){ 
								continue;
							}else{
								return false;
							}
						}
						if(f.isAnnotationPresent(NotNull.class)){
							if(ob != null){
								continue;
							}else{
								return false;
							}
						}
					} else {
						continue;
					}
				} catch(IllegalAccessException e){}			
			}
    	}
		return true;
    }

    private static Double getFloatAsDouble(Float value) {
    	return Double.valueOf(value.toString());
	}
}  


