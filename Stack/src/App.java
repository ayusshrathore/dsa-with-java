public class App {
    public static void main(String[] args) throws Exception {
        String str = "abcde";
        var reverser = new StringReverser();
        System.out.println(reverser.reverse(str));

        String string = "(1 + 2)";
        var exp = new Expression(string);
        System.out.println(exp.isBalanced());

        var stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // By default println prints the object's toString() method
        System.out.println(stack);
    }
}
