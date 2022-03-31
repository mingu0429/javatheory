package doublyLinkedList;

/*//데이터 필드와 링크 필드를 가지는 노드 클래스
class Node {
	String nodeData; // 노드의 데이터
	Node nextNode = null; // 다음 노드를 가리킴
	Node prevNode = null; // 이전 노드를 가리킴
	

	public Node(String nodeData, Node nextNode, Node prevNode) {
		this.nodeData = nodeData;
		this.nextNode = nextNode;
		this.prevNode = prevNode;
	}
}

public class DoublyLinkedList {
	Node listHead; // 리스트의 처음 노드
	Node listTail; // 리스트의 마지막 노드
	int size = 0;

	public DoublyLinkedList() {
		listHead = null;
		listTail = null;
	}

	// 새로운 data를 이용해서 첫번째에 삽입
	public void firstinsertNode(String data) {
		// 데이터를 이용해서 새로운 노드 생성
		Node inNode = new Node(data, null, null);
		inNode.nextNode = listHead;
		
		if (listHead == null) { // 처음으로 노드를 삽입할 경우
			listHead = inNode; // 새로운 노드가 리스트의 첫번째 노드가 되도록 함
			listTail= inNode;
		} else { //리스트가 존재 한다면
			listHead.prevNode = inNode;
		}
		
	}
	// 특정 노드에 삽입
	public void addinsertNode(int index, String data) {	
		if(index == 0) {//만약 첫번째에 삽입하고 싶다면
			firstinsertNode(data);
			return;
		}
		Node inNode = new Node(data, null, null);
		
		
	}

	// listHead 노드에서 listTail 노드까지 nodeData값 출력
	public void displayLinkedList() {
		for (Node current = listHead; current != null; current = current.nextNode) {
			System.out.print(current.nodeData + "  ");
		}
		System.out.println("\n");
	}

	// nodeData 값을 이용해서 노드를 삭제
	public void removeNode(String data) {
		Node remove = null; // 삭제할 노드
		Node before = null; // 삭제할 노드 바로 전 노드

		// listHead로 시작해서 다음노드가 null일 때까지
		for (remove = listHead; remove != null; before = remove, remove = remove.nextNode) {
			// 링크드 리스트를 순회하면서 삭제할 노드의 nodeData와 값을 비교한다
			if (remove.nodeData == data) {
				// 첫 번째 노드를 삭제할 경우
				if (remove == listHead) {
					if (listTail == listHead)
						listTail = remove.nextNode; // 단일 노드 리스트
					listHead = remove.nextNode; // remove 다음 노드를 listHead 노드로 설정
					break;
				}
				// 마지막 노드를 삭제할 경우
				else if (remove == listTail) {
					listTail = before; // before 노드를 listTail 노드로 변경
					listTail.nextNode = null; // 마지막 노드의 nextNode에 null 입력
					break;
				}
				// 첫 번째 노드와 마지막 노드가 아닌 경우
				before.nextNode = remove.nextNode;
				// remove 앞 노드가 remove 다음 노드를 가리킴
				// 즉, remove 노드 삭제
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("\n");
		DoublyLinkedList listA = new DoublyLinkedList();
		System.out.print("2018 러시아 월드컵 4강전 : ");
		listA.firstinsertNode("프랑스");
		listA.firstinsertNode("벨기에");
		listA.firstinsertNode("크로아티아");
		listA.firstinsertNode("잉글랜드");
		listA.displayLinkedList();
		System.out.print("2018 러시아 월드컵 결승전 : ");
		listA.removeNode("벨기에");
		listA.removeNode("잉글랜드");
		listA.displayLinkedList();
	}
}*/





public class DoublyLinkedList {
    // 첫번째 노드를 가리키는 필드
    private Node head;
    private Node tail;
    private int size = 0;
 
    private class Node {
        // 데이터가 저장될 필드
        private Object data;
        // 다음 노드를 가리키는 필드
        private Node next;
        private Node prev;
 
        public Node(Object input) {
            this.data = input;
            this.next = null;
            this.prev = null;
        }
 
        // 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
        public String toString() {
            return String.valueOf(this.data);
        }
    }
 
    public void addFirst(Object input) {
        // 노드를 생성합니다.
        Node newNode = new Node(input);
        // 새로운 노드의 다음 노드로 헤드를 지정합니다.
        newNode.next = head;
        // 기존에 노드가 있었다면 현재 헤드의 이전 노드로 새로운 노드를 지정합니다.
        if (head != null)
            head.prev = newNode;
        // 헤드로 새로운 노드를 지정합니다.
        head = newNode;
        size++;
        if (head.next == null) {
            tail = head;
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
            tail.next = newNode;
            // 새로운 노드의 이전 노드로 tail을 지정합니다.
            newNode.prev = tail;
            // 마지막 노드를 갱신합니다.
            tail = newNode;
            // 엘리먼트의 개수를 1 증가 시킵니다.
            size++;
        }
    }
 
