public class Tree {
  private class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "Node = " + value;
    }
  }

  private Node root;

  public void insert(int value) {
    Node node = new Node(value);
    if (root == null) {
      root = node;
      return;
    }

    Node current = root;
    while (true) {
      if (value < current.value) {
        if (current.left == null) {
          current.left = node;
          break;
        }
        current = current.left;
      } else {
        if (current.right == null) {
          current.right = node;
          break;
        }
        current = current.right;
      }
    }
  }

  public boolean find(int value) {
    Node current = root;
    while (current != null) {
      if (value == current.value)
        return true;
      if (value < current.value)
        current = current.left;
      else {
        current = current.right;
      }
    }
    return false;
  }

  public void traversePreOrder() {
    traversePreOrder(root);
  }

  private void traversePreOrder(Node root) {
    if (root == null)
      return;
    System.out.println(root.value);
    traversePreOrder(root.left);
    traversePreOrder(root.right);
  }

  public void traverseInOrder() {
    traverseInOrder(root);
  }

  private void traverseInOrder(Node root) {
    if (root == null)
      return;
    traverseInOrder(root.left);
    System.out.println(root.value);
    traverseInOrder(root.right);
  }

  public void traversePostOrder() {
    traversePostOrder(root);
  }

  private void traversePostOrder(Node root) {
    if (root == null)
      return;
    traversePostOrder(root.left);
    traversePostOrder(root.right);
    System.out.println(root.value);
  }

  public int height() {
    return height(root);
  }

  private int height(Node root) {
    if (root == null)
      return -1;
    if (isLeaf(root))
      return 0;
    return 1 + Math.max(height(root.left), height(root.right));
  }

  private boolean isLeaf(Node node) {
    return node.left == null && node.right == null;
  }

  public int min() {
    // return min(root);
    // O(log n) - Time complexity for min value in binary tree
    if (root == null)
      throw new IllegalStateException();
    var current = root;
    var last = current;
    while (current != null) {
      last = current;
      current = current.left;
    }
    return last.value;
  }

  // O(n)
  private int min(Node root) {
    if (isLeaf(root))
      return root.value;
    var left = min(root.left);
    var right = min(root.right);

    return Math.min(Math.min(left, right), root.value);
  }

  public boolean equals(Tree tree) {
    if (tree == null)
      return false;
    return equals(root, tree.root);
  }

  private boolean equals(Node first, Node second) {
    if (first == null && second == null)
      return true;
    if (first != null && second != null)
      // Comparing root first then left sub-tree and right sub-tree.
      return first.value == second.value && equals(first.left, second.right) && equals(first.right, second.left);
    return false;
  }

  public boolean isBinarySearchTree() {
    return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBinarySearchTree(Node root, int min, int max) {
    if (root == null)
      return true;

    if (root.value < min || root.value > max)
      return false;

    return isBinarySearchTree(root.left, min, root.value - 1) &&
        isBinarySearchTree(root.right, root.value + 1, max);
  }

  public void printNodesAtDistance(int distance) {
    printNodesAtDistance(root, distance);
  }

  private void printNodesAtDistance(Node root, int distance) {
    if (root == null)
      return;

    if (distance == 0) {
      System.out.println(root.value);
      return;
    }
    printNodesAtDistance(root.left, distance - 1);
    printNodesAtDistance(root.right, distance - 1);
  }
  // Level order traversal can be done by getting nodes at a distance and then
  // printing the values
  // of the nodes.
}