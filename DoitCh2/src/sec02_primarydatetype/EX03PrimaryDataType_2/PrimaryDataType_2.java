package sec02_primarydatetype.EX03PrimaryDataType_2;

public class PrimaryDataType_2 {
	public static void main(String[] args) {

		char value1 = 'A';
		char value2 = '가';
		char value3 = '3';
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println();

		char value4 = 65;
		char value5 = 0xac00;
		char value6 = 51;
		System.out.println(value4);
		System.out.println(value5);
		System.out.println(value6);
		System.out.println();

		char value7 = '\u0041';
		char value8 = '\uac00';
		char value9 = '\u0033';

		System.out.println(value7);
		System.out.println(value8);
		System.out.println(value9);

	}

}
