package Algorithm.search;

import java.util.Arrays;

public class InsertValueSearch {
    public static void main(String[] args) {
//        int []arr=new int[100];
//        for (int i = 0; i <100 ; i++) {
//            arr[i]=i+1;
//        }
        int []arr={1,4,6,9,3,5,7};
        int index=insertvalueSearch(arr,0,arr.length-1,3);
        System.out.println("index ="+ index);
//        System.out.println(Arrays.toString(arr));
    }

    //编写插值查找算法
    public static int insertvalueSearch(int []arr,int left,int right,int findVal){
        System.out.println("查找次数");
        /*
         * arr 数组
         * left 左边索引
         * right 右边索引
         * findval 查找值
         * return 如果找到，就返回对应的下标，如果没有找到就返回-1
         */
         //注findVal<arr[0]||findVal >arr[arr.length-1])这句话是必须需要的，否则得到的mid的值可能越界
         if(left>right || findVal<arr[0]||findVal >arr[arr.length-1]){
             return -1;
         }
         //求出mid
         int mid=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
         int midVal=arr[mid];
         if(findVal>midVal){//说明应该向右边递归查找
             return insertvalueSearch(arr,mid+1,right,findVal);
         }else if(findVal<midVal){
             return insertvalueSearch(arr,left,mid-1,findVal);
         }else{
             return mid;
         }

    }

}
