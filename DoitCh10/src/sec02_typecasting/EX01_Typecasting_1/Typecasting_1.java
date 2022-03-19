package sec02_typecasting.EX01_Typecasting_1;

class A {
}

class B extends A {
}

class C extends B {
}

class D extends B {
}

public class Typecasting_1 {
	public static void main(String[] args) {
		A ac = (A) new C(); // C->A 업캐스팅
		B bc = (B) new C();// C->B 업캐스팅

		B bb = new B();
		A a = (A) bb;

		// 다운캐스팅: 캐스팅할 수 없을 때
		A aa = new A();

		A ab = new B();
		B b = (B) ab;

		B bd = new D();
		D d = (D) bd;

		A ad = new D();
		B b1 = (B) ad;
		D d1 = (D) ad;

	}

}