    Node node(int index) {
        // 노드의 인덱스가 전체 노드 수의 반보다 큰지 작은지 계산
        if (index < size / 2) {
            // head부터 next를 이용해서 인덱스에 해당하는 노드를 찾습니다.
            Node x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            // tail부터 prev를 이용해서 인덱스에 해당하는 노드를 찾습니다.
            Node x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
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
            Node temp2 = temp1.next;
            // 새로운 노드를 생성합니다.
            Node newNode = new Node(input);
            // temp1의 다음 노드로 새로운 노드를 지정합니다.
            temp1.next = newNode;
            // 새로운 노드의 다음 노드로 temp2를 지정합니다.
            newNode.next = temp2;
            // temp2의 이전 노드로 새로운 노드를 지정합니다.
            if (temp2 != null)
                temp2.prev = newNode;
            // 새로운 노드의 이전 노드로 temp1을 지정합니다.
            newNode.prev = temp1;
            size++;
            // 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정합니다.
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }
 
    public String toString() {
        // 노드가 없다면 []를 리턴합니다.
        if (head == null) {
            return "[]";
        }
        // 탐색을 시작합니다.
        Node temp = head;
        String str = "[";
        // 다음 노드가 없을 때까지 반복문을 실행합니다.
        // 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됩니다.
        while (temp.next != null) {
            str += temp.data + ",";
            temp = temp.next;
        }
        // 마지막 노드를 출력결과에 포함시킵니다.
        str += temp.data;
        return str + "]";
    }
 
    public Object removeFirst() {
        // 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경합니다.
        Node temp = head;
        head = temp.next;
        // 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담습니다.
        Object returnData = temp.data;
        temp = null;
        // 리스트 내에 노드가 있다면 head의 이전 노드를 null로 지정합니다.
        if (head != null)
            head.prev = null;
        size--;
        return returnData;
    }
 
    public Object remove(int k) {
        if (k == 0)
            return removeFirst();
        // k-1번째 노드를 temp로 지정합니다.
        Node temp = node(k - 1);
        // temp.next를 삭제하기 전에 todoDeleted 변수에 보관합니다.
        Node todoDeleted = temp.next;
        // 삭제 대상 노드를 연결에서 분리합니다.
        temp.next = temp.next.next;
        if (temp.next != null) {
            // 삭제할 노드의 전후 노드를 연결합니다.
            temp.next.prev = temp;
        }
        // 삭제된 노드의 데이터를 리턴하기 위해서 returnData에 데이터를 저장합니다.
        Object returnData = todoDeleted.data;
        // 삭제된 노드가 tail이었다면 tail을 이전 노드를 tail로 지정합니다.
        if (todoDeleted == tail) {
            tail = temp;
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
        Node temp = head;
        // 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용합니다.
        int index = 0;
        // 탐색 값과 탐색 대상의 값을 비교합니다.
        while (temp.data != data) {
            temp = temp.next;
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
            next = head;
            nextIndex = 0;
        }
 
        // 본 메소드를 호출하면 cursor의 참조값이 기존 cursor.next로 변경됩니다.
        public Object next() {
            lastReturned = next;
            next = next.next;
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
                lastReturned = next = tail;
            } else {
                lastReturned = next = next.prev;
            }
            nextIndex--;
            return lastReturned.data;
        }
 
        public void add(Object input) {
            Node newNode = new Node(input);
            if (lastReturned == null) {
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.prev = lastReturned;
                if (next != null) {
                    newNode.next = next;
                    next.prev = newNode;
                } else {
                    tail = newNode;
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
            Node n = lastReturned.next;
            Node p = lastReturned.prev;
 
            if (p == null) {
                head = n;
                head.prev = null;
                lastReturned = null;
            } else {
                p.next = next;
                lastReturned.prev = null;
            }
 
            if (n == null) {
                tail = p;
                tail.next = null;
            } else {
                n.prev = p;
            }
 
            if (next == null) {
                lastReturned = tail;
            } else {
                lastReturned = next.prev;
            }
 
            size--;
            nextIndex--;
 
        }
    }
 
    public static void main(String[] args) {
		System.out.println("\n");
		DoublyLinkedList listA = new DoublyLinkedList();
		System.out.print("2018 러시아 월드컵 4강전 : ");
		listA.add(0,"프랑스");
		listA.add(1,"벨기에");
		listA.add(2,"크로아티아");
		listA.add(3,"잉글랜드");
		listA.toString();
		/*System.out.print("2018 러시아 월드컵 결승전 : ");
		listA.removeNode("벨기에");
		listA.removeNode("잉글랜드");
		listA.displayLinkedList();*/
	}
}