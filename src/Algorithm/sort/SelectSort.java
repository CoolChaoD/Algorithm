package Algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
       // int [] arr={101,34,119,1,-1,-3};

        //创建一个80000个随机数组
        int[] arr=new int[80000];
        for (int i = 0; i <80000; i++) {
            arr[i]=(int)(Math.random()*80000);//生成一个[0,80000)的随机数
        }

        //System.out.print("排序前： ");
        //System.out.println(Arrays.toString(arr));

        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是="+data1Str);


        selectSort(arr); //排序
        //System.out.print("排序后： ");
        //System.out.println(Arrays.toString(arr));
        Date date2=new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是="+data2Str);
    }

    //选择排序
    public static void selectSort(int[] arr){

        //在推导的过程中发现了规律因此可以使用一个循环来解决
        //时间复杂度O(n^2)
       for(int j=0;j<arr.length-1;j++)
       {
           int minIndex=j;        //最小数的索引
           int min=arr[minIndex];
           for (int i = j+1; i < arr.length; i++) {
               if(min>arr[i]){ //说明假定的最小值，并不是最小的那一个
                   min=arr[i]; //重置min
                   minIndex=i; //重置minIndex

               }
           }
           //将最小值，放在arr[0]，即交换
           if(minIndex!=j){
               arr[minIndex]=arr[j];
               arr[j]=min;  //把最小值放在第一个位置
           }


//           System.out.printf("第%d轮后：",(j+1));
//           System.out.println(Arrays.toString(arr));

       }


        //使用逐步推导的方式来讲解选择排序
        //第一轮
        //原始数组 101，34,119,1
        //第一轮排序：1,34,119,101
        //算法 先简单--》复杂，可以把一个复杂的算法拆分成简单的问题--》逐步解决

      /*  //第一轮
        int minIndex=0;        //最小数的索引
        int min=arr[minIndex];
        for (int i = 1; i < arr.length; i++) {
            if(min>arr[i]){ //说明假定的最小值，并不是最小的那一个
                min=arr[i]; //重置min
                minIndex=i; //重置minIndex

            }
        }
        //将最小值，放在arr[0]，即交换
        if(minIndex!=0){
            arr[minIndex]=arr[0];
            arr[0]=min;  //把最小值放在第一个位置
        }


        System.out.print("第一轮：");
        System.out.println(Arrays.toString(arr));


        //第2轮
         minIndex=1;        //最小数的索引
         min=arr[minIndex];
        for (int i = 1+1; i < arr.length; i++) {
            if(min>arr[i]){ //说明假定的最小值，并不是最小的那一个
                min=arr[i]; //重置min
                minIndex=i; //重置minIndex

            }
        }
        //将最小值，放在arr[1]，即交换
        if(minIndex!=1){
            arr[minIndex]=arr[1];
            arr[1]=min;  //把最小值放在第一个位置
        }

        System.out.print("第二轮：");
        System.out.println(Arrays.toString(arr));


        //第3轮
        minIndex=2;        //最小数的索引
        min=arr[minIndex];
        for (int i = 2+1; i < arr.length; i++) {
            if(min>arr[i]){ //说明假定的最小值，并不是最小的那一个
                min=arr[i]; //重置min
                minIndex=i; //重置minIndex

            }
        }
        //将最小值，放在arr[2]，即交换
        if(minIndex!=2){
            arr[minIndex]=arr[2];
            arr[2]=min;  //把最小值放在第一个位置
        }
        System.out.print("第三轮：");
        System.out.println(Arrays.toString(arr));*/
    }
}
