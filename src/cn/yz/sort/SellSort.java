package cn.yz.sort;

import java.util.Arrays;

/**
 * <p>
 *  希尔排序
 * </p>
 *
 * @author guozy
 * @create 2020/01/17
 */
public class SellSort {
    public static void main(String[] args) {
        int[] ary={8,9,1,7,2,3,5,4,6,0};
        sellSortTwo(ary);
        System.out.println(Arrays.toString(ary));
    }

    /**
     * 交换式
     * @param ary
     */
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

    /**
     * 移位式
     * @param ary
     */
    public static void sellSortTwo(int[] ary){
        int temp,j;
        for (int gap=ary.length/2;gap>0;gap/=2){
            for (int i = gap; i < ary.length; i++) {
                temp=ary[i];
                j=i;
                while (j-gap>=0&&temp<ary[j-gap]){
                    ary[j]=ary[j-gap];
                    j-=gap;
                }
                if(!(j==i)){
                    ary[j]=temp;
                }
            }
        }
    }
}
