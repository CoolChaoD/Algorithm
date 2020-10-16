package DataStructures.Stack;

public class Calculator {
    public static void main(String[] args) {
        //根据前面的思路，完成表达式的运算
        String expression="70+20*6-2";
        //创建两个栈，一个数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index=0;//用于扫描
        int num1 = 0;
        int num2=0;
        int oper=0;
        int res=0;
        String keepNum=""; //用于拼接多位数
        char ch = ' ';//每次扫描得到的char保存在ch中
        //开始while循环的扫描expersion
        while(true){
            //依次得到expression的每一个字符
            ch=expression.substring(index,index+1).charAt(0); //charAt方法用来返回索引值
            //判断ch是什么，然后做出相应的处理
            if(operStack.isOper(ch)){//如果是运算符
                //判断当前的符号栈是否为空
                if(!operStack.isEmpty()){
                    //1.栈不为空
                    //如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于等于栈中的运算符，就需要从数栈中pop出两个数
                    //再从符号栈中pop出来一个符号进行运算，得到结果，入数栈，当前的操作符入符号栈
                    if(operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=numStack.cal(num1,num2,oper);
                        //将运算的结果入数栈
                        numStack.push(res);
                        //然后简化当前的操作符入数栈
                        operStack.push(ch);
                    }else{
                        //如果当前的操作符优先级大于栈中的操作符直接入栈
                        operStack.push(ch);
                    }
                }else{
                    //如果为空直接入符号栈
                    operStack.push(ch);
                }

            }else{
                //如果是数，则直接入栈
                //numStack.push(ch-48);  //因为扫描到的是字符，因此根据ASCII码表还需要转换成数值型
                //分析思路
                //1.当处理多位数时，不能发现是一个数就直接入栈，因为这个数可能是多位数
                //2.在处理数时，需要向exprexxion表达式index后再看一位，如果是数则继续扫描，如果是符号则入栈
                //因此需要定义一个变量 字符串，用于拼接多位数
                //处理多位数
                keepNum+=ch;

                //如果ch已经是expression的最后一位则直接入栈

                if(index==expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //注意是最后一位不是，index++
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    //注意看最后一位不是index++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈 keepNum="1"或者“123”
                        numStack.push(Integer.parseInt(keepNum));
                        //将keepNum清空
                        keepNum = "";
                    }
                }
            }
            //让index+1,并判断是否扫描到expression最后
            index++;
            if(index>=expression.length()){
                   break;
            }

        }
        //当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        while(true){
            //如果符号栈为空，则计算最后的结果，数栈中只有最后一个数字【结果】
            if(operStack.isEmpty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=numStack.cal(num1,num2,oper);
            numStack.push(res); //入栈
        }
        //将数栈最后的数pop出来，就是结果
        System.out.printf("表达式%s=%d",expression,numStack.pop());
    }
}
//定义一个ArrayStack2表示栈
class ArrayStack2{
    private int maxSize;   //栈的大小
    private int[] stack;   //数组，数组模拟栈，数据就放在该数组
    private int top =-1;   //top代表栈顶，初始化为-1

    //构造器
    public ArrayStack2(int maxSize){
        this.maxSize=maxSize;
        stack=new int[this.maxSize];

    }
    //增加一个方法，可以返回栈顶的值
    public int peek(){
        return stack[top];  //返回栈顶的元素
    }
    //栈满
    public  boolean isFull(){
        return top==maxSize-1;
    }

    //栈空
    public  boolean isEmpty(){
        return top==-1;
    }

    //入栈
    public void push(int value){
        //先判断栈是不是满的
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }

    //出栈将栈顶数据返回
    public int  pop(){
        //先判断栈是否空
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");

        }
        int value=stack[top];
        top--;
        return value;
    }

    //遍历栈,遍历时需要从栈顶开始显示数据
    public void list(){
        if(isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
        //需要从栈顶开始显示数据
        for(int i=top;i>=0;i--){
            System.out.printf("satck[%d]=%d\n",i,stack[i]);
        }
    }

    //返回运算符的优先级，优先级是由程序员来定的，优先级使用数字表示，数字越大则优先级就越高。
    public int priority(int oper){
        if(oper == '*' || oper=='/'){
            return 1;
        }else if(oper =='+' || oper =='-'){
            return 0;
        }else{
            return -1;//假设目前的表达式中只有+ - * /
        }
    }

    //判断是否是一个运算符
    public boolean isOper(char val){
        return val=='+' || val=='-'||val=='*'||val=='/';
    }
    //计算方法
    public int cal(int num1,int num2,int oper){
        int res=0;//res 用于存放计算结果
        switch(oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num1/num2;
                break;
            default:
                break;
        }
        return res;
    }
}
