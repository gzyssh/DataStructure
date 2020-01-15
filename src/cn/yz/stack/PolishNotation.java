package cn.yz.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 *  逆波兰表达式
 * </p>
 *
 * @author guozy
 * @create 2020/01/14
 */
public class PolishNotation {
    public static void main(String[] args) {
        String str="30 4 + 5 * 6 - ";
        List<String> list = getListString(str);
        int calculator = calculator(list);
        System.out.printf("表达式：%s=%d\n",str,calculator);

    }
    public static List<String> getListString(String str){
        String[] split = str.split(" ");
        List<String> list=new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }
    public static int calculator(List<String> list){
        Stack<String> stack=new Stack<>();
        for (String s : list) {
            if(s.matches("\\d+")){
                stack.push(s);
            }else{
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if(s.equals("+")){
                    res=num1+num2;
                }else if(s.equals("-")){
                    res=num1-num2;
                }else if(s.equals("*")){
                    res=num1*num2;
                }else if(s.equals("/")){
                    res=num1/num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
