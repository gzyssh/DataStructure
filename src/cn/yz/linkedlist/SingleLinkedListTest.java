package cn.yz.linkedlist;

/**
 * @author guozy
 * @date 2019/12/7
 */
public class SingleLinkedListTest {
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(8);
		Node node4 = new Node(9);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		Node node5 = new Node(1);
		Node node6 = new Node(3);
		Node node7 = new Node(5);
		Node node8 = new Node(7);
		node5.next=node6;
		node6.next=node7;
		node7.next=node8;
		Node node = order(node1, node5);
		while (node!=null){
			System.out.println(node.no);
			node=node.next;
		}
	}

	public static Node order(Node head1,Node head2){
		if(head1==null||head2==null){
			return head1==null?head2:head1;
		}
		Node head=head1.no<=head2.no?head1:head2;
		Node cur1=head==head1?head1.next:head1;
		Node cur2=head==head2?head2.next:head2;
		Node pre=head;
		while ((cur1!=null)||(cur2!=null)){
			if(cur1==null||cur2==null){
				pre.next=(cur1==null?cur2:cur1);
				break;
			}
			if(cur1.no<=cur2.no){
				pre.next=cur1;
				cur1=cur1.next;
			}else{
				pre.next=cur2;
				cur2=cur2.next;
			}
			pre=pre.next;
		}
		return head;
	}
}
class SingleLinked {
	Node head=new Node(0);

	public Node getHead() {
		return head;
	}
}
class Node {
	int no;
	Node next;

	public Node(int no) {
		this.no = no;
	}
}


