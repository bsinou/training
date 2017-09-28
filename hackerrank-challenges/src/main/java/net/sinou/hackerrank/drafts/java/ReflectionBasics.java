package net.sinou.hackerrank.drafts.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class ReflectionBasics {

	static void listMethods(String[] args) {
		// Class<? extends Student> student = new Student().getClass();
		// Rather use class literal
		@SuppressWarnings("rawtypes")
		Class student = String.class;

		// List all methods
		// Method[] methods = student.getMethods();
		// List only accessible methods declared in Student.class, not parent methods
		Method[] methods = student.getDeclaredMethods();

		ArrayList<String> methodList = new ArrayList<>();
		for (Method method : methods)
			methodList.add(method.getName());

		Collections.sort(methodList);
		for (String name : methodList)
			System.out.println(name);

	}

	static void listMethodsJ8(String[] args) {
		Stream.of(Student.class.getDeclaredMethods()).map(Method::getName).sorted().forEach(System.out::println);
	}

}

class AccessPrivateNestedClass {

	public static void main(String[] args) throws Exception {
		DoNotTerminate.forbidExit();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine().trim());

			// Using reflection
			// Class[] secondLevelClazzes = Inner.class.getDeclaredClasses();
			// Constructor[] constructors = secondLevelClazzes[0].getDeclaredConstructors();
			// constructors[0].setAccessible(true);
			// Object o = constructors[0].newInstance(new Inner());

			// Directly
			Object o = new Inner().new Private();

			System.out.println(num + " is " + ((Inner.Private) o).powerof2(num));
			System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

		} // end of try

		catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}// end of main

	static class Inner {
		private class Private {
			private String powerof2(int num) {
				return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
			}
		}
	}// end of Inner

}// end of Solution

class DoNotTerminate { // This class prevents exit(0)

	public static class ExitTrappedException extends SecurityException {

		private static final long serialVersionUID = 1L;
	}

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
}
