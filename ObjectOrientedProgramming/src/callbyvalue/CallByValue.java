package callbyvalue;

public class CallByValue {
    public static void main(String args[]) {
        Value obj = new Value();
        int a = 10, b = 20;

        System.out.println("호출전 a 와 b : " + a + ", " + b);
        obj.arith(a, b);
        System.out.println("호출후 a 와 b : " +  a + ", " + b);
    }
}

class Value {
    void arith(int i, int j) {
        i += 3;
        j -= 3;
    }
}