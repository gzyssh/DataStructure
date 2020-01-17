package cn.yz.sort;

import java.util.Arrays;

/**
 * <p>
 *  插入排序
 * </p>
 *
 * @author guozy
 * @create 2020/01/17
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arg={101,34,119,1,-1,89};
        insertSort(arg);
        System.out.println(Arrays.toString(arg));
    }
    public static void insertSort(int[] arg){
        int insertIndex,insertVal;
        for (int i = 1; i < arg.length; i++) {
            insertIndex=i-1;
            insertVal=arg[i];
            while (insertIndex>=0&&insertVal<arg[insertIndex]){
                arg[insertIndex+1]=arg[insertIndex];
                insertIndex--;
            }
            if(insertIndex+1!=i){
                arg[insertIndex+1]=insertVal;
            }
        }
    }
}
