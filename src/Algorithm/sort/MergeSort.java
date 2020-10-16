package Algorithm.sort;

import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args) {
        int[] arr ={8,4,5,7,1,3,6,2};
        int[] temp =new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println("归并排序后="+ Arrays.toString(arr));
    }
    //分+合的过程
    private static void mergeSort(int[] arr, int left, int right, int[] temp){
         if(left<right) {
             int mid=(left+right)/2;//中间索引
             //向左递归分解
             mergeSort(arr,left,mid,temp);
             //向右递归分解
             mergeSort(arr,mid+1,right,temp);
             //到合并
             merge(arr,left,mid,right,temp);
         }
    }
    private static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i=left; //初始化i,左边序列的初始索引
        int j=mid+1; //初始化j,右边序列的初始索引
        int t=0;//指向temp数组的当前索引
        //(一)
        //先把左右两边(有序的数据按照规则填充到)temp数组
        //直到左右两边的有序序列，有一边处理完为止
        while(i<=mid&&j<=right){
             if (arr[i]<=arr[j])
             {
                temp[t]=arr[i];
                t+=1;
                i+=1;
            }else{//反之将右边的序列当前元素，填充到temp当中
                 temp[t]=arr[j];
                 t+=1;
                 j+=1;
             }
        }
        //(二)把剩余数据依次填充到temp中
        while(i<=mid){ //表示左边还有剩余，就全部填充到temp
            temp[t]=arr[i];
            t+=1;
            i+=1;
        }
        while(j<=right){ //当右边序列还有剩余元素的时候
            temp[t]=arr[j];
            t+=1;
            j+=1;
        }
        //(三)将temp数组的元素拷贝到arr
        //并不是每次都拷贝所有的
        t=0;
        int templeft=left;//
        //第一次合并时 templeft=0,right=1//templeft=2,right=3//templeft=0,right=3
        //最后一次合并的时候，templeft=0,right=7
        while(templeft<=right){
            arr[templeft]=temp[t];
            t+=1;
            templeft+=1;
        }
    }
}


