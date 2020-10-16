package Algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {

        //冒泡排序时间复杂度O(n^2)
        //int [] numbers={1,4,3,2,5};

        //测试一下冒泡排序的速度，给80000个数据，测试
        //创建一个80000个随机数组

        int [] numbers=new int[80000];
        for (int i = 0; i <80000; i++) {
            numbers[i]=(int)(Math.random()*80000);//生成一个[0,80000)的随机数
        }
        //System.out.print("排序前：");
       // printmethod(numbers);
        //System.out.println();
        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是="+data1Str);





        //测试冒泡排序
        bubbleSort(numbers);
        //System.out.print("排序后：");
        //printmethod(numbers);
        Date date2=new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是="+data2Str);
    }

    public static void bubbleSort(int[] numbers){

        int temp = 0;
        boolean flag =false;//标识变量，表示是否进行过交换
        for (int j = 0; j <numbers.length-1 ; j++) {

            for(int i=0;i<numbers.length-1-j;i++){

                if(numbers[i]>numbers[i+1]){
                    flag=true;
                    temp=numbers[i];
                    numbers[i]=numbers[i+1];
                    numbers[i+1]=temp;
                }
            }

            //System.out.println();

            if(!flag){ //在一趟排序中，一次交换也没有发生过
                break;

            }else{
                flag=false;//重置flag，进行下次判断
            }
        }




    }


    public static  void printmethod(int[] a) {
        for (int j = 0; j < a.length; j++) {

                System.out.print(a[j] + " ");
            }
    }


}




