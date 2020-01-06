package cn.yz.queue;

import java.util.Scanner;

/**
 * 模拟队列
 * @author guozy
 * @date 2019/12/6
 */
public class ArrayQueueDemo {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(3);
		char c=' ';
		Scanner scanner=new Scanner(System.in);
		boolean flag=true;
		while (flag){
			System.out.println("s(show)：显示队列");
			System.out.println("e(exit)：退出程序");
			System.out.println("a(add)：添加数据队列");
			System.out.println("g(get)：从队列中取出数据");
			System.out.println("h(head)：查看队列头的数据");
			char key = scanner.next().charAt(0);//接收一个字符
			switch (key){
				case 's':
					queue.showQueue();
					break;
				case 'a':
					System.out.println("请输入一个数据");
					int value=scanner.nextInt();
					try {
						queue.addQueue(value);
					}catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case 'g':
					try {
						int num=queue.getQueue();
						System.out.printf("取出的数据是%d",num);
					}catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case 'h':
					try {
						int num=queue.headQueue();
						System.out.printf("取出的头数据是%d\n",num);
					}catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case 'e':
					scanner.close();
					flag=false;
					break;
				default:
					break;
			}
		}
		System.out.println("程序已退出");

	}
}
class ArrayQueue{
	private int maxSize;
	/**
	 * 指向队列数据头部的前一个位置
	 */
	private int front;
	/**
	 * 指向队列数据的最后一个位置
	 */
	private int rear;
	private int[] arr;
	public ArrayQueue(int arraySize){
		maxSize=arraySize;
		arr=new int[maxSize];
		front=-1;
		rear=-1;
	}
	public boolean isFull(){
		return rear==maxSize-1;
	}
	public boolean isEmpty(){
		return front==rear;
	}
	public void addQueue(int num){
		if(isFull()){
			throw new RuntimeException("队列已满，不可再次添加");
		}
		rear++;
		arr[rear]=num;
	}
	public void showQueue(){
		if(isEmpty()){
			System.out.println("队列为空，没有数据");
			return;
		}
		for (int i=0;i<arr.length;i++){
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}
	public int headQueue(){
		if(isEmpty()){
			throw new RuntimeException("队列为空，没有数据");
		}
		return arr[front+1];
	}
	public int getQueue(){
		if(isEmpty()){
			throw new RuntimeException("队列为空，不能取数据");
		}
		front++;
		return arr[front];
	}
}
