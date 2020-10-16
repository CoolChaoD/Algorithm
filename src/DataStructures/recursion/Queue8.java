package DataStructures.recursion;

public class Queue8 {
    //先定义一个max表示共有多少个皇后
    int max=8;
    //定义数组array，保存皇后放置位置的结果
    int []array=new int[max];
    public static void main(String[] args) {

    }
    //写一个方法，可以将皇后摆放的位置输出
    private void print(){
        for(int i=0;i< array.length;i++){
            System.out.println(array[i]+" ");
        }
        System.out.println();
    }

}
