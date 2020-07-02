import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class btree<T> {
    private btree left,right;
    private T value;
    public btree(T value) {
        this.value = value;
    }

    public btree( T value, btree left, btree right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public static void inorder(btree root) {
        if(root!=null){
            inorder(root.left);
            System.out.println(root.value);
            inorder(root.right);
        }
    }

    // 递归
    public static void preorderdigui(btree data) {
        if (data != null) {
            System.out.println(data.value);
            preorderdigui(data.left);
            preorderdigui(data.right);
        }

    }

    // 非递归

    public static void  preOrder(btree data) {
        List list = new ArrayList<>();
        Stack<btree> stack = new Stack<>();
        while (data != null || !stack.isEmpty()) {
            while (data != null) {
                list.add(data.value);
                System.out.println(data.value);
                stack.push(data);
                data = data.left;
            }
            if (!stack.isEmpty()) {
                btree pop = stack.pop();
                data = pop.right;
            }
        }
    }

    // 中序 非递归
    public static void inordernodigui(btree data) {
        Stack<btree> stack = new Stack<>();
        while (data != null || !stack.isEmpty()) {
            while (data != null) {
                stack.push(data);
                data = data.left;
            }
            if (!stack.isEmpty()) {
                btree pop = stack.pop();
                System.out.println(pop.value);
                data = pop.right;
            }
        }
    }

    public static void behideOrderNodigui(btree data) {
        Stack<btree> stack = new Stack<>();
        while (data != null || !stack.isEmpty()) {
            while (data != null) {
                stack.push(data);
                data = data.left;
            }
            boolean tag = true;
            btree preNode = null;
            while (!stack.isEmpty() && tag) {
                data = stack.peek();
                // 上一次打印的节点 preNode
                if (data.right == preNode) {
                    data = stack.pop();
                    System.out.println(data.value);
                    if (stack.isEmpty()) {
                        return;
                    } else {
                        preNode = data;
                    }
                } else {
                    tag = false;
                    data = data.right;
                }
            }
        }
    }

    public static void backdigui(btree data) {
        if (data != null) {
            backdigui(data.left);
            backdigui(data.right);
            System.out.println(data.value);
        }
    }

    public static void main(String[] args) {
        btree e = new btree(1);
        btree g = new btree(2);
        btree h = new btree(3);
        btree i = new btree(4);
        btree d = new btree(5,null,g);
        btree f = new btree(6,h,i);
        btree b = new btree(7,d,e);
        btree c = new btree(8,f,null);
        btree root = new btree(9,b,c);
        backdigui(root);
        System.out.println("=======");
        behideOrderNodigui(root);
    }
}

//
