public class App {
    public static void main(String[] args) throws Exception {
        var list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addFirst(3);
        System.out.println(list.indexOf(3));
    }
}
