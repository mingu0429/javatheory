package oopHomeWork;

public class OopHomeWork_3_11 {
	public static void main(String[] args) {
		int i = 3, j = 4, k = 5;
		float x = 3.455f, y = 6.0f;

		System.out.println(-x * -y * (i + j) / k);// (a)
		float i2 = (float) i; //계산을 위해 i를 실수형으로 변환
		System.out.println(i2 / 5 * y);// (b)

		System.out.println(y % x);// (c)
		
		x = x / i / y / j;
		System.out.println(x);// (d)
		
		System.out.println(Math.exp(j % i));// (e) Math.exp를 사용
		
		System.out.println(Math.pow(3, 2));// (f) Math.pow를 사용
		
		System.out.println(Math.min(y, Math.max(i, k)));// (g) Math.min과 Math.max를 사용
		
		System.out.println(Math.ceil(x) % i);// (h) Math.ceil를 사용
		
		System.out.println((x + 2.4) / (140.0 * (i2 / j)));// (i)
	}
}
