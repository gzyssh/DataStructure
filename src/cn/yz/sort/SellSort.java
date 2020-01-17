package cn.yz.sort;

import java.util.Arrays;

/**
 * <p>
 *  希尔排序-交换式
 * </p>
 *
 * @author guozy
 * @create 2020/01/17
 */
public class SellSort {
    public static void main(String[] args) {
        int[] ary={8,9,1,7,2,3,5,4,6,0};
        sellSort(ary);
        System.out.println(Arrays.toString(ary));
    }
    public static void sellSort(int[] ary){
        int temp;
        for (int gap=ary.length/2;gap>0;gap/=2){
            for (int i = gap; i < ary.length; i++) {
                for (int j = i-gap; j >=0 ; j-=gap) {
                    if(ary[j]>ary[j+gap]){
                        temp=ary[j];
                        ary[j]=ary[j+gap];
                        ary[j+gap]=temp;
                    }
                }
            }
        }
    }
}
