package DataStructures.Stack;

public class LinkStack {
    public static void main(String[] args) {

        stack s=new stack();
        s.push(1);
        System.out.println( s.peek());


    }
}


/*java实现链栈*/
class stack{
    //定义节点数据结构
    private class Node{
        public int data;
        public Node next;
        //无参构造函数
        public Node(){}
        public Node(int data,Node next){
            this.next=next;
            this.data=data;
        }
    }
    //栈顶元素
    private Node top_node;
    //元素个数
    private int size;
    //插入数据
    void push(int data){
        top_node=new Node(data,top_node);
        size++;
    }
    //出栈操作
    public int pop(){
        Node oldNode=top_node;
        top_node= top_node.next;
        //释放引用
        oldNode.next=null;
        size--;
        return oldNode.data;
    }
    //返回栈顶的元素但是不出栈
    public int peek(){
        return top_node.data;
    }
    //堆栈的长度
    int getSize(){
        return size;
    }
    //判断链栈是不是空栈
    public boolean empty(){
        return size==0;
    }

}