package oopCh10;

public interface StockWatcher {
	String samsung = "SAMSUNG";
	int samsungValue = 500000;
	String ktf = "KTF";
	

	void valueChanged(String stockName, double newValue);
}
