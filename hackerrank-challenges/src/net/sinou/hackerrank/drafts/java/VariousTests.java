package net.sinou.hackerrank.drafts.java;

import java.util.ArrayList;
import java.util.Iterator;

/** Various patterns and tests */
public class VariousTests {

	static <T> Iterator<T> func(ArrayList<T> mylist) {
		Iterator<T> it = mylist.iterator();
		while (it.hasNext()) {
			Object element = it.next();
			if (element instanceof String && "###".equals((String) element))
	            break;
	      }
	      return it;
	   }

	static String upperFirst(String s) {
		if (s.length()==0)
			return s;
		else if (s.length()==1)
			return s.toUpperCase();
		else 
			return s.substring(0,1).toUpperCase()+s.substring(1);
	}
}
