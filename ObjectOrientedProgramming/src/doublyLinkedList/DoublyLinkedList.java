package doublyLinkedList;

public class DoublyLinkedList {
    private Node listHead;//리스트헤드
    private Node listTail;//리스트tail
    private int size = 0;
 
    private class Node {
        private Object data;
        // 왼쪽 노드와 오른쪽 노드
        private Node rightNode;
        private Node leftNode;
 
        public Node(Object input) {
            this.data = input;
            this.rightNode = null;
            this.leftNode = null;
        }
    }
    Node node(int index) {
        //이중링크드리스트의 장점을 활용, 기존 링크드리스트보다 검색이 빠름
        if (index < size / 2) {
            // 인덱스가 사이즈의 절반 이하라면 head부터 해당노드를 검색
            Node x = listHead;
            for (int i = 0; i < index; i++)
                x = x.rightNode;
            return x;
        } else {
            // 아니라면 tail부터 해당노드를 검색
            Node x = listTail;
            for (int i = size - 1; i > index; i--)
                x = x.leftNode;
            return x;
        }
    }
 
    public void addFirst(Object input) {//첫번째에 노드 삽입할 경우
        Node insertNode = new Node(input);
        // 새 노드의 다음 노드로 헤드를 지정
        insertNode.rightNode = listHead;
        // 기존에 노드가 있었다면 현재 헤드의 이전 노드로 새로운 노드를 지정
        if (listHead != null)
            listHead.leftNode = insertNode;
        // 헤드로 새로운 노드를 지정
        listHead = insertNode;
        size++;
        if (listHead.rightNode == null) {
            listTail = listHead;
        }
    }
 
    public void addLast(Object input) {//마지막에 노드 삽입할 경우
        Node newNode = new Node(input);
        // 리스트의 노드가 없다면 addFirst()
        if (size == 0) {
            addFirst(input);
        } else {
            // tail의 rightNode에 생성한 노드를 지정
            listTail.rightNode = newNode;
            // 새노드의 leftNode에 tail을 지정
            newNode.leftNode = listTail;
            // 마지막 노드 갱신
            listTail = newNode;
            // 리스트의 size 1증가
            size++;
        }
    }
 

    public void add(int m, Object input) {//추가하려는 위치에 노드를 삽입할 경우
        // m의 값이 0이라면 addFirst()
        if (m == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(m - 1);
            // m번째 노드를 temp2로 지정
            Node temp2 = temp1.rightNode;
            Node newNode = new Node(input);
            // temp1의 rightNode로 새 노드를 지정
            temp1.rightNode = newNode;
            // 새 노드의 rightNode로 temp2를 지정
            newNode.rightNode = temp2;
            // temp2의 leftNode로 새 노드를 지정
            if (temp2 != null)
                temp2.leftNode = newNode;
            // 새 노드의 leftNode로 temp1을 지정
            newNode.leftNode = temp1;
            size++;
            // 새 노드의 rightNode가 없다면 tail로 지정
            if (newNode.rightNode == null) {
                listTail = newNode;
            }
        }
    }
 
    public String displayDoublyLinkedList() {
        // 노드가 없다면 빈칸을 리턴
        if (listHead == null) {
            return "  ";
        }
        Node temp = listHead;
        String str = " ";
        // rightNode 노드가 없을 때까지 검색 반복문을 실행
        while (temp.rightNode != null) {
            str += temp.data + " ";
            temp = temp.rightNode;
        }
        // 마지막 노드를 출력결과에 포함시킴
        str += temp.data;
        return str + " ";
    }
 
    public Object removeFirst() {//첫번째 노드를 삭제할 경우
        // 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경
        Node temp = listHead;
        listHead = temp.rightNode;
        // 데이터 삭제 전 리턴 값을 임시 변수에 삽입
        Object returnData = temp.data;
        temp = null;
        // 리스트 내에 노드가 있다면 head의 leftNode를 null로 지정
        if (listHead != null)
            listHead.leftNode = null;
        size--;
        return returnData;
    }
 
    public Object remove(int k) {//k번째 노드를 삭제할 경우
        if (k == 0)
            return removeFirst();
        // k-1번째 노드를 temp로 지정
        Node temp = node(k - 1);
        // temp.next 삭제 전 todoDeleted 변수에 보관
        Node todoDeleted = temp.rightNode;
        // 삭제 대상 노드를 연결에서 분리
        temp.rightNode = temp.rightNode.rightNode;
        if (temp.rightNode != null) {
            // 삭제 대상 노드의 전후 노드를 연결
            temp.rightNode.leftNode = temp;
        }
        // 삭제된 노드의 데이터를 리턴하기 위해서 returnData에 데이터를 저장
        Object returnData = todoDeleted.data;
        // 삭제된 노드가 tail이었다면 tail을 이전 노드를 tail로 지정
        if (todoDeleted == listTail) {
            listTail = temp;
        }
        // cur.next를 삭제
        todoDeleted = null;
        size--;
        return returnData;
    }
 
    public Object removeLast() {//마지막 노드를 삭제할 경우 remove()
        return remove(size - 1);
    }
 
    public int size() {
        return size;
    }
 
    public Object get(int k) {//인덱스로 엘리먼트 가져옴
        Node temp = node(k);
        return temp.data;
    }
 
    public int indexOf(Object data) {//특정 데이터가 저장된 인덱스를 찾기
        // 탐색 대상 노드를 temp로 지정
        Node temp = listHead;
        // 탐색 대상의 index
        int index = 0;
        // while문을 이용하여 탐색 값과 탐색 대상의 값을 비교
        while (temp.data != data) {
            temp = temp.rightNode;
            index++;
            // temp의 값이 null이면은 탐색 대상이 없다는 뜻이므로 -1을 리턴
            if (temp == null)
                return -1;
        }
        // 탐색 대상의 인덱스값 리턴
        return index;
    }
    
    public static void main(String[] args) {
		
		DoublyLinkedList listA = new DoublyLinkedList();
		System.out.print("2010 남아공 월드컵 4강전 : ");
		listA.addFirst("스페인"); //처음값에 스페인 삽입
		listA.add(1,"독일"); //지정한 인덱스에 독일,우루과이 삽입
		listA.add(2,"우루과이");
		listA.addLast("네덜란드");// 마지막에 네덜란드 삽입
		System.out.println(listA.displayDoublyLinkedList()+"\n");
		System.out.println("독일은 "+listA.indexOf("독일")+"번째 참가국입니다.");//데이터로 인덱스 찾기
		listA.remove(1);//1, 2번째 데이터 삭제
		listA.remove(2);
		System.out.print("2010 남아공 월드컵 결승전 : ");
		System.out.println(listA.displayDoublyLinkedList());
		
	}
}