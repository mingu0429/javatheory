package oopHomeWork;

public class OopHomeWork_3_12 {

	public static double sqrt(double a, double b, double c) {
		double result = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
		return result;
	}

	public static double cbrt(int x, int y) {
		return Math.pow(x * y, 1.0 / 3.0);
	}

	public static double pi(int r) {
		return Math.PI * Math.pow(r, 2);
	}

	public static double sincos(double theta) {
		return Math.sin(Math.toRadians(theta)) / Math.cos(Math.toRadians(theta));
	}

	public static double division(double x) {
		return x / 2;
	}

	public static double function(double c) {
		double f = 1.8 * c + 32;
		return f;
	}

	public static void main(String[] args) {
		System.out.println("B^2-4AC의 제곱근: " + sqrt(1, 4, 3));//a 
		System.out.println("X와 Y의 곱의 세제곱근: " + cbrt(2, 4));//b
		System.out.println("pi * R^2: " + pi(10));//c
		System.out.println("sin theta / cos theta: " + sincos(45));//d
		System.out.println("X/2: " + division(25));//e
		System.out.println("F = 1.8 * C + 32: "+ function(10));//f
	}

}
