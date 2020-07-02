import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
    public T data;
    public BinaryTree<T> leftNode;
    public BinaryTree<T> rightNode;
    public List<BinaryTree> datas;

    public BinaryTree(T data) {
        this(null, null, data);
    }

    public BinaryTree(BinaryTree left, BinaryTree right, T data) {
        this.leftNode = left;
        this.rightNode = right;
        this.data = data;
    }

    public void creat(Object[] objs) {
        datas = new ArrayList<BinaryTree>();
        //        将一个数组的值依次转换为Node节点
        for (Object o : objs) {
            datas.add(new BinaryTree(o));
        }
//        第一个数为根节点
//        root=datas.get(0);
//        建立二叉树
        for (int i = 0; i < objs.length / 2; i++) {
//            左孩子
            datas.get(i).leftNode = datas.get(i * 2 + 1);
//            右孩子
            if (i * 2 + 2 < datas.size()) {//避免偶数的时候 下标越界
                datas.get(i).rightNode = datas.get(i * 2 + 2);
            }
        }
    }
}
