package cn.yz.linkedlist;

import java.util.Stack;

/**
 * @author guozy
 * @date 2019/12/7
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "宋江", "呼保义");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
		SingleLinkedList linkedList=new SingleLinkedList();
		linkedList.addByOrder(hero1);
		linkedList.addByOrder(hero3);
		linkedList.addByOrder(hero4);
		linkedList.addByOrder(hero2);
		linkedList.list();
		System.out.println("逆序输出单链表的数据为：");
		reversePrint(linkedList.getHead());
	}

	public static HeroNode test(HeroNode head1,HeroNode head2){
		if(head1.next==null&&head2.next==null){
			return null;
		}
		HeroNode newNode=new HeroNode(0,"","");

		return null;
	}

	/**
	 * 逆序输出单链表数据
	 * @param head
	 */
	public static void reversePrint(HeroNode head){
		if(head.next==null){
			return;
		}
		HeroNode cur=head.next;
		Stack<HeroNode> stack=new Stack<>();
		while (cur!=null){
			stack.push(cur);
			cur=cur.next;
		}
		while (stack.size()>0){
			System.out.println(stack.pop());
		}
	}

	/**
	 * 翻转单链表
	 * @param head
	 */
	public static void reverseList(HeroNode head){
		if(head.next==null||head.next.next==null){
			return;
		}
		HeroNode cur=head.next;
		HeroNode next=null;
		HeroNode reverseNode=new HeroNode(0,"","");
		while (cur!=null){
			next=cur.next;
			cur.next=reverseNode.next;
			reverseNode.next=cur;
			cur=next;
		}
		head.next=reverseNode.next;
	}

	/**
	 * 获取单链表的长度
	 * @param head
	 * @return
	 */
	public static int getLength(HeroNode head){
		if(head.next==null){
			return 0;
		}
		HeroNode cur=head.next;
		int length=0;
		while (cur!=null){
			length++;
			cur=cur.next;
		}
		return length;
	}

	/**
	 * 获取单链表的倒数第index个元素
	 * @param head
	 * @param index
	 * @return
	 */
	public static HeroNode findLastIndex(HeroNode head,int index){
		if(head.next==null){
			return null;
		}
		int size=getLength(head);
		if(index<0||index>size){
			return null;
		}
		HeroNode cur=head.next;
		for (int i=0;i<size-index;i++){
			cur=cur.next;
		}
		return cur;
	}
}
class SingleLinkedList {
	HeroNode head=new HeroNode(0,"","");
	public void add(HeroNode heroNode){
		HeroNode temp=head;
		while (true){
			if(temp.next==null){
				break;
			}
			temp=temp.next;
		}
		temp.next=heroNode;
	}
	public HeroNode getHead() {
		return head;
	}
	public void update(HeroNode newHeroNode){
		HeroNode temp=head.next;
		boolean flag=false;
		while (true){
			if(temp==null){
				break;
			}else if(temp.no==newHeroNode.no){
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag){
			temp.name=newHeroNode.name;
			temp.nickName=newHeroNode.nickName;
		}else{
			System.out.printf("没有找到编号为%d的信息，不能修改\n",newHeroNode.no);
		}
	}
	public void delete(int no){
		HeroNode temp=head;
		boolean flag=false;
		while (true){
			if(temp.next==null){
				break;
			}
			if(temp.next.no==no){
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag){
			temp.next=temp.next.next;
		}else{
			System.out.printf("要删除的%d节点不存在\n",no);
		}
	}
	public void addByOrder(HeroNode heroNode){
		HeroNode temp=head;
		boolean flag=false;
		while (true){
			if(temp.next==null){
				break;
			}else if(temp.next.no>heroNode.no){
				break;
			}else if(temp.next.no==heroNode.no){
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag){
			System.out.printf("准备插入的编号%d已经存在，不能重复添加\n",heroNode.no);
		}else{
			heroNode.next=temp.next;
			temp.next=heroNode;
		}
	}
	public void list(){
		if(head.next==null){
			System.out.println("链表为空");
			return;
		}
		HeroNode temp=head.next;
		while (true){
			if(temp==null){
				break;
			}
			System.out.println(temp);
			temp=temp.next;
		}
	}

}
class HeroNode {
	int no;
	String name;
	String nickName;
	HeroNode next;

	public HeroNode(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "HeroNode{" +
				"no=" + no +
				", name='" + name + '\'' +
				", nickName='" + nickName + '\'' +
				'}';
	}
}
