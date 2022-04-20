package oopCh6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Shuffle {
public static void main(String[] args) {
	 
	List <String> list = new ArrayList<String>();
	list.add("가");
	list.add("나");
	list.add("다");
	list.add("라");
	Collections.sort(list);
	System.out.println(list);
	Collections.shuffle(list);
	System.out.println(list);
}
}
