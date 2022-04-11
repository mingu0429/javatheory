package oopCh10;

//리스트 10.4 : StockApplet.java
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/* <applet code=StockApplet width=400 height=300>
 </applet> */

public class StockApplet extends Applet implements StockWatcher, ActionListener {

	TextField input; //사용자 입력
	Choice stocks; //주식 선택
	Button button;
	TextArea output;
	int count;

	public void init(){
		setLayout(new BorderLayout());

		output = new TextArea(10, 80);
		add(output, "Center");
	}
	//버튼 이벤트. Choice에서 주식을 가져온 후 input 에서 입력 값을
          //Double로  바꿔서 valueChanged 메쏘드에 전달함
	public void actionPerformed(ActionEvent e){
		count++;
		valueChanged(stocks.getSelectedItem(),
			     Double.valueOf(input.getText()).doubleValue());
	}
	//StockWatcher 인터페이스의 valueChanged 메쏘드 구현
	//각 주식의 등락폭이 10% 이상 혹은 이하일때 적절한 메세지 출력
	public void valueChanged(String stockName, double newValue){
		double temp;
		if(stockName.equals(samsung)){
			temp = samsungValue - newValue;
			if((temp / samsungValue) > 0.1){
				sell(stockName);
			}else if((temp / samsungValue) < -0.1){
				buy(stockName);
					}
	
	// 각 상황에 맞는 메세지 출력
	public void buy(String name){
		output.insert("\n", 0);
		output.insert("[" + count + "] 호경기입니다. 현재 " + name +
			   " 주식이 급등하고 있습니다. \n\t매입하시기 바랍니다.\n", 0);

	}}
