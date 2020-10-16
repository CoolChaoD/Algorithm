package Algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {

        //创建一个80000个随机数组
        //int[] arr=new int[8000000];
//        for (int i = 0; i <8000000; i++) {
//            arr[i]=(int)(Math.random()*8000000);//生成一个[0,80000)的随机数
//        }

        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是:"+data1Str);


        int [] arr ={8,9,1,7,2,3,5,4,6,0};
        shellSort2(arr);

        Date date2=new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是:"+data2Str);





    }

    public static void shellSort2(int[] arr){
        int count=0;
        //增量gap逐步缩小变量
        for(int gap=arr.length/2;gap>0;gap/=2){
            //从gap个元素开始对其所在的组进行直接插入排序
            for(int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0&&temp<arr[j-gap]){
                        //移动
                        arr[j] =arr[j-gap];
                        j-=gap;
                    }
                    //当退出while循环的时候，就给temp找到插入的位置
                    arr[j]=temp;
                }

            }
            System.out.println("希尔排序第"+(++count)+"轮后="+ Arrays.toString(arr));
        }


    }

    //使用逐步推导的方法编写shell排序
    public static  void shellSort(int[] arr){
        int temp=0;
        int count=0;
        //根据前面的逐步分析，使用循环处理
        for(int gap=arr.length/2;gap>0;gap/=2){

            //希尔排序的第一轮排序
            //因为第一轮排序是将10个数据分成了gap组,步长为gap
            for(int i=gap;i<arr.length;i++){
                //遍历各组中所有的元素(每组有两个元素)
                for(int j=i-gap;j>=0;j-=gap){
                    //如果当前这个元素大于加上步长后的那个元素说明需要交换
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
            System.out.println("希尔排序第"+(++count)+"轮后="+ Arrays.toString(arr));
        }
    }
}
