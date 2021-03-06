package circularLinkedList;

public class CircularLinkedList {
	public class Node { //노드 클래스
		   String nodeData;
		   Node nextNode;
		   
		   public Node(){
		      this.nodeData = null;
		      this.nextNode = null;
		   }
		   
		   public Node(String nodeData){
		      this.nodeData = nodeData;
		      this.nextNode = null;
		   }
		   
		   public Node(String nodeData, Node nextData){
		      this.nodeData = nodeData;
		      this.nextNode = nextData;
		      this.nextNode = null;
		   }
		   
		   public String getData(){
		      return this.nodeData;
		   }
		}

	private Node cList;
	 
    public CircularLinkedList() {
        this.cList = null;
    }
 
    //마지막 노드에 삽입할 경우
    void insertLastNode(String str){
        Node node = new Node(str);
        if(cList == null){//cList가 비었을 경우
            cList = node;
            node.nextNode = node;
        }else{
            Node current = cList;
            while(current.nextNode!=cList){
                current = current.nextNode;
            }
            node.nextNode = current.nextNode;
            current.nextNode = node;
        }
    }
 
    //첫번째 노드에 삽입할 경우
    void insertFirstNode(String str){
        Node node = new Node(str);
        if(cList == null){
            cList = node;
        }else{
            Node current = cList;
            while(current.nextNode!=cList){
                current = current.nextNode;
            }
            node.nextNode = current.nextNode;
            current.nextNode = node;
            cList = node;
        }
    }
 
    //중간 노드에 삽입할 경우
    void inserNode(Node pre, String str){
        Node node = new Node(str);
        if(cList == null){
            cList = node;
        }else{
            Node current = cList;
            while(current.nextNode!=pre){
                current = current.nextNode;
            }
            current = current.nextNode;
            node.nextNode = current.nextNode;
            current.nextNode = node;
        }
    }
 
    //마지막 노드를 삭제할 경우
    void removeLastNode(){
        if(cList==null){
            System.out.println("노드가 존재하지 않습니다.");
        }else{
            Node prevNode = cList;
            Node current = cList.nextNode;
            while(current.nextNode!=cList){
                prevNode = current;
                current = current.nextNode;
            }
            prevNode.nextNode = current.nextNode;
        }
    }
 
    //첫번째 노드를 삭제할 경우
    void removeFirstNode(){
        if(cList==null){
            System.out.println("노드가 존재하지 않습니다.");
        }else{
            Node current = cList;
            while(current.nextNode!=cList){
                current = current.nextNode;
            }
            Node old = current.nextNode;
            cList = old.nextNode;
            current.nextNode = cList;
        }
    }
 
    //str을 받아서 노드를 삭제할 경우
    void removeNode(String str){
        Node node = new Node(str);
        if(cList==null){//cList가 비었다면
            System.out.println("노드가 존재하지 않습니다.");
        }else{
            Node prev = cList;
            Node current = cList.nextNode;
            while(current.nodeData!=node.nodeData){
                prev = current;
                current = current.nextNode;
            }
            prev.nextNode = current.nextNode;
        }
    }
 
    void displayCircularList(){//리스트를 출력
        if(cList==null){//cList가 비었다면
            System.out.println("리스트가 없습니다.");
        }else{
            Node current = cList;
            
            while(current.nextNode!=cList){
                System.out.print(current.nodeData + " ");
                current = current.nextNode;
            }
            System.out.print(current.nodeData);
           
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        System.out.print("평일: ");
        list.insertLastNode("월");
        list.insertLastNode("화");
        list.insertLastNode("수");
        list.insertLastNode("목");
        list.insertLastNode("금");
        list.displayCircularList();
        
        System.out.print("일주일: ");
        list.insertFirstNode("일");//처음 노드에 "일" 삽입
        list.insertLastNode("토");
        list.displayCircularList();
        
        System.out.print("주말삭제: ");
        list.removeFirstNode();
        list.removeLastNode();
        list.displayCircularList();
        System.out.print("수요일삭제: ");
        list.removeNode("수");//"수"를 찾아서 삭제
        list.displayCircularList();
     }
}
