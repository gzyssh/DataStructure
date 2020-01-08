package cn.yz.stack;

/**
 * <p>
 * 模拟栈
 * </p>
 *
 * @author guozy
 * @create 2020/01/07
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack=new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.list();
    }

}
class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top=-1;
    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack=new int[maxSize];
    }
    public boolean isFull(){
        return top==maxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public void push(int value){
        if(isFull()){
            throw new RuntimeException("栈已满,不能添加");
        }
        top++;
        stack[top]=value;
    }
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空，没有数据");
        }
        int value=stack[top];
        top--;
        return value;
    }
    public void list(){
        if(isEmpty()){
            throw new RuntimeException("栈为空，没有数据");
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d \n",i,stack[i]);
        }
    }
}
