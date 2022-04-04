package doublyLinkedList;

public class DoublyLinkedList {
    // 첫번째 노드를 가리키는 필드
    private Node listHead;
    private Node listTail;
    private int size = 0;
 
    private class Node {
        // 데이터가 저장될 필드
        private Object data;
        // 다음 노드를 가리키는 필드
        private Node rightNode;
        private Node leftNode;
 
        public Node(Object input) {
            this.data = input;
            this.rightNode = null;
            this.leftNode = null;
        }
 
//        // 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
//        public String toString() {
//            return String.valueOf(this.data);
//        }
    }
 
    public void addFirst(Object input) {
        // 노드를 생성합니다.
        Node insertNode = new Node(input);
        // 새로운 노드의 다음 노드로 헤드를 지정합니다.
        insertNode.rightNode = listHead;
        // 기존에 노드가 있었다면 현재 헤드의 이전 노드로 새로운 노드를 지정합니다.
        if (listHead != null)
            listHead.leftNode = insertNode;
        // 헤드로 새로운 노드를 지정합니다.
        listHead = insertNode;
        size++;
        if (listHead.rightNode == null) {
            listTail = listHead;
        }
    }
 
    public void addLast(Object input) {
        // 노드를 생성합니다.
        Node newNode = new Node(input);
        // 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용합니다.
        if (size == 0) {
            addFirst(input);
        } else {
            // tail의 다음 노드로 생성한 노드를 지정합니다.
            listTail.rightNode = newNode;
            // 새로운 노드의 이전 노드로 tail을 지정합니다.
            newNode.leftNode = listTail;
            // 마지막 노드를 갱신합니다.
            listTail = newNode;
            // 엘리먼트의 개수를 1 증가 시킵니다.
            size++;
        }
    }
 
    Node node(int index) {
        // 노드의 인덱스가 전체 노드 수의 반보다 큰지 작은지 계산
        if (index < size / 2) {
            // head부터 next를 이용해서 인덱스에 해당하는 노드를 찾습니다.
            Node x = listHead;
            for (int i = 0; i < index; i++)
                x = x.rightNode;
            return x;
        } else {
            // tail부터 prev를 이용해서 인덱스에 해당하는 노드를 찾습니다.
            Node x = listTail;
            for (int i = size - 1; i > index; i--)
                x = x.leftNode;
            return x;
        }
    }
 
    public void add(int k, Object input) {
        // 만약 k가 0이라면 첫번째 노드에 추가하는 것이기 때문에 addFirst를 사용합니다.
        if (k == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(k - 1);
            // k 번째 노드를 temp2로 지정합니다.
            Node temp2 = temp1.rightNode;
            // 새로운 노드를 생성합니다.
            Node newNode = new Node(input);
            // temp1의 다음 노드로 새로운 노드를 지정합니다.
            temp1.rightNode = newNode;
            // 새로운 노드의 다음 노드로 temp2를 지정합니다.
            newNode.rightNode = temp2;
            // temp2의 이전 노드로 새로운 노드를 지정합니다.
            if (temp2 != null)
                temp2.leftNode = newNode;
            // 새로운 노드의 이전 노드로 temp1을 지정합니다.
            newNode.leftNode = temp1;
            size++;
            // 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정합니다.
            if (newNode.rightNode == null) {
                listTail = newNode;
            }
        }
    }
 
    public String displayDoublyLinkedList() {
        // 노드가 없다면 []를 리턴합니다.
        if (listHead == null) {
            return "  ";
        }
        // 탐색을 시작합니다.
        Node temp = listHead;
        String str = " ";
        // 다음 노드가 없을 때까지 반복문을 실행합니다.
        // 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됩니다.
        while (temp.rightNode != null) {
            str += temp.data + " ";
            temp = temp.rightNode;
        }
        // 마지막 노드를 출력결과에 포함시킵니다.
        str += temp.data;
        return str + " ";
    }
 
    public Object removeFirst() {
        // 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경합니다.
        Node temp = listHead;
        listHead = temp.rightNode;
        // 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담습니다.
        Object returnData = temp.data;
        temp = null;
        // 리스트 내에 노드가 있다면 head의 이전 노드를 null로 지정합니다.
        if (listHead != null)
            listHead.leftNode = null;
        size--;
        return returnData;
    }
 
