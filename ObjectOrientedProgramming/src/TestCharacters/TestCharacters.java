package TestCharacters;

public class TestCharacters {
	public static void main(String[] args) {
		char alpha = 'A';
		char hangul = 'ν';

		System.out.print("Roman: alpha = " + alpha);
		System.out.println(" = 0x" + Integer.toHexString(alpha));
		System.out.print("νκΈ: hangul = " + hangul);
		System.out.println(" = 0x" + Integer.toHexString(hangul));
	}
}