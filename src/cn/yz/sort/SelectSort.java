package cn.yz.sort;

import java.util.Arrays;

/**
 * <p>
 *  选择排序
 *  时间复杂度：O(n^2)
 * </p>
 *
 * @author guozy
 * @create 2020/01/17
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arg={3,9,-1,10,-2};
        selectSort(arg);
        System.out.println(Arrays.toString(arg));
    }
    public static void selectSort(int[] arg){
        int min,minIndex;
        for (int i = 0; i < arg.length-1; i++) {
            min=arg[i];
            minIndex=i;
            for (int j = i; j < arg.length; j++) {
                if(min>arg[j]){
                    min=arg[j];
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                arg[minIndex]=arg[i];
                arg[i]=min;
            }
        }
    }
}
