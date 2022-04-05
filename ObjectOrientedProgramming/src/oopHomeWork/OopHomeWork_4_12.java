package oopHomeWork;

import java.util.Stack;//스택 임포트

public class OopHomeWork_4_12 {
	public static void main(String[] args) {
		
		String[] weeks = {"일","토", "금","목","수","화","월"};//리스트 생성
		
		Stack<String> stack = new Stack<String>();//스택 생성
		
		for(int i = 0 ; i<weeks.length;i++) {
			stack.push(weeks[i]);//스택 삽입
		}
		System.out.print("일주일: ");
		
		while(!stack.isEmpty()) {//현 스택 모두 출력
			System.out.print(stack.pop()+ " ");
		}
		System.out.println();
		System.out.print("주 말 : ");
		
		stack.push("일");
		stack.push("토");
		
		System.out.print(stack.pop()+" ");//스택 출력하면서 삭제
		System.out.print(stack.pop());

		
		
	}
}
