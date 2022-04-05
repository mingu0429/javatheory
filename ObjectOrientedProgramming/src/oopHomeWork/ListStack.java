package oopHomeWork;

interface StackInterface {//스택 인터페이스
    boolean isEmpty();
    boolean isFull();
    void push(String data);
    void pop();
    void peek();
    void clear();
}

public class ListStack implements StackInterface{

	class ListStackNode {
		
	    private String nodeData;    // 데이터 저장 변수
	    public ListStackNode link;    // 다른 노드를 참조할 링크
	     
	    public ListStackNode() {
	        this.nodeData = null;
	        this.link = null;
	    }
	     
	    public ListStackNode(String data) {
	        this.nodeData = data;
	        this.link = null;
	    }
	    
	    public ListStackNode(String data, ListStackNode link) {
	        this.nodeData = data;
	        this.link = link;
	    }
	    
	    public String getData() {
	        return this.nodeData;
	    }
	}
	
	
	 private ListStackNode head;    // ListStackNode 타입 head 노드 인스턴스 변수
	    private ListStackNode top;    // 스택의 top 포인터
	    private int stackSize;    // 스택사이즈
	    
	    public ListStack(int size) {
	        head = null; // head 초기화
	        top = null;    // top 포인터 초기화
	        this.stackSize = size;    // 스택 사이즈 초기화
	    }
	    
	    public boolean isEmpty(){// 스택이 비어있는 상태인지 확인
	        return (top == null);
	    }

	    public boolean isFull() {	    
		    // 스택이 가득찬 상태인지 확인
	        // 스택 비어있을 경우 false 리턴
	        if(isEmpty()) {
	            return false;
	        } 
	        // 스택 포인터가 null이 아닌 경우 count 계산
	        else {
	            int nodeCount = 0;
	            ListStackNode tempNode = head;    // tempNode에 head 할당
	            
	            while(tempNode.link != null) {
	                ++nodeCount;
	                tempNode = tempNode.link;
	            }
	            // 스택 사이즈와 노드 카운트가 동일한 경우 true 리턴
	            return (this.stackSize-1 == nodeCount);
	        }
	    }
	    
	    // 마지막 스탭 삽입 (push)
	    public void push(String data) {
	        ListStackNode newNode = new ListStackNode(data);
	        // 스택이 가득 찬 경우
	        if(isFull()) {
	            System.out.println("스택이 가득찼습니다.");
	            return;
	        } 
	        // 스택이 비었을 경우
	        else if(isEmpty()) {
	            // top 포인터가 null인 경우 top과 head는 새로운 노드를 참조
	            this.head = newNode;
	            this.top = this.head;
	        } else {
	            // top 노드가 null이 아닌 경우 temp 노드가 top을 참조
	            ListStackNode tempNode = top;
	            
	            // while문을 이용하여 가장 마지막 노드를 참조하는 tempNode
	            while(tempNode.link != null) {
	                tempNode = tempNode.link;
	            }
	            // tempNode의 link가 다음 노드를 참조 
	            tempNode.link = newNode;
	        }
	    }
	    
	    // 스택에서 Node 삭제할 경우 스택구조상 마지막노드 삭제 (pop)
	    public void pop() {
	        ListStackNode prevNode;
	        ListStackNode tempNode;
	        
	        // top 포인터가 null인 경우
	        if(isEmpty()) {
	            System.out.println("스택이 비어있습니다.");
	            return;
	        }
	        // top 포인터의 link가 null인 경우 = 노드가 1개 남았을 경우
	        if(top.link == null) {
	            // head와 top 포인터에 null을 할당하여 남은 노드와의 연결을 끊고 초기화
	            head = null;
	            top = null;
	        } else {
	            prevNode = top;    // prevNode는 top 포인터가 가리키는 노드를 할당
	            tempNode = top.link;    // tempNode는 top 포인터가 가리키는 노드의 다음 노드 (prevNode의 다음 노드) 
	            // while문을 활용하여 prevNode는 마지막 노드의 이전 노드가 되고, tempNode는 마지막 노드로 됨
	            while(tempNode.link != null) {
	                prevNode = tempNode;
	                tempNode = tempNode.link;
	            }
	            // prevNode의 link를 null로 만들어서 가장 마지막 노드를 삭제
	            prevNode.link = null;
	        }
	    }
	    
	    // 스택의 마지막 데이터 나타내기(peek)
	    public void peek() {
	        if(isEmpty()) {
	            System.out.println("스택이 비어있습니다.");
	            return;
	        } else {
	            ListStackNode tempNode = top;
	            while(tempNode.link != null) {
	                tempNode = tempNode.link;
	            }
	            System.out.println(tempNode.getData());
	        }
	    }
	    
	    // 스택을 초기화할 경우
	    public void clear() {
	        if(isEmpty()) {
	            System.out.println("스택이 비어있습니다.");
	            return;
	        } else {
	            head = null;
	            top = null;
	        }
	    }
	    // 스택 Node 검색할 경우
	    public ListStackNode searchNode(String data) {
	        ListStackNode tempNode = this.top;
	        // temp 노드에 top 포인터가 가리키는 노드를 할당
	        // while문을 활용하여 검색
	        while(tempNode != null) {
	            if(data.equals(tempNode.getData())) {
	                return tempNode;
	            } else {
	                tempNode = tempNode.link;
	            }
	        }
	        
	        return tempNode;
	    }
	    
	    // 스택리스트에 있는 모든 데이터를 출력
	    public void displayListStack() {
	        if(isEmpty()) {//스택이 비어있다면
	            System.out.println("스택이 비어있습니다.");
	            return;
	        } else {
	            ListStackNode tempNode = this.top;  
	            //While문을 활용하여 출력
	            while(tempNode != null) {
	                System.out.print(tempNode.getData() + " ");
	                tempNode = tempNode.link;
	            }
	            System.out.println();
	        }
	    }
	 
	    public static void main(String args[]) {
	        int stackSize = 4;//스택사이즈는 4로 구성
	        
	        ListStack listStack = new ListStack(stackSize);//스택리스트 생성
	        
	        listStack.displayListStack();//스택 확인
	        System.out.print("2010 남아공 월드컵 4강전: ");
	        listStack.push("스페인");//스택 삽입
	        listStack.push("네덜란드");
	        listStack.push("우루과이");
	        listStack.push("독일");
	        listStack.displayListStack();//스택 출력
	      
	        listStack.push("대한민국");//가득찬 스택에 대한민국을 넣을 경우
	       
	        System.out.print("2010 남아공 월드컵 결승전: ");
	        listStack.pop();//스택 삭제
	        listStack.pop();
	        listStack.displayListStack();
	        System.out.print("2010 남아공 월드컵 우승팀: ");
	        listStack.pop();
	        listStack.displayListStack();
	    }
	    


}
