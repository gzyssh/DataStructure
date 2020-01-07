package cn.yz.linkedlist;

/**
 * <p>
 * 双向链表
 * </p>
 *
 * @author guozy
 * @create 2020/01/06
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleHeroNode hero1 = new DoubleHeroNode(1, "宋江", "呼保义");
        DoubleHeroNode hero2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode hero3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode hero4 = new DoubleHeroNode(4, "公孙胜", "入云龙");
        DoubleLinkedList linkedList=new DoubleLinkedList();
        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero3);
        linkedList.list();
    }
}

class DoubleLinkedList {
    DoubleHeroNode head=new DoubleHeroNode(0,"","");
    public void add(DoubleHeroNode doubleHeroNode){
        DoubleHeroNode temp=head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=doubleHeroNode;
        doubleHeroNode.pre=temp;
    }
    public DoubleHeroNode getHead() {
        return head;
    }
    public void addByOrder(DoubleHeroNode newHeroNode){
        DoubleHeroNode temp=head;
        boolean flag=false;
        while (true){
            if(temp.next==null){
                break;
            }else if(temp.next.no>newHeroNode.no){
                break;
            }else if(temp.next.no==newHeroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            System.out.printf("准备插入的编号%d已经存在，不能重复添加\n",newHeroNode.no);
        }else{
            if(temp.next!=null){
              temp.next.pre=newHeroNode;
              newHeroNode.next=temp.next;
            }
            temp.next=newHeroNode;
            newHeroNode.pre=temp;
        }
    }
    public void update(DoubleHeroNode newHeroNode){
        DoubleHeroNode temp=head.next;
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
        DoubleHeroNode temp=head.next;
        boolean flag=false;
        while (true){
            if(temp==null){
                break;
            }
            if(temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.pre.next=temp.next;
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }else{
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        DoubleHeroNode temp=head.next;
        while (true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }

}
class DoubleHeroNode {
    int no;
    String name;
    String nickName;
    DoubleHeroNode pre;
    DoubleHeroNode next;

    public DoubleHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
