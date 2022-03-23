package sec02_staticinnerclass.EX01_CreateObjectAndAccessMember;

class A {
	int a = 3;
	static int b = 4;
	void method1() {
		System.out.println("instance method");
	}
	static void method2() {
		System.out.println("static method");
	}
	
	static class B{
		void bcd() {
			
			//System.out.println(a);정적 이너 클래스는 아우터 클래스의 정적 멤버만 사용 가능
			System.out.println(b);
			
			method2();
		}
	}
}
public class CreateObjectAndAccessMember {
	public static void main(String[] args) {
		A.B b = new A.B();
		
		b.bcd();
	}
}
