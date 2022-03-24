package TestCharacters;

public class TestCharacters {
	public static void main(String[] args) {
		char alpha = 'A';
		char hangul = '한';

		System.out.print("Roman: alpha = " + alpha);
		System.out.println(" = 0x" + Integer.toHexString(alpha));
		System.out.print("한글: hangul = " + hangul);
		System.out.println(" = 0x" + Integer.toHexString(hangul));
	}
}