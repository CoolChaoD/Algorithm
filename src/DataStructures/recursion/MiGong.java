package DataStructures.recursion;

public class MiGong {
    public static void main(String[] args) {
        //第一步先创建一个二维数组，模拟迷宫
        //地图
        int[][] map =new int[8][7];
        //使用1 表示墙
        //上下置为1,
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }

        //左右全部置为1
        for(int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        //设置挡板
        map[3][1]=1;
        map[3][2]=1;
        //输出地图
        System.out.println("输出地图的情况");
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay(map,1,1);
        //输出新的地图
        System.out.println("小球标识过的地图为：");
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }
    //使用递归回溯的方法来给小球找路
    /*
     *1、 map 表示地图
     /2、 (i,j) 表示从哪个位置开始找
     /3、 如果找到通路就返回true,否则返回false
     /4、 如果小球能够到map[6][5]说明通路找到
     /5、 约定：当地图的i,j为0时表示该点还未走过，当为1的时候代表墙，若为2表示通路可以走，若为3表示该位置已经走过但是走不通
     /6、 在走迷宫时需要确定一个策略(方法)，下->右->上->左 如果该点走不通再回溯
     */
    public static boolean setWay(int[][]map,int i,int j){
        if(map[6][5]==2){ //通路已经找到ok
            return true;
        }else{
            if(map[i][j]==0){//如果当前这个点还没走过
                //按照策略下-》右-》上-》左 走
                map[i][j]=2;//假设当前点可以走通
                if(setWay(map,i+1,j)){ //向下走
                    return true;

                }else if(setWay(map,i,j+1)){  //向右走
                    return true;
                }else if(setWay(map,i-1,j)){  //向上走
                    return true;
                }else if(setWay(map,i,j-1)){  //向左走
                    return true;
                }else{
                    //说明该点走不通，是死路
                    map[i][j]=3;
                    return false;
                }
            }else {
                //如果map[i][j]!=0,可能是1,2,3
                return false;
            }


            }
        }

    }

