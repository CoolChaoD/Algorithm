package DataStructures.linkedlist;

import java.util.Stack;

public class SingleLinkedLIst {
    public static void main(String[] args) {

       //进行测试
        //先创就按节点
        HeroNode hero1=new HeroNode(1,"宋江","及时雨");
        HeroNode hero2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3=new HeroNode(3,"吴用","智多星");
        HeroNode hero4=new HeroNode(4,"林冲","豹子头");

        //创建链表
        SingleList singleList =new SingleList();

        //加入
        singleList.add2(hero1);
        singleList.add2(hero4);
        singleList.add2(hero2);
        singleList.add2(hero3);
       // singleList.add2(hero3);
        singleList.list();
        //

/*        //测试修改节点的代码
        System.out.println("修改后的链表情况");
        HeroNode newHeroNode =new HeroNode(2,"小卢","玉麒麟~");
        singleList.update(newHeroNode);
        singleList.list();
        //删除节点
        singleList.del(1);
        singleList.del(4);
        System.out.println("删除后链表的情况");
        singleList.list();

        //求节点的个数
        System.out.println(getLength(singleList.getHead()));


        //测试一下是否得到倒数第k个节点
        HeroNode result=findLastIndexNode(singleList.getHead(),1);
        System.out.println("倒数第一个："+result);*/
//        System.out.println("======================反转后====================");
///*        System.out.println("====================老师的解答===================");
//        reversetList(singleList.getHead());
//        singleList.list();*/
//        //System.out.println("====================我的解答===================");
//        reverseMy(singleList.getHead());
//        singleList.list();
    }


    //逆序打印单链表【百度面试题】
    //利用栈的方式解决
    public static void reversPrint(HeroNode head){
        if(head.next==null){
            return;//空链表无法打印
        }
        //创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur=head.next;
        //将链表的所有节点压入栈中
        while(cur!=null){
            stack.push(cur);
            cur=cur.next; //让cur后移
        }
        //栈中的节点进行打印，pop
        while(stack.size()>0){
            System.out.println(stack.pop()); //栈的特点是先进后出
        }
    }








    //单链表的反转【腾讯面试题，有点难度】
    public static  void reversetList(HeroNode head) {
        //如果当前链表为空，或者最有一个节点无须反转
        if(head.next==null||head.next.next==null){
            return;
        }
         //定义一个辅助(变量)，帮助我们遍历原来的链表
        HeroNode  cur=head.next;
        HeroNode next=null;//指向当前节点的下一个节点
        HeroNode reverseHead=new HeroNode(0,"","");

        //遍历原来的链表，每遍历一个节点就将其取出
        while(cur!=null){
            next=cur.next; //先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next=reverseHead.next;//将cur的下一个节点指向新链表的最前端
            reverseHead.next=cur;//将current连接到新的链表上
            cur=next;
        }
        //将head.next指向reverseHead.next,实现了单链表的反转
        head.next=reverseHead.next;

    }


    //我的单链表反转
    public static void reverseMy(HeroNode head){
        HeroNode curRear=head.next; //尾部指针
        HeroNode curFront=head.next;//头部指针

        //链表如果为空，或者这有一个节点，那么久不变
        if(head.next==null||head.next.next==null){
            return;
        }

        //curRear游标移动到尾部
        while(curRear.next!=null){
            curRear=curRear.next;
        }
        int size=getLength(head);
        HeroNode temp;
        for (int i = 0; i <size-1 ; i++) {
            if(i==0){
                curRear.next=head.next;
                head.next=curFront.next;
                curFront=curFront.next;
                curRear.next.next=null;
            }
            else {
                temp = curRear.next;
                curRear.next = head.next;
                head.next = curFront.next;
                curFront = curFront.next;
                curRear.next.next = temp;

            }
        }


    }













    //查找单链表中倒数第K个节点【新浪面试题】
    /*
    1.编写一个方法接收head节点，同时接收一个index(表示倒数第index节点)
    2.先把链表从头到尾遍历以下，得到链表的总的长度
    3.得到size后，我们从链表第一个开始遍历(size-index)个,就可以得到
    4.如果找到了返回该节点，否则返回null
    * */
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        //判断如果链表为空，返回null
        if(head.next==null){
            return null; //没有找到
        }
        //第一个遍地得到链表的长度
        int size=getLength(head);
        //第二次遍历 size=index位置，就是我们倒数第k个节点
        //先做一个index校验
        if(index<=0||index >size){
            return null;

        }
        //定义一个辅助变量,for循环定位到倒数的index
        HeroNode cur=head.next;
        for(int i=0;i<size-index;i++){
            cur=cur.next;
        }

