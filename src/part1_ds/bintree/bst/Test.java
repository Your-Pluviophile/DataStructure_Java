package part1_ds.bintree.bst;

public class Test {
    public static void main(String[] args) {
        MyBinarySearchTree bst = new MyBinarySearchTree();
        bst.add(41);
        bst.add(22);
        bst.add(58);
        bst.add(33);
        bst.add(50);
        bst.add(31);
        bst.add(42);
        bst.add(53);
        System.out.println(bst);
    }
}
