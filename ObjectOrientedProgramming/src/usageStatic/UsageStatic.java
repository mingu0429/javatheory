package usageStatic;

public class UsageStatic {
	public static void main(String[] args) {
		int a = 5, b = Calcs.magic;
		int c = Calcs.sum(3, 4);
		System.out.println("a = " + a + " b = " + b + " c = " + c);
		c = Calcs.diff(a, b);
		System.out.println("a = " + a + " b = " + b + " c = " + c);
	}
}

class Calcs {
	public static int magic = 20;

	public static int sum(int x, int y) {
		return x + y;
	}

	public static int diff(int x, int y) {
		return x - y;
	}
}