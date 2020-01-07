package cn.yz.linkedlist;

/**
 * <p>
 *  约瑟夫问题（单向环形链表）
 * </p>
 *
 * @author guozy
 * @create 2020/01/07
 */
public class Josephus {
    public static void main(String[] args) {
        CircleSingleLinked circleSingleLinked=new CircleSingleLinked();
        circleSingleLinked.addBoy(125);
        circleSingleLinked.showBoy();
        circleSingleLinked.countBoy(10,20,125);
    }
}
class CircleSingleLinked{
    private Boy first=null;
    public void addBoy(int nums){
        if(nums<1){
            System.out.println("编号为负数，不能添加");
            return;
        }
        Boy curBoy=null;
        for (int i = 1; i <= nums ; i++) {
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                first.setNext(boy);
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
            }
            curBoy=boy;
        }
    }

    /**
     * @param startNo   ：开始的节点
     * @param countNum  ：数几下
     * @param nums      ：最初的节点个数
     */
    public void countBoy(int startNo,int countNum, int nums){
        // TODO 先对数据进行校验
        if(first==null||startNo<1||startNo>nums){
            System.out.println("参数错误");
            return;
        }
        // TODO 创建辅助指针，帮助节点出圈
        Boy helper=first;
        // TODO 将辅助节点指向最后一个节点
        while (true){
            if(helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }
        // TODO 报数之前，将首节点和辅助节点移动startNo-1次
        for (int i = 0; i <startNo-1 ; i++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        // TODO 开始报数
        while (true){
            if(helper==first){
                break;
            }
            for (int i = 0; i < countNum-1 ; i++) {
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.printf("出圈的节点为%d \n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后出圈的节点为%d \n",first.getNo());
    }
    public void showBoy(){
        if(first==null){
            System.out.println("环形链表为空");
            return;
        }
        Boy curBoy=first;
        while (true){
            System.out.printf("节点的编号为%d \n",curBoy.getNo());
            if(curBoy.getNext()==first){
                break;
            }
            curBoy=curBoy.getNext();
        }
    }
}
class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no=no;
    }
    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }
}
