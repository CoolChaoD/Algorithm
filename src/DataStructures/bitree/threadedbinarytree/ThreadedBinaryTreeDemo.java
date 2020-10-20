package DataStructures.bitree.threadedbinarytree;

//线索二叉树
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {

    }
}



//定义一个ThreadedBinaryTree 二叉树
class BinaryTree {
    private HeroNode root;

    //为了实现线索化，需要创建要给当前节点的前驱节点的指针
    //pre在递归进行线索化时候，pre总是保留前一个节点
    private HeroNode pre=null;



    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //编写对二叉树进行中序线索化的方法
    //node: 就是当前需要线索化的节点
    public void threadedNodes(HeroNode node){
        //如果node=null，不能线索化
        if(node==null){
            return;
        }
        //1.先线索化左子树
        threadedNodes(node.getLeft());
        //2.线索化当前节点[有难度]
         //处理当前节点的前驱节点
        if(node.getLeft()==null){
            //让当前节点饿做指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型,指向前驱节点
            //以8号节点的来理解
            //8节点的.left=null
            node.setLeftType(1);

        }

        //处理后继节点
        if(pre.getRight()==null&&pre!=null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        //3.再线索化右子树
        threadedNodes(node.getRight());
    }



    //删除节点
    public void delNode(int no){
        if(root!=null){
            //如果只有root一个节点，这里立即判断root是不是要删除的节点
            if(root.getNo()==no){
                root=null;
            }else{
                //递归删除
                root.delNode(no);
            }
        }else{
            System.out.println("空树，不能删除~");
        }

    }
    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }

    }
    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //查找算法
    //1.前序查找
    public HeroNode preOrderSearch(int no){
        if(this.root!=null){
            return  this.root.preOrdersearch(no);
        }else{
            return null;
        }
    }
    //2.中序查找算法
    public HeroNode infixOrderSearch(int no){
        if(this.root!=null){
            return this.root.infixOrderSearch(no);
        }else{
            return null;
        }
    }
    //3.后序查找算法
    public HeroNode postOrderSearch(int no){
        if(this.root!=null){
            return  this.root.postOrderSearch(no);
        }else{
            return null;
        }
    }
}


//先创建HeroNode节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //指向左节点
    private HeroNode right;  //指向右节点


    //说明
    //1.如果lefttype==0则代表指向左子树，如果是1表示指向前驱节点
    //1.如果lefttype==0则代表指向右子树，如果是1表示指向后继节点
    private int leftType;
    private int rightType;


    public int getLeftType() {
        return leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    //构造函数
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    //get set方法
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //节点删除
    //1.如果删除的是叶子节点，则删除该节点
    //2.如果删除的是非叶子节点，则删除该子树
    public void delNode(int no){
        // 1.因为二叉树是单向的，所以我们判断当前子节点是否需要删除，而能去判断当前这个节点是不是需要删除节；
        // 2.如果当前节点的左子节点不为空，并且左子节点的编号就是要删除的节点，就将this.left=null，就结束递归;
        // 3.如果当前节点的右子节点，并右子节点的编号就是要删除的节点，就将this.right=null，就结束递归;
        // 4.如果第二步第三步没有删除节点，那么我们就需要向左子树进行递归删除；
        // 5.如过第四步也没有删除节点，就应当向右子树进行递归删除；
        // 2.如果当前节点的左子节点不为空，并且左子节点的编号就是要删除的节点，就将this.left=null，就结束递归;
        if(this.left!=null &&this.left.no==no){
            this.left=null;
            return;
        }
        // 3.如果当前节点的右子节点，并右子节点的编号就是要删除的节点，就将this.right=null，就结束递归;
        if(this.right!=null &&this.right.no==no){
            this.right=null;
            return;
        }
        //4.我们就需要左子树进行递归删除
        if(this.left!=null){
            this.left.delNode(no);
        }
        //5.则应当向右子树进行递归删除
        if(this.right!=null){
            this.right.delNode(no);
        }



    }



    //编写前序遍历的方法
    public void preOrder() {
        System.out.println(this); //先输出父节点
        //递归向左子树遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }
    //前序查找
    public HeroNode preOrdersearch(int no){
        System.out.println("进入前序遍历");
        //比较当前节点是不是要查找的节点
        if(this.no==no){
            return this;
        }
        //1.判断当前节点的左子节点是否为空，如果不是空，则递归前序查找
        //2.如果左递归前序查找，找到节点则返回
        HeroNode resNode =null;
        if(this.left!=null){
            resNode=this.left.preOrdersearch(no);
        }
        if(resNode!=null){ //说明左子树已经找到了节点
            return resNode;
        }
        //1.左递归其前序查找，找到节点在，则返回，否则继续判断
        //2.当前节点的右子节点是否为空，如果不为空，则继续向右递归查找
        if(this.right!=null){
            resNode=this.right.preOrdersearch(no);
        }
        return  resNode;
    }

    //中序查找
    public HeroNode infixOrderSearch(int no){
        //1.判断当前节点的左子节点是否为空，如果不是空则递归中序查找
        HeroNode resNode=null;
        if(this.left!=null){
            resNode =this.left.infixOrderSearch(no);
        }
        if(resNode!=null){ //如果不为空，说明在左子节点找到的相应的数据，因此返回
            return resNode;
        }
        //2.判断当前节点的值是否等于要查找的值
        System.out.println("进入中序查找");
        if(this.no==no){
            return this;
        }
        //3.再判断右子节点的值是否为空，如果不是空那么递归中序遍历右子节点
        if(this.right!=null){
            resNode=this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no){

        //1.先判断当前节点的左子节点是否为空，如果不为空则个递归查找
        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.postOrderSearch(no);
        }
        if(resNode!=null){ //说明在左子节点已经找到
            return resNode;
        }
        //2.然后再判断子节点是否为空，如果不为空，则递归查找右子节点
        if(this.right!=null){
            resNode=this.right.postOrderSearch(no);
        }
        if(this.right!=null){
            return resNode;
        }
        System.out.println("进入后序查找");
        //3.如果左右子树都没找到，就开始查找当前节点
        if(this.no==no){
            return  this;
        }
        return resNode;
    }

}
