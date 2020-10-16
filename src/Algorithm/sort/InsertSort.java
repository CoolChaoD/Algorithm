package Algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {

        //创建一个80000个随机数组
        int[] arr=new int[800000];
        for (int i = 0; i <800000; i++) {
            arr[i]=(int)(Math.random()*800000);//生成一个[0,80000)的随机数
        }
        //int []arr ={4,3,2,1,34,6,9,0};

        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是"+data1Str);

        insertSort(arr);

        Date date2=new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是"+data2Str);
    }



    //插入排序
    public static void insertSort(int[] arr){
        /*
        * 使用for循环简化
        * */

        for (int i = 1; i <arr.length ; i++) {

            //定义待插入的数
            int insertValue = arr[i];
            int insertIndex = i-1; //即arr[1]前面这个数的下标
            //给insertValue找到插入的位置
            //1.说明
            //1.insertIndex>=0保证在给insertValue找插入位置的时候，不越界
            //2.insertValue<arr[insertIndex])待插入的数，说明还没有找到待插入的位置
            //3.将ar#r[insertIndex]后移
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //当退出循环的时候，insertIndex+1
            //判断是否需要赋值
            if(insertIndex+1!=i) {
                arr[insertIndex + 1] = insertValue;
            }
           // System.out.printf("第%d轮插入后的：",i);
           // System.out.println(Arrays.toString(arr));

        }

       /* //使用逐步推导的方法来讲解
        //第一轮
        //定义待插入的数
        int insertValue=arr[1];
        int insertIndex=0; //即arr[1]前面这个数的下标
        //给insertValue找到插入的位置
        //1.说明
        //1.insertIndex>=0保证在给insertValue找插入位置的时候，不越界
        //2.insertValue<arr[insertIndex])待插入的数，说明还没有找到待插入的位置
        //3.将arr[insertIndex]后移
        while(insertIndex>=0 && insertValue<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        //当退出循环的时候，insertIndex+1
        arr[insertIndex+1]=insertValue;
        System.out.print("第1轮插入后：");
        System.out.println(Arrays.toString(arr));


        //第二轮
        insertValue=arr[2];
        insertIndex=2-1; //即arr[1]前面这个数的下标
        //给insertValue找到插入的位置
        //1.说明
        //1.insertIndex>=0保证在给insertValue找插入位置的时候，不越界
        //2.insertValue<arr[insertIndex])待插入的数，说明还没有找到待插入的位置
        //3.将arr[insertIndex]后移
        while(insertIndex>=0 && insertValue<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        //当退出循环的时候，insertIndex+1
        arr[insertIndex+1]=insertValue;
        System.out.print("第2轮插入后：");
        System.out.println(Arrays.toString(arr));

        //第二轮
        insertValue=arr[3];
        insertIndex=3-1; //即arr[1]前面这个数的下标
        //给insertValue找到插入的位置
        //1.说明
        //1.insertIndex>=0保证在给insertValue找插入位置的时候，不越界
        //2.insertValue<arr[insertIndex])待插入的数，说明还没有找到待插入的位置
        //3.将arr[insertIndex]后移
        while(insertIndex>=0 && insertValue<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        //当退出循环的时候，insertIndex+1
        arr[insertIndex+1]=insertValue;
        System.out.print("第3轮插入后：");
        System.out.println(Arrays.toString(arr));*/
    }
}