        return cur;


    }

    //方法:获取单链表节点的个数(如果是带头结点的链表，需要不统计这个头结点)

    /**
     *
     * @param ：链表的头结点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head){
          if(head.next==null){ //空链表
              return 0;
          }
          int length=0;
          //定义一个辅助变量
        HeroNode cur=head.next;
        while(cur!=null){
            length++;
            cur=cur.next;//遍历
        }
        return length;
    }
}

//创建一个SingleList,管理我们的英雄
class SingleList{
    //先初始化一个头结点，头结点不要动,不存放具体的数据
    private HeroNode head =new HeroNode(0,"","");

    //返回头结点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单项链表
    //当不考虑编号的顺序时，找到当前链表最后的节点，将最后的节点的next域指向新的节点即可
    public void add(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助变量temp;
        HeroNode temp=head;
        //遍历链表找到最后
        while(true){
            //找到链表的最后
            if(temp.next==null){
                break;
            }
            //如果没有找到最后,让temp后移
            temp=temp.next;
        }
        //当退出while循环时候temp就指向链表的最后
        temp.next=heroNode;

    }

    //第二种添加方法 第二种添加英雄时，可以根据排名将英雄插入到指定的位置(如果编号已经存在则插入不了)

    public void add2(HeroNode heroNode){
        //因为头部节点不能动，因此我们仍然通过一个辅助变量来帮助找到添加的位置
        //因为是单链表，因此我们找的位置是位于添加位置的前一个节点，否则加入不了
        HeroNode temp =head;
        boolean flag =false;  //标志添加的编号是否存在，默认为false
        while(true) {
            if (temp.next == null) { //说明temp已经位于最后
                break;
            }
            if(temp.next.no>heroNode.no){ //位置就找到了，就在temp的后面
                break;

            }
            else if(temp.next.no==heroNode.no){ //说明希望添加的heroNode的编号已经存在
                flag =true;//说明编号存在
                break;

            }
            temp=temp.next; //遍历当前的链表

        }
        //判断flag的值
        if(flag){ //不能添加，说明编号已经存在
            System.out.printf("准备插入的英雄编号%d已经存在了，不能加入\n",heroNode.no);

        }else{
            //插入到链表，在temp后面
            heroNode.next=temp.next;
            temp.next=heroNode;
        }

    }

    // 修改节点信息，根据no编号类修改，即no编号不能修改
    //1.根据newHeroNode 的no来修改即可
    public void update(HeroNode newHeroNode){
        //判断是否为空
        if(head.next==null){
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点，根据no编号
        //限定一个辅助变量
        HeroNode temp =head.next;
        boolean flag =false; //表示是否找到该节点
        while(true){
            if(temp==null){
                break;//到链表的最后，已经遍历完链表
            }
            if(temp.no==newHeroNode.no){
                //找到
                flag=true;
                break;
            }
            temp=temp.next;

        }
        //根据flag判断是否找到要修改的节点
        if(flag==true){
            temp.name=newHeroNode.name;
            temp.nickname=newHeroNode.nickname;
        }else{
            //没有找到这个节点
            System.out.printf("没有找到 编号%d 的节点，不能修改\n",newHeroNode.no);

        }
    }

    //删除节点
    //思路
    //1.head接地那不能动，因此我们需要temp辅助节点找到待删除节点的前一个节点
    //2.说明：我们在比较时，是将temp.next,no和需要删除的节点的no进行比较。
    public void del(int no){
        HeroNode temp=head;
        boolean flag=false;//标志是否找到待删除节点
        while(true){
            if(temp.next==null){  //已经到链表最后了
                break;
            }
            if(temp.next.no==no){
                //找到待删除节点的前一个节点temp;
                flag=true;
                break;
            }
            temp=temp.next;//temp后移，实现遍历
        }
        if(flag){
            temp.next=temp.next.next;
        }else{
            System.out.printf("要删除的%d 节点不存在\n",no);
        }
    }
    //显示链表 遍历no
    public void list(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp =head.next;
        while(true){
            if(temp==null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移
            temp=temp.next;
        }

    }

}




//首先定义一个heronode对象，每一个heronode对象就是一个节点

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;  //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方便，重写toString方法
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