    public Object remove(int k) {
        if (k == 0)
            return removeFirst();
        // k-1번째 노드를 temp로 지정합니다.
        Node temp = node(k - 1);
        // temp.next를 삭제하기 전에 todoDeleted 변수에 보관합니다.
        Node todoDeleted = temp.rightNode;
        // 삭제 대상 노드를 연결에서 분리합니다.
        temp.rightNode = temp.rightNode.rightNode;
        if (temp.rightNode != null) {
            // 삭제할 노드의 전후 노드를 연결합니다.
            temp.rightNode.leftNode = temp;
        }
        // 삭제된 노드의 데이터를 리턴하기 위해서 returnData에 데이터를 저장합니다.
        Object returnData = todoDeleted.data;
        // 삭제된 노드가 tail이었다면 tail을 이전 노드를 tail로 지정합니다.
        if (todoDeleted == listTail) {
            listTail = temp;
        }
        // cur.next를 삭제 합니다.
        todoDeleted = null;
        size--;
        return returnData;
    }
 
    public Object removeLast() {
        return remove(size - 1);
    }
 
    public int size() {
        return size;
    }
 
    public Object get(int k) {
        Node temp = node(k);
        return temp.data;
    }
 
    public int indexOf(Object data) {
        // 탐색 대상이 되는 노드를 temp로 지정합니다.
        Node temp = listHead;
        // 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용합니다.
        int index = 0;
        // 탐색 값과 탐색 대상의 값을 비교합니다.
        while (temp.data != data) {
            temp = temp.rightNode;
            index++;
            // temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미합니다.이 때 -1을 리턴합니다.
            if (temp == null)
                return -1;
        }
        // 탐색 대상을 찾았다면 대상의 인덱스 값을 리턴합니다.
        return index;
    }
 
    // 반복자를 생성해서 리턴해줍니다.
    public ListIterator listIterator() {
        return new ListIterator();
    }
 
    public class ListIterator {
        private Node lastReturned;
        private Node next;
        private int nextIndex;
 
        ListIterator() {
            next = listHead;
            nextIndex = 0;
        }
 
        // 본 메소드를 호출하면 cursor의 참조값이 기존 cursor.next로 변경됩니다.
        public Object next() {
            lastReturned = next;
            next = next.rightNode;
            nextIndex++;
            return lastReturned.data;
        }
 
        // cursor의 값이 없다면 다시 말해서 더 이상 next를 통해서 가져올 노드가 없다면 false를 리턴합니다.
        // 이를 통해서 next를 호출해도 되는지를 사전에 판단할 수 있습니다.
        public boolean hasNext() {
            return nextIndex < size();
        }
 
        public boolean hasPrevious() {
            return nextIndex > 0;
        }
 
        public Object previous() {
            if (next == null) {
                lastReturned = next = listTail;
            } else {
                lastReturned = next = next.leftNode;
            }
            nextIndex--;
            return lastReturned.data;
        }
 
        public void add(Object input) {
            Node newNode = new Node(input);
            if (lastReturned == null) {
                listHead = newNode;
                newNode.rightNode = next;
            } else {
                lastReturned.rightNode = newNode;
                newNode.leftNode = lastReturned;
                if (next != null) {
                    newNode.rightNode = next;
                    next.leftNode = newNode;
                } else {
                    listTail = newNode;
                }
            }
            lastReturned = newNode;
            nextIndex++;
            size++;
        }
 
        public void remove() {
            if (nextIndex == 0) {
                throw new IllegalStateException();
            }
            Node n = lastReturned.rightNode;
            Node p = lastReturned.leftNode;
 
            if (p == null) {
                listHead = n;
                listHead.leftNode = null;
                lastReturned = null;
            } else {
                p.rightNode = next;
                lastReturned.leftNode = null;
            }
 
            if (n == null) {
                listTail = p;
                listTail.rightNode = null;
            } else {
                n.leftNode = p;
            }
 
            if (next == null) {
                lastReturned = listTail;
            } else {
                lastReturned = next.leftNode;
            }
 
            size--;
            nextIndex--;
 
        }
    }
 
    public static void main(String[] args) {
		
		DoublyLinkedList listA = new DoublyLinkedList();
		System.out.print("2010 남아공 월드컵 4강전 : ");
		listA.add(0,"스페인");
		listA.add(1,"독일");
		listA.add(2,"우루과이");
		listA.add(3,"네덜란드");
		System.out.println(listA.displayDoublyLinkedList()+"\n");
		listA.remove(1);
		listA.remove(2);
		System.out.print("2010 남아공 월드컵 결승전 : ");
		System.out.println(listA.displayDoublyLinkedList());
		
	}
}