package DataStructures.hasgtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {

<<<<<<< HEAD
=======

>>>>>>> test
        //创建哈希表
        HashTab hastab=new HashTab(7);
        //写一个简单的菜单
        String key=" ";
        Scanner scanner =new Scanner(System.in);
        while(true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("exit: 退出系统");

            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id=scanner.nextInt();
                    System.out.println("输入名字");
                    String name =scanner.next();
                    //创建雇员
                    Emp emp =new Emp(id,name);
                    hastab.add(emp);
                    break;
                case "list":
                    hastab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
            }



        }



<<<<<<< HEAD
=======

>>>>>>> test
    }
}

//开始创建HashTab 管理多条链表
class HashTab{
    private final int size;
    private EmpLinkedList[] empLinkedListArray;

    //构造器
    public HashTab(int size){
        this.size=size; //表示一共有多少条链表
        //初始化empLinkedListArray
        EmpLinkedList[] empLinkedListArray = new EmpLinkedList[size];
        //留一个坑，这是不要忘记分别初始化每一个链表
        for (int i = 0; i <size; i++) {
            empLinkedListArray[i]=new EmpLinkedList();
        }


    }
    //添加雇员
    public void add(Emp emp){
        //根据员工的ip决定该员工应该加入到那条链表
        int empLinkedListNO=hashFun(emp.id);
        //将emp 添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);

    }
    //遍历所有的链表，遍历Hashtab
    public void list(){
        for(int i=0;i<size;i++){
            empLinkedListArray[i].list();
        }
    }
    //编写一个
    // 散列函数，使用一个简单的取模法
    public int hashFun(int id){
        return id % size;

    }
}

//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next; //指向下一个节点，默认为NULL
    //构造函数
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

//创建EmpLinkedList，表示链表
class EmpLinkedList{
    //头指针执行第一个Emp，因此我们这个的链表的head是直接指向第一个Emp的
    private Emp head; //默认是null

    //添加雇员到链表
    //说明
    //1.假定，当添加雇员时id自增长，即id的分配是从小到大
    //因此我们将雇员直接添加到本链表最后即可
    public void add(Emp emp){
        //如果是第一个雇员
        if(head==null){
            head=emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助指针定位到最后
        Emp curEmp= head;
        while(true){
            if(curEmp.next==null){ //说明链表到了最后
                break;
            }
            curEmp =curEmp.next;//后移
        }
        //退出时直接将emp加入链表
        curEmp.next=emp;
    }

    //遍历雇员信息
    public void list(){
        if(head==null){ //说明链表为空
            System.out.println("当前链表为空");
            return;
        }
        System.out.println("当前链表信息为：");
        Emp curEmp=head;//辅助指针
        while(true){
            System.out.printf("=> id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next==null){ //说明curEmp已经是最后一个节点了
                break;
            }
            curEmp=curEmp.next; //后移，遍历
        }
        System.out.println();
    }
}