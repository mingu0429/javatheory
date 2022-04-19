package oopCh3;

import java.text.ParseException;

public class TwoDimensionArray2 {
	public static void main(String[] args) {
		String y = "안녕하세요 안녕하세요";
		String parse[][]; // 이차원 스트링 배열
		parse = new String[args.length][];
		for (int j = 0; j < args.length; j++) {
			parse[j] = new String[args[j].length()];
			for (int k = 0; k < args[j].length(); k++)
				parse[j][k] = String.valueOf(args[j].charAt(k)); // 한 글자(char) 추출,스트링 변환
		}
		for (int j = 0; j < parse.length; j++) {
			for (int k = 0; k < parse[j].length; k++)
				System.out.print(parse[j][k] + " ");
			System.out.println("");
		}
		
//		System.out.println(y.length());
	}
}
