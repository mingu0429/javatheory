package callByRef;

public class CallByRef {
	public static void main(String[] args) {
		Ref obj = new Ref(10, 20);
		System.out.println("호출 전 obj.a와 obj.b: " + obj.a + ", " + obj.b);
		obj.arith(obj);
		System.out.println("호출 후 obj.a와 obj.b: " + obj.a + ", " + obj.b);
	}
}

class Ref {
	int a, b;

	Ref(int i, int j) {
		a = i;
		b = j;
	}

	void arith(Ref fo) {
		fo.a += 3;
		fo.b -= 3;
	}
}