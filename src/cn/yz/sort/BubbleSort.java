package cn.yz.sort;

import java.util.Arrays;

/**
 * <p>
 *  冒泡排序
 *  时间复杂度：O(n^2)
 * </p>
 *
 * @author guozy
 * @create 2020/01/17
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arg={3,9,-1,10,-2};
        sort(arg);
        System.out.println(Arrays.toString(arg));
    }
    public static void sort(int[] arg){
        int t;
        boolean flag;
        for (int i = 0; i < arg.length-1; i++) {
            flag=false;
            for (int j = 0; j < arg.length-1-i; j++) {
                if(arg[j]>arg[j+1]){
                    t=arg[j];
                    arg[j]=arg[j+1];
                    arg[j+1]=t;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
