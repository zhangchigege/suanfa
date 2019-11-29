package treeModul;/**
 * @program: suamfa
 * @description: 树结构
 * @author: ZhangChi
 * @create: 2019-11-29 09:34
 **/

/**
 * @program: suamfa
 * @description: 树结构
 * @author: ZhangChi
 * @create: 2019-11-29 09:34
 **/
public class BinaryTreeDemo {

    public static void main(String[] args) {
        // 创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        // 创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "林冲");
        HeroNode node4 = new HeroNode(4, "武松");

        // 先手动创建该二叉树,后面以递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);

        binaryTree.setRoot(root);
        System.out.println("前序遍历:");
        binaryTree.preOrder();
        System.out.println("中序遍历:");
        binaryTree.infixOrder();
        System.out.println("后续  遍历:");
        binaryTree.postOrder();
    }
}

// 定义二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //  前序遍历
    void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }

    }

    void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }

    }

    void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }
}

// 创建根节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; // 默认为null
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // 编写前序遍历方法
    void preOrder() {
        System.out.println(this); // 输出父节点
        // 递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        // 递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序
    void infixOrder() {
        // 递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        // 输出父节点
        System.out.println(this);
        // 递归向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序
    void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }
}


