package Algorithm.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr ={53,3,542,748,14,214};
        radixSort(arr);

    }
    //基数排序法
    public static void radixSort(int[] arr){
        //第一轮(针对每个元素的个位进行排序处理)
        // 1.定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        // 2.为了防止放入数据的时候，数据溢出，则每一个数组(桶)，大小定为arr.length
        // 3.基数排序用时间换空间
        int[][]bucket =new int[10][arr.length];//创建10个一维数组
        //为了记录每个桶中实际存放了多少个数据，我们定义一个一维数组来记录各个桶的每次存放的数据
        int [] bucketElementCounts=new int[10];
        //第一轮针对每个元素的个位进行处理
        for(int j=0;j<arr.length;j++){
            //取出每个元素的个位值
            int digitOfElement=arr[j]%10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照下面这个顺序(一维数组下标下依次取出数据，放入原来数组)
        int index=0;
        for (int k=0;k<bucketElementCounts.length;k++){
            if(bucketElementCounts[k]!=0){
                //循环该桶即第K个桶(即第k个一维数组)，放入
                for(int l=0;l<bucketElementCounts[k];l++){
                    //取出元素放入到arr
                    arr[index]=bucket[k][l];
                    index++;
                }

            }

        }
        System.out.println("第1轮，对个位数的排序处理 arr="+ Arrays.toString(arr));
    }
}
