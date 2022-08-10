public class AVLTree {
  private class AVLNode {
    private int height;
    private int value;
    private AVLNode left;
    private AVLNode right;

    AVLNode(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "Value = " + this.value;
    }
  }

  private AVLNode root;

  public void insert(int value) {
    root = insert(root, value);
  }

  private AVLNode insert(AVLNode root, int value) {
    if (root == null)
      return new AVLNode(value);

    if (value < root.value)
      root.left = insert(root.left, value);
    else
      root.right = insert(root.right, value);

    setHeight(root);
    return balance(root);
  }

  private AVLNode rotateleft(AVLNode node) {
    AVLNode newRoot = root.right;
    root.right = newRoot.left;
    newRoot.left = root;

    setHeight(root);
    setHeight(newRoot);
    return newRoot;
  }

  private AVLNode rotateRight(AVLNode node) {
    AVLNode newRoot = root.left;
    root.left = newRoot.right;
    newRoot.right = root;

    setHeight(root);
    setHeight(newRoot);
    return newRoot;
  }

  private void setHeight(AVLNode node) {
    node.height = Math.max(height(node.left), height(node.right)) + 1;
  }

  private AVLNode balance(AVLNode node) {
    if (isLeftHeavy(root)) {
      if (balanceFactor(root.left) < 0)
        root.left = rotateleft(root.left);
      return rotateRight(root);
    }

    else if (isRightHeavy(root)) {
      if (balanceFactor(root.right) > 0)
        root.right = rotateRight(root.right);
      return rotateleft(root);
    }
    return node;
  }

  private boolean isLeftHeavy(AVLNode node) {
    return balanceFactor(node) > 1;
  }

  private boolean isRightHeavy(AVLNode node) {
    return balanceFactor(node) < -1;
  }

  private int balanceFactor(AVLNode node) {
    if (node == null)
      return 0;
    return height(node.left) - height(node.right);
  }

  private int height(AVLNode node) {
    return (node == null) ? -1 : node.height;
  }
}