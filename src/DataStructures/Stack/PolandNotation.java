package DataStructures.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {

        //完成将一个中缀表达式转化成后缀表达式的功能
        //说明
        //1.1+((2+3)*4)-5 转换成 1 2 3 + 4 * + 5 -
        //2.直接对str操作不方便，因此先将1+((2+3)*4)-5 转换成一个中缀表达式对应的list,然后对list进行遍历
        //3.将得到的中缀表达式对应的list转成一个后缀表达式对应的list
        String expression="1+((2+3)*4)-5";
        List<String> infixexpressionList=toInixExpressionList(expression);
        System.out.println("中缀表达式对应的List="+infixexpressionList);  // [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        List<String> SuffixExpressionList=parseSuffixExpressionList(infixexpressionList);
        System.out.println("后缀表达式对应的List="+SuffixExpressionList);

       /*
        //先定义一个逆波兰表达式
        //(3+4)*5-6=>3 4 + 5 × 6 -
        //为了说明方便逆波兰表达式中间数字和符号用空格隔开
        String suffixExpression="3 4 + 5 × 6 -";
        //思路
        //1.先将3 4 + 5 × 6 -放入ArrayList当中
        //2.将ArrayList传递给一个方法，遍历ArrayList配合栈完成计算
        List<String> rpnList=getListString(suffixExpression);
        System.out.println("rpnList="+rpnList);
        int res=calculate(rpnList);
        System.out.println("计算的结果是="+res);
        */
    }
    //方法：中缀表达式转换成后缀表达式
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义两个栈
        Stack<String> s1=new Stack<String>();  //符号栈
        //s2这个栈用来存储中间结果，没有pop操作而且还需要逆序输出
        //因此不再使用栈而直接使用列表
        Stack<String> s2= new Stack<String>();  //存储中间结果的栈
        //遍历ls;
        for(String item :ls){
            //如果是一个数，就加入s2
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                //如果是"右括号"，则依次弹出s1的栈顶运算符，并压入s2,直到遇到左括号为止，此时将这一对括号丢弃。
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//!!!将（弹出栈，消除小括号
            }else{
                //当item的优先级小于等于s1的栈顶运算符，将s1栈顶运算符弹出并加入到s2中，再次转到s1与s1的新的栈顶元素相比较
                //问题：缺少一个优先级高低比较的方法
                while(s1.size()!=0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }
        //还需要将item压入栈
        while(s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }
    //方法：将中缀表达式转换成对应的list
    public static List<String> toInixExpressionList(String s){
       //定义一个list存放中缀表达式对应的内用
       List<String> ls =new ArrayList<String>();
       int i=0;//这时是一个指针，用于遍历中缀表达式字符串
        String str;//对多位数进行拼接
        char c;//每遍历到一个字符，就放入到c
        do{
            //如果c是一个非数字，我们就需要加入到ls中
            if((c=s.charAt(i))<48 ||(c=s.charAt(i))>57){
                ls.add(""+c);//转换成字符串
                i++;
            }else{//如果是一个数，需要考虑多位数的问题
                str="";//先将str置成""
                while(i < s.length() && (c=s.charAt(i))>=48 && (c=s.charAt(i))<=57){
                    str += c;//拼接
                    i++;
                }
                ls.add(str);
            }
        }while(i<s.length());
        return ls;
    }

    //将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression){
        //将suffixExpression分割
        String[] spilt =suffixExpression.split(" ");
        List<String> list=new ArrayList<String>();
        for(String ele:spilt){
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的遍历
    public static int calculate(List<String> ls){
        //创建栈，只需要一个栈即可
        Stack<String> stack=new Stack<String>();
        //遍历ls
        for(String item:ls){
            //这里使用正则表达式来取出整数
            if(item.matches("\\d+")){
                //匹配的是多位数
                //入栈
                stack.push(item);
            }else{
                //pop出两个数，并运算，再入栈
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if(item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("-")){
                    res=num1-num2;
                }else if(item.equals("/")){
                    res=num1/num2;
                }else if(item.equals("×")){
                    res=num1*num2;
                }else{
                    throw new RuntimeException("运算符有错误");
                }
                //将res入栈
                stack.push(res+"");
            }
        }
        //最后留在栈里面的数据是运算结果
        return Integer.parseInt(stack.pop());
    }

}


//编写一个类，可以返回一个算符对应的优先级
class Operation {

    private static int ADD =1;
    private static int SUB =1;
    private static int MUL =2;
    private static int DIV =2;

    //写一个方法，返回对应优先级的数字
    public static int getValue(String operation){
        int result =0;
        switch(operation){
            case "+":
                result =ADD;
                break;

            case "-":
                result =SUB;
                break;

            case "*":
                result =MUL;
                break;

            case "/":
                result =DIV;
                break;

            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}