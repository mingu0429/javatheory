package linkedList;

//데이터 필드와 링크 필드를 가지는 노드 클래스
class Node {
	String nodeData; // 노드의 데이터
	Node nextNode = null; // 다음 노드를 가리킴

	public Node(String nodeData, Node nextNode) {
		this.nodeData = nodeData;
		this.nextNode = nextNode;
	}
}

public class LinkedList {
	Node listHead; // 리스트의 처음 노드
	Node listTail; // 리스트의 마지막 노드

	public LinkedList() {
		listHead = null;
		listTail = null;
	}

	// 새로운 data를 이용해서 노드에 삽입
	public void insertNode(String data) {
		// 데이터를 이용해서 새로운 노드 생성
		Node inNode = new Node(data, null);

		if (listHead == null) { // 처음으로 노드를 삽입할 경우
			listHead = inNode; // 새로운 노드가 리스트의 첫번째 노드가 되도록 함
		} else { // listTail != null
			listTail.nextNode = inNode; // 마지막 노드 다음에 새로운 노드 삽입
		}
		listTail = inNode; // 삽입 노드를 마지막 노드로 변경
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
		LinkedList listA = new LinkedList();
		System.out.print("2018 러시아 월드컵 4강전 : ");
		listA.insertNode("프랑스");
		listA.insertNode("벨기에");
		listA.insertNode("크로아티아");
		listA.insertNode("잉글랜드");
		listA.displayLinkedList();
		System.out.print("2018 러시아 월드컵 결승전 : ");
		listA.removeNode("벨기에");
		listA.removeNode("잉글랜드");
		listA.displayLinkedList();
	}
}
