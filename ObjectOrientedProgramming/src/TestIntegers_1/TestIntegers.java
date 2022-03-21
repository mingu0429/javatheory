package TestIntegers_1;

public class TestIntegers {
	public static void main(String[] args) {
		byte b1 = 127, b2 = 1;
		short s1 = 32767, s2 =1;
		int n1 = 1048575, n2 =1;
		long g1 = 2147483647L, g2 = 1L;
		
		System.out.println();
		System.out.println("bytes: { b1 = "+b1+", b2 = "+b2+"}");
		System.out.println("byte:b1 + 1 ="+ (b1+1));
		System.out.println("byte:b1 + b2 = "+ (b1+b2));
		System.out.println("byte:++b1(1증가) = "+ (++b1));
		System.out.printf("참고(16진):b1 = %X > %X, b2 = %02X \n", b1, (byte)(b1-1),b2);
		
		System.out.println();
		System.out.println("short: { s1 = "+s1+", s2 = "+s2+"}");
		System.out.println("shorts:1 + 1 = "+ (s1+1));
		System.out.println("short:s1 +s2 = "+ (s1+s2));
		System.out.println("short:++s1(1증가) = "+ (++s1));
		System.out.printf("참고(16진):s1 = %X > %X, s2 = %04X \n", s1, (short)(s1-1),s2);
		
		System.out.println();
		System.out.println("int: { n1 = "+n1+", n2 = "+n2+"}");
		System.out.println("int:n1 + 1 = "+ (n1+1));
		System.out.println("int:n1 +n2 = "+ (n1+n2));
		System.out.println("int:++n1(1증가) = "+ (++n1));
		System.out.printf("참고(16진):n1 = %08X > %08X, n2 = %08X \n", n1, (n1-1), n2);
		
		System.out.println();
		System.out.println("long: { g1 = "+g1+", g2 = "+g2+"}");
		System.out.println("long:(int)g1 + 1 = "+ ((int)g1+1));
		System.out.println("long:g1 +g2 = "+(g1+g2));
		System.out.println("long:g1 +n2 = "+ (g1+n2));
		System.out.println("long:++g1(1증가) = "+ (++g1));
		System.out.printf("참고(16진):g1 = %016X > %016X\n", g1, (g1-1));
	}

}
