package sec06_objectclass.EX01_ObjectMethod_toString;

class A {
	int a = 3;
	int b = 4;
}

class B {
	int a = 3;
	int b = 4;

	public String toString() {
		return "필드값(a, b) = " + a + " " + b;
	}
}

public class ObjectMethod_toString {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();

		System.out.printf("%x\n", a.hashCode()); //hashcode를 16진수로 표현
		System.out.println(a.toString());
		System.out.println(b);
	}

}
