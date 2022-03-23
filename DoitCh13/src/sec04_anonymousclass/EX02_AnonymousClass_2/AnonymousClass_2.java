package sec04_anonymousclass.EX02_AnonymousClass_2;

class A {
	C c = new C() {
		public void bcd() {
			System.out.println("익명 이너 클래스");
		}
	};
	void abc() {
		c.bcd();
	}
}
interface C{
	public abstract void bcd();
}
public class AnonymousClass_2 {
	public static void main(String[] args) {
		A a = new A();
		a.abc();
	}
}
