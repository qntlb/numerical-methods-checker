package info.quantlab.numericalmethods.computerarithmetics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DoubleVectorImplemenationChecker {

	public static boolean check(Class<?> theClass) {
		if(!DoubleVector.class.isAssignableFrom(theClass)) {
			System.out.println("Your class does not implement the interface " + DoubleVector.class.getName());
			return false;
		}

		Constructor<?> vectorConstructor;
		try {
			vectorConstructor = theClass.getConstructor(double[].class);
		}
		catch(Exception e) {
			System.out.println("Your class does not have a constructor that takes a double[] argument.");
			return false;
		}
		
		double[] testArgument = new double[] { 1, 2, 3 };
		DoubleVector vector;
		try {
			vector = (DoubleVector) vectorConstructor.newInstance(testArgument);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.out.println("Could not create an object of your class. The constructor failed.");
			return false;
		}

		return checkImplementation(vector);
	}

	private static boolean checkImplementation(DoubleVector vector) {
		return vector.sum() == 6;
	}
}
