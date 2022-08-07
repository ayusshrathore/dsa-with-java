public class App {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        // System.out.println(tree.find(10));
        // tree.traversePreOrder();
        // tree.traverseInOrder();
        // tree.traversePostOrder();
        // System.out.println(tree.height());
        // System.out.println(tree.min());
        tree.printNodesAtDistance(2);
    }
}
