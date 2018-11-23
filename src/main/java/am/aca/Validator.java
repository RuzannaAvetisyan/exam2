package am.aca;

import java.lang.reflect.Field;
import java.io.*;
import java.util.*;

public class Validator {
    boolean isValid(Object object) throws Exception {
    	
        Class<?> sc = object.getClass(); 

		Field[] fs = sc.getDeclaredFields();
		for(Field f: fs){
			f.setAccessible(true);
			if (f.isAnnotationPresent(NotEmpty.class) || f.isAnnotationPresent(NotNull.class) || f.isAnnotationPresent(Valid.class)){
				if(f.isAnnotationPresent(NotNull.class)){
					if(f.get(object).getClass().isPrimitive()) return false;
					else if (f.get(object) == null) return false;
					else continue;
				}
				if(f.isAnnotationPresent(NotEmpty.class)){
					if(f.get(object).getClass().isPrimitive()) return false;
					else if (!(f.get(object) instanceof Collection<?>)) return false;
					else if (f.get(object) == null) return false;
					else continue;
				}
				//Annotation[] an = f.getDeclaredAnnotations();
				if (f.isAnnotationPresent(Valid.class)){
					Valid v = f.getAnnotation(Valid.class);
					double minValue = v.minValue();
					double maxValue = v.maxValue();
					if ((Double)f.get(object) < minValue && (Double)f.get(object) > maxValue) return false;
					else continue;
				}
				

				
			}else continue;
		}
			
	
		return true;

    }
}    