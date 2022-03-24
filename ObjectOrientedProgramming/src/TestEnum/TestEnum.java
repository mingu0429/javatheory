package TestEnum;

enum Week {
	월, 화, 수, 목, 금, 토, 일
}

public class TestEnum {
	enum RGB {
		red, green, blue
	}

	public static void main(String[] args) {
		Week today = Week.월;
		RGB color = RGB.red;

		System.out.println("피곤한 오늘은: " + today + "요일");
		System.out.println("즐거운 주말은: " + Week.토 + "요일");
		System.out.println("단풍잎 색깔은: " + color);
		color = RGB.green;
		System.out.println("여름엔 색깔이: " + RGB.green);
	}
}