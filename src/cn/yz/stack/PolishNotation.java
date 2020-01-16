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
       /* String str="30 4 + 5 * 6 - ";
        List<String> list = getListString(str);
        int calculator = calculator(list);*/
        String str="1+((2+3)*4)-5";
        List<String> list = toIndexList(str);
        List<String> listIndex = toListIndex(list);
        System.out.println("中缀表达式为："+list);
        System.out.println("后缀表达式为："+listIndex);

    }
    public static List<String> toListIndex(List<String> list){
        Stack<String> stack=new Stack();
        List<String> arrayList=new ArrayList<>();
        for (String s : list) {
            if(s.matches("\\d+")){
                arrayList.add(s);
            }else if(s.equals("(")){
                stack.push(s);
            }else if(s.equals(")")){
                while (!stack.peek().equals("(")){
                    arrayList.add(stack.pop());
                }
                stack.pop();
            }else{
                while (stack.size()!=0&&(priority(stack.peek())>=priority(s))){
                    arrayList.add(stack.pop());
                }
                stack.push(s);
            }
        }
        while (stack.size()!=0){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
    public static int priority(String oper){
        if(oper.equals("*")||oper.equals("/")){
            return 2;
        }else if(oper.equals("+")||oper.equals("-")){
            return 1;
        }else {
            return 0;
        }
    }
    public static List<String> toIndexList(String str){
        List<String> list=new ArrayList<>();
        int index=0;
        String s="";
        do {
            if(str.charAt(index)<48||str.charAt(index)>57){
                list.add(String.valueOf(str.charAt(index)));
                index++;
            }else{
                s="";
                while (index<str.length()&&(str.charAt(index)>=48&&str.charAt(index)<=57)){
                    s+=str.charAt(index);
                    index++;
                }
                list.add(s);
            }
        }while (index<str.length());
        return list;
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
