package sec01_finalmodifier.EX01_FinalModifier_1;

class A1 {
	int a = 3;
	final int b = 5;

	A1() {

	}
}

class A2 {
	int a;
	final int b;

	A2(){
		a=3;
		b=5;//final값은 반드시 초기화해야한다.
		}
}
class A3{
	int a =3 ;
	final int b =5;
	A3(){
		a=7;
		//b=7; //final 필드는 한번 정해진 값을 바꿀 수 없다.
	}
}
public class FinalModifier_1 {
	public static void main(String[] args) {
		// #1. 객체 생성
		A1 a1 = new A1();
		A2 a2 = new A2();
		a1.a = 7;
		// a1.b = 9; //final 필드는 한 번 정해진 값을 바꿀 수 없다.
		a2.a =7;
		//a2.b=10; 불가능
	}
}
